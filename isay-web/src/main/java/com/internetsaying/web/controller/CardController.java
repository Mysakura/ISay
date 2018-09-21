package com.internetsaying.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.internetsaying.common.base.BaseJSONPageResponse;
import com.internetsaying.common.base.BasePageResponse;
import com.internetsaying.common.base.BaseResponse;
import com.internetsaying.common.base.dto.UploadDTO;
import com.internetsaying.common.enums.DeleteStatus;
import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.post.dto.StatisticsAreaLabel;
import com.internetsaying.post.dto.StatisticsAreaPost;
import com.internetsaying.post.dto.StatisticsMonthPostNum;
import com.internetsaying.post.entity.AreaLabel;
import com.internetsaying.post.entity.Chat;
import com.internetsaying.post.entity.ChatReply;
import com.internetsaying.post.entity.Classify;
import com.internetsaying.post.entity.Company;
import com.internetsaying.post.entity.CompanyLabel;
import com.internetsaying.post.entity.Post;
import com.internetsaying.post.entity.PostComment;
import com.internetsaying.post.entity.PostShare;
import com.internetsaying.post.entity.SolrPost;
import com.internetsaying.post.entity.Vote;
import com.internetsaying.post.entity.VoteItem;
import com.internetsaying.post.entity.Voter;
import com.internetsaying.post.service.AreaService;
import com.internetsaying.post.service.ChatService;
import com.internetsaying.post.service.ClassifyService;
import com.internetsaying.post.service.CompanyService;
import com.internetsaying.post.service.PostCommentService;
import com.internetsaying.post.service.PostService;
import com.internetsaying.post.service.PostShareService;
import com.internetsaying.post.service.SolrPostService;
import com.internetsaying.post.service.ThrowPotService;
import com.internetsaying.post.service.VoteService;
import com.internetsaying.site.dto.CommonStatistics;
import com.internetsaying.site.dto.PostStatistics;
import com.internetsaying.site.dto.PostTenStatistics;
import com.internetsaying.site.dto.PostUserStatistics;
import com.internetsaying.site.dto.UserStatistics;
import com.internetsaying.site.service.StatisticsService;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.entity.UserCollection;
import com.internetsaying.user.service.UserCollectionService;
import com.internetsaying.utils.IDUtils;
import com.internetsaying.utils.PageUtils;
import com.internetsaying.utils.PostUtils;
import com.internetsaying.utils.UploadFileUtils;
import com.internetsaying.web.types.AreaType;
import com.internetsaying.web.types.ClassifyType;

/**
 * 
 * 模块名称：帖子
 *
 * @author 董昕杰
 * @since 2017年12月30日
 */
@Controller
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private ClassifyService classifyService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private PostCommentService postCommentService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ThrowPotService throwPotService;
	
	@Autowired
	private VoteService voteService;
	
	@Autowired
	private UserCollectionService userCollectionService;
	
	@Autowired
	private PostShareService postShareService;
	
	@Autowired
	private StatisticsService statisticsService;
	
	@Autowired
	private SolrPostService solrPostService;
	
	private static Logger log = LoggerFactory.getLogger(CardController.class);

	/**
	 * 全局验证用户，不存在就抛异常
	 * @param session
	 * @return
	 */
	private User globalCheckUser(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null)
			throw new CommonException(ExceptionEnum.LOGIN_INFO_OVERDUE.code, ExceptionEnum.LOGIN_INFO_OVERDUE.msg);
		return user;
	}
	
	/**
	 * 全局通用的查询分类下面的帖子
	 * @param classifyName
	 * @param type
	 * @param page
	 * @return
	 */
	private void globalDeal(String classifyName, int type, int page, Map<String, Object> map){
		int classifyId = classifyService.getClassifyIdByName(classifyName);
		int count;
		if(type == -1 || type == -2) {
			count = postService.getPostCountForClassify(classifyId);
		}else {
			count = postService.getPostCountOfAreaForClassify(classifyId, type);
		}
		BasePageResponse<List<Post>> response = new BasePageResponse<>(page, count);
		if(type == -1) {
			response.setData(postService.getPostByClassifyOfNew(classifyId, response.getPageNo(), response.getPageSize()));
		}else if(type == -2) {
			response.setData(postService.getPostByClassifyOfHot(classifyId, response.getPageNo(), response.getPageSize()));
		}else {
			response.setData(postService.getPostByClassifyOfArea(classifyId, type, response.getPageNo(), response.getPageSize()));
		}
		response.setClassifyName(classifyName);
		response.setClassifyShowName(ClassifyType.getValueByName(classifyName));
		response.setAreaType(type);
		map.put("response", response);
	}
	
	/**
	 * 统计界面
	 * @param map
	 * @return
	 */
	@RequestMapping("/statistics")
	public String statistics(Map<String, Object> map){
		System.out.println("社区统计");
		return "statistics";
	}
	
	/**
	 * Ajax返回统计数据
	 * @return
	 */
	@RequestMapping("/stat/A")
	public @ResponseBody BaseResponse<UserStatistics> statisticsA(){
		UserStatistics userStatistics = statisticsService.getUserStatistics();
		return new BaseResponse<UserStatistics>(userStatistics);
	}
	/**
	 * Ajax返回统计数据
	 * @return
	 */
	@RequestMapping("/stat/B")
	public @ResponseBody BaseResponse<PostStatistics> statisticsB(){
		PostStatistics postStatistics = statisticsService.getPostStatistics();
		return new BaseResponse<PostStatistics>(postStatistics);
	}
	
	/**
	 * Ajax返回统计数据
	 * @return
	 */
	@RequestMapping("/stat/C")
	public @ResponseBody BaseResponse<CommonStatistics> statisticsC(){
		CommonStatistics commonStatistics = statisticsService.getCommonStatistics();
		commonStatistics.setChatNum(chatService.getChatCount());
		commonStatistics.setCommentNum(postCommentService.getAllCommentCount());
		return new BaseResponse<CommonStatistics>(commonStatistics);
	}
	
	/**
	 * Ajax返回统计数据
	 * @return
	 */
	@RequestMapping("/stat/D")
	public @ResponseBody BaseResponse<List<StatisticsAreaPost>> statisticsD(){
		List<StatisticsAreaPost> areaPostStatistics = statisticsService.getAreaPostStatistics();
		return new BaseResponse<List<StatisticsAreaPost>>(areaPostStatistics);
	}
	
	/**
	 * Ajax返回统计数据
	 * @return
	 */
	@RequestMapping("/stat/E")
	public @ResponseBody BaseResponse<List<StatisticsAreaLabel>> statisticsE(){
		List<StatisticsAreaLabel> areaLabelStatistics = statisticsService.getAreaLabelStatistics();
		return new BaseResponse<List<StatisticsAreaLabel>>(areaLabelStatistics);
	}
	
	/**
	 * Ajax返回统计数据
	 * @return
	 */
	@RequestMapping("/stat/F")
	public @ResponseBody BaseResponse<List<StatisticsMonthPostNum>> statisticsF(@RequestParam("year") String year){
		List<StatisticsMonthPostNum> monthPostNumStatistics = statisticsService.getMonthPostNumStatistics(year);
		return new BaseResponse<List<StatisticsMonthPostNum>>(monthPostNumStatistics);
	}
	
	/**
	 * Ajax返回统计数据
	 * @return
	 */
	@RequestMapping("/stat/G")
	public @ResponseBody BaseResponse<List<PostUserStatistics>> statisticsG(){
		List<PostUserStatistics> postUserStatistics = statisticsService.getPostUserStatistics();
		return new BaseResponse<List<PostUserStatistics>>(postUserStatistics);
	}
	
	/**
	 * Ajax返回统计数据
	 * @return
	 */
	@RequestMapping("/stat/H")
	public @ResponseBody BaseResponse<List<PostTenStatistics>> statisticsH(){
		List<PostTenStatistics> postTenStatistics = statisticsService.getPostTenStatistics();
		return new BaseResponse<List<PostTenStatistics>>(postTenStatistics);
	}
	
	// ---
	
	/**
	 * 忠告
	 * @param map
	 * @return
	 */
	@RequestMapping("/advice")
	public String advice(Map<String, Object> map, @RequestParam(value="type",required=false) Integer type){
		if(type != null) {
			return advice(1, type, map);
		}
		return advice(1, AreaType.NEWEST, map);
	}
	
	/**
	 * 忠告分页
	 * @param page
	 * @param type
	 * @param map
	 * @return
	 */
	@RequestMapping("/advice/{page}")
	public String advice(@PathVariable("page") int page, @RequestParam("type") int type,
			Map<String, Object> map){
		log.info("忠告-请求参数-领域：{}，页码：{}", type, page);
		globalDeal("advice", type, page, map);
//		int classifyId = classifyService.getClassifyIdByName("advice");
//		int count;
//		if(type == -1 || type == -2) {
//			count = postService.getPostCountForClassify(classifyId);
//		}else {
//			count = postService.getPostCountOfAreaForClassify(classifyId, type);
//		}
//		BasePageResponse<List<Post>> response = new BasePageResponse<>(page, count);
//		if(type == -1) {
//			response.setData(postService.getPostByClassifyOfNew(classifyId, response.getPageNo(), response.getPageSize()));
//		}else if(type == -2) {
//			response.setData(postService.getPostByClassifyOfHot(classifyId, response.getPageNo(), response.getPageSize()));
//		}else {
//			response.setData(postService.getPostByClassifyOfArea(classifyId, type, response.getPageNo(), response.getPageSize()));
//		}
//		response.setClassifyName("advice");
//		response.setAreaType(type);
//		map.put("response", response);
		return "advice";
	}
	
	/**
	 * 公司印象
	 * @return
	 */
	@RequestMapping("/company")
	public String company(Map<String, Object> map){
		int count = companyService.getCompanyCount();
		BaseJSONPageResponse<List<Company>> response = new BaseJSONPageResponse<>(1, count);
		response.setData(companyService.getCompanyList(response.getPageNo(),response.getPageSize()));
		map.put("response", response);
		return "company";
	}
	
	/**
	 * 公司印象,分页
	 * @return
	 */
	@RequestMapping("/company_ajax")
	public @ResponseBody BaseJSONPageResponse<List<Company>> company(@RequestParam("page") int page){
		int count = companyService.getCompanyCount();
		BaseJSONPageResponse<List<Company>> response = new BaseJSONPageResponse<>(page, count);
		response.setData(companyService.getCompanyList(response.getPageNo(),response.getPageSize()));
		return response;
	}
	
	/**
	 * 公司查询
	 * @param companyName
	 * @return
	 */
	@RequestMapping("/company_search_by_name")
	public @ResponseBody BaseResponse<Company> companySearchByName(@RequestParam("companyName") String companyName){
		
		return new BaseResponse<Company>(companyService.getCompanyByName(companyName, PageUtils.getPageSize()));
	}
	
	/**
	 * 公司查询
	 * @param companyName
	 * @return
	 */
	@RequestMapping("/company_search_by_id")
	public @ResponseBody BaseResponse<Company> companySearchById(@RequestParam("companyId") int companyId){
		
		return new BaseResponse<Company>(companyService.getCompanyById(companyId, PageUtils.getPageSize()));
	}
	
	/**
	 * 添加公司
	 * @param companyName
	 * @return
	 */
	@RequestMapping("/company_add")
	public @ResponseBody BaseResponse<Integer> companyAdd(HttpSession session, @RequestParam("companyName") String companyName){
		User user = globalCheckUser(session);
		int i = companyService.checkCompany(companyName);
		if(i == 1) {
			throw new CommonException(ExceptionEnum.COMPANY_ALREADY_EXIST.code, ExceptionEnum.COMPANY_ALREADY_EXIST.msg);
		}
		return new BaseResponse<Integer>(companyService.addCompany(new Company(companyName, new User(user.getUserId()))));
	}
	
	/**
	 * 添加公司标签:labelName,labelType,company.companyId
	 * @param companyLabel
	 * @return
	 */
	@RequestMapping("/company_add_label")
	public @ResponseBody BaseResponse<Integer> companyAddLabel(HttpSession session, CompanyLabel companyLabel){
		User user = globalCheckUser(session);
		companyLabel.setUser(new User(user.getUserId()));
		return new BaseResponse<Integer>(companyService.addCompanyLabel(companyLabel));
	}
	
	/**
	 * 公司-顶.不推荐，利用触发器实现了
	 * @param companyID
	 * @return
	 */
	@Deprecated
	@RequestMapping("/company_up")
	public @ResponseBody BaseResponse<Integer> companyUp(HttpSession session, @RequestParam("companyId") int companyId){
		User user = globalCheckUser(session);
		log.info("用户：{}，赞了公司：{}", user.getNickname(), companyId);
		return new BaseResponse<Integer>(companyService.updateCompany(new Company(companyId, 1, null)));
	}
	
	/**
	 * 公司-踩.不推荐，利用触发器实现了
	 * @param companyID
	 * @return
	 */
	@Deprecated
	@RequestMapping("/company_down")
	public @ResponseBody BaseResponse<Integer> companyDown(HttpSession session, @RequestParam("companyId") int companyId){
		User user = globalCheckUser(session);
		log.info("用户：{}，赞了公司：{}", user.getNickname(), companyId);
		return new BaseResponse<Integer>(companyService.updateCompany(new Company(companyId, null, 1)));
	}
	
	// ---
	
	/**
	 * 面经
	 * @param map
	 * @return
	 */
	@RequestMapping("/interview")
	public String interview(Map<String, Object> map, @RequestParam(value="type",required=false) Integer type){
		if(type != null) {
			return interview(1, type, map);
		}
		return interview(1, AreaType.NEWEST, map);
	}
	
	/**
	 * 面经分页
	 * @param page
	 * @param type
	 * @param map
	 * @return
	 */
	@RequestMapping("/interview/{page}")
	public String interview(@PathVariable("page") int page, @RequestParam("type") int type,
			Map<String, Object> map){
		log.info("面经-请求参数-领域：{}，页码：{}", type, page);
		globalDeal("interview", type, page, map);
		return "interview";
	}
	
	/**
	 * 技能图
	 * @param map
	 * @return
	 */
	@RequestMapping("/job")
	public String job(Map<String, Object> map, @RequestParam(value="type",required=false) Integer type){
		if(type != null) {
			return job(1, type, map);
		}
		return job(1, AreaType.NEWEST, map);
	}
	
	/**
	 * 技能图分页
	 * @param page
	 * @param type
	 * @param map
	 * @return
	 */
	@RequestMapping("/job/{page}")
	public String job(@PathVariable("page") int page, @RequestParam("type") int type,
			Map<String, Object> map){
		log.info("技能图-请求参数-领域：{}，页码：{}", type, page);
		globalDeal("job", type, page, map);
		return "job";
	}
	
	/**
	 * 疑问
	 * @param map
	 * @return
	 */
	@RequestMapping("/question")
	public String question(Map<String, Object> map, @RequestParam(value="type",required=false) Integer type){
		if(type != null) {
			return question(1, type, map);
		}
		return question(1, AreaType.NEWEST, map);
	}
	
	/**
	 * 疑问分页
	 * @param page
	 * @param type
	 * @param map
	 * @return
	 */
	@RequestMapping("/question/{page}")
	public String question(@PathVariable("page") int page, @RequestParam("type") int type,
			Map<String, Object> map){
		// 调用服务接口，传入type。服务根据type，取得对应的数据
		log.info("疑问-请求参数-领域：{}，页码：{}", type, page);
		globalDeal("question", type, page, map);
		return "question";
	}
	
	/**
	 * 自述
	 * @param map
	 * @return
	 */
	@RequestMapping("/readme")
	public String readme(Map<String, Object> map, @RequestParam(value="type",required=false) Integer type){
		if(type != null) {
			return readme(1, type, map);
		}
		return readme(1, AreaType.NEWEST, map);
	}
	
	/**
	 * 自述分页
	 * @param page
	 * @param type
	 * @param map
	 * @return
	 */
	@RequestMapping("/readme/{page}")
	public String readme(@PathVariable("page") int page, @RequestParam("type") int type,
			Map<String, Object> map){
		log.info("自述-请求参数-领域：{}，页码：{}", type, page);
		globalDeal("readme", type, page, map);
		return "readme";
	}
	
	/**
	 * 资源
	 * @param map
	 * @return
	 */
	@RequestMapping("/resource")
	public String resource(Map<String, Object> map, @RequestParam(value="type",required=false) Integer type){
		if(type != null) {
			return resource(1, type, map);
		}
		return resource(1, AreaType.NEWEST, map);
	}
	
	/**
	 * 资源分页
	 * @param page
	 * @param type
	 * @param map
	 * @return
	 */
	@RequestMapping("/resource/{page}")
	public String resource(@PathVariable("page") int page, @RequestParam("type") int type,
			Map<String, Object> map){
		log.info("资源-请求参数-领域：{}，页码：{}", type, page);
		globalDeal("resource", type, page, map);
		return "resource";
	}
	
	/**
	 * 默认投票
	 * @param map
	 * @return
	 */
	@RequestMapping("/vote")
	public String vote(Map<String, Object> map, @RequestParam(value="type",required=false) Integer type){
		if(type != null) {
			return vote(1, type, map);
		}
		return vote(1, AreaType.NEWEST, map);
	}
	
	/**
	 * 投票分页
	 * @param page
	 * @param type
	 * @param map
	 * @return
	 */
	@RequestMapping("/vote/{page}")
	public String vote(@PathVariable("page") int page, @RequestParam("type") int type,
			Map<String, Object> map){
		int count;
		if(type == -1 || type == -2) {
			count = voteService.getVoteCount();
		}else {
			count = voteService.getVoteCountOfArea(type);
		}
		BasePageResponse<List<Vote>> response = new BasePageResponse<>(page, count);
		if(type == -1) {
			response.setData(voteService.getVoteList(response.getPageNo(), response.getPageSize()));
		}else if(type == -2) {
			response.setData(voteService.getVoteListOfHot(response.getPageNo(), response.getPageSize()));
		}else {
			response.setData(voteService.getVoteListOfArea(type, response.getPageNo(), response.getPageSize()));
		}
		response.setClassifyName("vote");
		response.setAreaType(type);
		map.put("response", response);
		return "vote";
	}
	
	/**
	 * 写投票页面
	 * @return
	 */
	@RequestMapping("/write_vote")
	public String writeVote(Map<String, Object> map){
		map.put("area", areaService.getAreas());
		return "write_vote";
	}
	
	/**
	 * 提交投票
	 * @return
	 */
	@RequestMapping("/submit_vote")
	public String submitVote(HttpSession session, Vote vote, @RequestParam("itemContent") String[] itemContent){
		log.info("提交投票：参数：voteContent：{}，voteTime：{}，areaId：{}，itemContent：{}", vote.getVoteContent(),
				vote.getVoteTime(), vote.getAreaId(), itemContent);
		User user = globalCheckUser(session);
		String voteId = IDUtils.createID20(vote.getVoteTime());
		vote.setVoteId(voteId);
		vote.setUser(user);
		List<VoteItem> items = vote.getItems();
		for(String c : itemContent) {
			items.add(new VoteItem(c, 0, new Vote(voteId)));
		}
		// 保存
		int i = voteService.addVote(vote);
		if(i == 0) {
			session.setAttribute("error", "添加投票失败！");
			return "redirect:/error";
		}
		session.setAttribute("success", "添加投票成功！");
		return "redirect:/success";
	}
	
	/**
	 * 参与投票
	 * @param voter
	 * @return
	 */
	@RequestMapping("/join_vote")
	public @ResponseBody BaseResponse<Integer> joinVote(HttpSession session, Voter voter){
		User user = globalCheckUser(session);
		voter.setUserId(user.getUserId());
		int checkVoter = voteService.checkVoter(voter);
		if(checkVoter == 1) {
			return new BaseResponse<Integer>(ExceptionEnum.ADD_VOTER_FAILED.code, ExceptionEnum.ADD_VOTER_FAILED.msg);
		}
		
		return new BaseResponse<>(voteService.addVoter(voter));
	}
	
	// ---
	
	/**
	 * 甩锅，不需要分页
	 * @param map
	 * @param type
	 * @return
	 */
	@RequestMapping("/throw_pot")
	public String throwPot(Map<String, Object> map, @RequestParam("type") int type){
		map.put("areaType", "throw_pot");
		throwPotService.getReceiveInfo(type);
		return "throw_pot";
	}
	
	/**
	 * 添加甩锅
	 * @param fromArea
	 * @param toArea
	 * @param gift
	 * @param session
	 * @return
	 */
	@RequestMapping("/throw_pot_add")
	@ResponseBody
	public Map<String, Object> throwPotAdd(@RequestParam("fromArea") int fromArea, @RequestParam("toArea") int toArea,
			@RequestParam("gift") String gift, HttpSession session){
		Map<String, Object> map = new HashMap<>();
		
		return map;
	}
	
	// ---
	
	/**
	 * 用户的闲聊
	 * @return
	 */
	@RequestMapping("/my_chat")
	public String myThrowPotChat(HttpSession session, Map<String, Object> map){
		map.put("areaType", "throw_pot");
		map.put("chatRole", "my");
		User user = globalCheckUser(session);
		int count = chatService.getChatCountPersonally(user.getUserId());
		BaseJSONPageResponse<List<Chat>> response = new BaseJSONPageResponse<>(1, count);
		response.setData(chatService.getChatsPersonally(user.getUserId(), response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		return "throw_pot_chat";
	}
	
	/**
	 * 用户的闲聊
	 * @return
	 */
	@RequestMapping("/my_chat_ajax")
	public @ResponseBody BaseJSONPageResponse<List<Chat>> myThrowPotChatAjax(HttpSession session, @RequestParam("page") int page){
		User user = globalCheckUser(session);
		int count = chatService.getChatCountPersonally(user.getUserId());
		BaseJSONPageResponse<List<Chat>> response = new BaseJSONPageResponse<>(page, count);
		response.setData(chatService.getChatsPersonally(user.getUserId(), response.getPageNo(), response.getPageSize()));
		return response;
	}
	
	/**
	 * 闲聊
	 * @return
	 */
	@RequestMapping("/throw_pot_chat")
	public String throwPotChat(Map<String, Object> map){
		map.put("areaType", "throw_pot");
		map.put("chatRole", "all");
		int count = chatService.getChatCount();
		BaseJSONPageResponse<List<Chat>> response = new BaseJSONPageResponse<>(1, count);
		response.setData(chatService.getChats(response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		return "throw_pot_chat";
	}
	
	/**
	 * 闲聊
	 * @return
	 */
	@RequestMapping("/throw_pot_chat_ajax")
	public @ResponseBody BaseJSONPageResponse<List<Chat>> throwPotChatAjax(Map<String, Object> map, @RequestParam("page") int page){
		int count = chatService.getChatCount();
		BaseJSONPageResponse<List<Chat>> response = new BaseJSONPageResponse<>(page, count);
		response.setData(chatService.getChats(response.getPageNo(), response.getPageSize()));
		return response;
	}
	
	/**
	 * 添加闲聊:chatContent,chatTime
	 * @param chat
	 * @param session
	 * @return
	 */
	@RequestMapping("/add_chat")
	public @ResponseBody BaseResponse<Integer> throwPotChatAdd(HttpSession session, Chat chat){
		User user = globalCheckUser(session);
		chat.setChatId(IDUtils.createID20(chat.getChatTime()));
		chat.setUser(new User(user.getUserId()));
		return new BaseResponse<Integer>(chatService.addChat(chat));
	}
	
	/**
	 * 删除闲聊
	 * @param session
	 * @param chatId
	 * @return
	 */
	@RequestMapping("/del_chat")
	public @ResponseBody BaseResponse<Integer> throwPotChatDel(HttpSession session, @RequestParam("chatId") String chatId){
		User user = globalCheckUser(session);
		
		return new BaseResponse<Integer>(chatService.deleteChat(new Chat(chatId), user));
	}
	
	/**
	 * 添加闲聊回复：replyContent，replyTime，targetUser.userId，chat.chatId
	 * @param session
	 * @param reply
	 * @return
	 */
	@RequestMapping("/add_chat_reply")
	public @ResponseBody BaseResponse<Integer> throwPotChatReplyAdd(HttpSession session, ChatReply reply){
		User user = globalCheckUser(session);
		reply.setReplyUser(new User(user.getUserId()));
		reply.setReplyId(IDUtils.createID20(reply.getReplyTime()));
		return new BaseResponse<Integer>(chatService.addChatReply(reply));
	}
	
	/**
	 * 删除闲聊回复
	 * @param session
	 * @param replyId
	 * @return
	 */
	@RequestMapping("/del_chat_reply")
	public @ResponseBody BaseResponse<Integer> throwPotChatReplyDel(HttpSession session, @RequestParam("replyId") String replyId){
		User user = globalCheckUser(session);
		return new BaseResponse<Integer>(chatService.deleteChatReply(new ChatReply(replyId), user));
	}
	
	// ---------
	
	/**
	 * 帖子内容
	 * @return
	 */
	@RequestMapping("/post_details/{id}")
	public String postDetails(@PathVariable("id") String id, Map<String, Object> map){
		// 查询帖子
		Post post = postService.getPostById(id);
		map.put("post", post);
		// 查询帖子下面的评论
		BaseJSONPageResponse<List<PostComment>> response = new BaseJSONPageResponse<>(1, postCommentService.getCommentCount(id));
		response.setData(postCommentService.getPostCommentList(id, response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		// 更新浏览量
		Post temp = new Post(post.getPostId());
		temp.setVisitNum(post.getVisitNum()+1);
		temp.setClassify(post.getClassify());
		postService.updateVisitNum(temp);
		return "post_details";
	}
	
	/**
	 * 共享帖子内容
	 * 显示最新修改的帖子，有个显示原版的按钮，右侧是修改历史.传过去原版content和最新版content.
	 * 历史列表：修改者，查看，修改
	 * @return
	 */
	@RequestMapping("/share_post_details/{id}")
	public String postShareDetails(@PathVariable("id") String id, Map<String, Object> map){
		// 查询帖子
		Post post = postService.getPostById(id);
		map.put("post", post);
		// 查询帖子下面的评论
		BaseJSONPageResponse<List<PostComment>> response = new BaseJSONPageResponse<>(1, postCommentService.getCommentCount(id));
		response.setData(postCommentService.getPostCommentList(id, response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		// 修改历史
		map.put("postShare", postShareService.getPostModifyList(id));
		// 更新浏览量
		Post temp = new Post(post.getPostId());
		temp.setVisitNum(post.getVisitNum()+1);
		temp.setClassify(post.getClassify());
		postService.updateVisitNum(temp);
		return "post_share_details";
	}
	
	/**
	 * 获得共享帖子的某一个修改者的修改内容
	 * @param shareId
	 * @return
	 */
	@RequestMapping("/share_content")
	public @ResponseBody BaseResponse<String> getShareContent(@RequestParam("shareId") int shareId){
		return new BaseResponse<String>(postShareService.getContent(shareId));
	}
	
	/**
	 * 编辑自己共享帖子
	 * @return
	 */
	@RequestMapping("/edit_own_share_post/{id}")
	public String editOwnSharePost(HttpSession session, @PathVariable("id") int shareId, @RequestParam("title") String title, Map<String, Object> map){
		User user = globalCheckUser(session);
		int i = postShareService.checkPostShare(shareId, user.getUserId());
		if(i == 0) {
			throw new CommonException(ExceptionEnum.POSTSHARE_MODIFY_NO_PERMIT.code, ExceptionEnum.POSTSHARE_MODIFY_NO_PERMIT.msg);
		}
		
		map.put("postMarkdown", postShareService.getOwnShareToEdit(shareId));
		map.put("title", title);
		session.setAttribute("shareId", shareId); 	// 给保存使用
		return "edit_own_share_post";
	}
	
	/**
	 * 保存编辑之后的自己的共享帖子
	 * @return
	 */
	@RequestMapping("/save_own_share_post")
	public String saveOwnSharePost(HttpSession session, @RequestParam("postContent") String postContent, @RequestParam("postMarkdown") String postMarkdown,
			@RequestParam("time") Date time){
		// 编辑即更新
		int shareId = (int) session.getAttribute("shareId");
		
		postShareService.updateSharePost(new PostShare(shareId, postContent, postMarkdown, time));
		session.setAttribute("success", "修改成功！");
		return "redirect:/success";
	}
	
	/**
	 * 编辑共享帖子
	 * @return
	 */
	@RequestMapping("/edit_share_post/{id}")
	public String editSharePost(HttpSession session, @PathVariable("id") String postId, Map<String, Object> map){
		Post forModify = postService.getPostByIdForModify(postId);
		map.put("post", forModify);
		return "edit_share_post";
	}
	
	/**
	 * 保存编辑之后的共享帖子:postId, postContent, postMarkdown, time
	 * @return
	 */
	@RequestMapping("/save_share_post")
	public String saveSharePost(HttpSession session, PostShare postShare, @RequestParam("time") Date time){
		User user = globalCheckUser(session);
		// 编辑即添加，参考提交帖子。创建者和修改者是关键
		// new PostShare(postId, postContent, postMarkdown, postTime, user, modifyTime)
		// 设置：postTime, user, modifyTime
		postShare.setPostTime(time);
		postShare.setModifyTime(time);
		postShare.setUser(new User(user.getUserId()));
		postShareService.addSharePost(postShare);
		session.setAttribute("success", "修改成功！请查看修改历史！");
		return "redirect:/success";
	}
	
	// ---
	
	/**
	 * 编辑帖子
	 * @return
	 */
	@RequestMapping("/edit_post/{id}")
	public String editPost(HttpSession session, @PathVariable("id") String postId, Map<String, Object> map){
		// 查询帖子是否属于这个用户
		User user = globalCheckUser(session);
		int checkPost = postService.checkPost(user.getUserId(), postId);
		if(checkPost != 1) {
			throw new CommonException(ExceptionEnum.NO_PERMISSION.code, ExceptionEnum.NO_PERMISSION.msg);
		}
		Post forModify = postService.getPostByIdForModify(postId);
		map.put("post", forModify);
		map.put("area", areaService.getAreas());	// 传递领域列表
		map.put("areaLabel", areaService.getAreaLabel(forModify.getWorkArea().getAreaId()));	// 传递领域对应的标签
		
		session.setAttribute("postId", postId); 	// 给保存使用
		String str = "";
		for(AreaLabel a : forModify.getLabels()) {
			str += (a.getLabelId() + ",");
		}
		String oldLabelStr = str.substring(0, str.lastIndexOf(","));	// 老标签，用字符串封装
		session.setAttribute("oldPostLabel", oldLabelStr); 	// 给保存使用
		map.put("oldLabelStr", oldLabelStr);	// 前端判断，是否匹配这里的标签id，添加样式
		return "edit_post";
	}
	
	/**
	 * 保存编辑之后的帖子.可修改：postTitle，postShortCut，postContent，postMarkdown，postCover，workArea，modifier，modifyTime，labels
	 * @param session
	 * @param post
	 * @param postLabel
	 * @param time
	 * @return
	 */
	@RequestMapping("/save_edit_post")
	public String saveEditPost(HttpSession session, Post post, @RequestParam(value="postLabel",required=false) String[] postLabel,
			@RequestParam("postText") String postText, @RequestParam("time") Date time){
		User user = globalCheckUser(session);
		String postId = (String) session.getAttribute("postId");
		String oldLabelStr = (String) session.getAttribute("oldPostLabel");
		// id
		post.setPostId(postId);
		// 封面
		String cover = PostUtils.getArticleImage(post.getPostMarkdown());
		post.setPostCover(cover);
		// 修改者
		post.setModifier(new User(user.getUserId()));
		// 修改时间
		post.setModifyTime(time);
		// 老标签
		Set<AreaLabel> labels = post.getLabels();
		for(String s : oldLabelStr.split(",")) {
			labels.add(new AreaLabel(Integer.parseInt(s)));
		}
		// 新标签
		Set<AreaLabel> newLabels = new HashSet<>();
		for(String s : postLabel) {
			newLabels.add(new AreaLabel(Integer.parseInt(s)));
		}
		log.info("修改帖子：用户：{}，帖子{}", user.getUserId(), postId);
		int i = postService.updatePost(post, newLabels);
		if(i == 0) {
			session.setAttribute("error", "修改失败！");
			return "redirect:/error";
		}
		// 修改solr表
		solrPostService.updateSolrPost(new SolrPost(postId, post.getPostTitle(), postText, cover, time));
		session.removeAttribute("postId");			// 删除临时变量
		session.removeAttribute("oldPostLabel");	// 删除临时变量
		session.setAttribute("success", "修改成功！");
		return "redirect:/success";
	}
	
	/**
	 * 						1		2		3		4		5		6
	 * 写帖子页面,传入模块类型（advice,readme,resource,question,interview,job）除了统计、甩锅、投票、公司印象
	 * @return
	 */
	@RequestMapping("/write_post")
	public String writePost(HttpSession session, @RequestParam("type") String type, Map<String, Object> map){
		// 将类型放入session，防止篡改
		// job类型的允许大家共同修改，有个最后修改者
		globalCheckUser(session);
		
		int classifyId = classifyService.getClassifyIdByName(type);
		session.setAttribute("classifyId", classifyId);
		
		map.put("area", areaService.getAreas());	// 传递领域列表
		return "write_post";
	}
	
	/**
	 * 提交帖子
	 * 帖子只会对应一个领域，以及领域下的标签
	 * @return
	 */
	@RequestMapping("/submit_post")
	public String submitPost(HttpSession session, Post post, @RequestParam(value="postLabel",required=false) String[] postLabel,
			@RequestParam("postText") String postText, @RequestParam("time") Date time){
		// 保存
		User user = globalCheckUser(session);
		String postId = IDUtils.createID20(time);
		int classifyId = (int) session.getAttribute("classifyId");
		
		// id
		post.setPostId(postId);
		// 封面
		String cover = PostUtils.getArticleImage(post.getPostMarkdown());
		post.setPostCover(cover);
		// 发表时间
		post.setPostTime(time);
		// 所属分类
		post.setClassify(new Classify(classifyId));
		// 作者
		post.setUser(new User(user.getUserId()));
		// 修改者
		post.setModifier(new User(user.getUserId()));
		// 修改时间
		post.setModifyTime(time);
		// 浏览量
		post.setVisitNum(0);
		// 标签
		Set<AreaLabel> labels = post.getLabels();
		for(String s : postLabel) {
			labels.add(new AreaLabel(Integer.parseInt(s)));
		}
		log.info("发布帖子：用户：{}，传参：{}",user.getNickname(),post);
		int i = postService.addPost(post);
		if(i == 0) {
			session.setAttribute("error", "发表失败！");
			return "redirect:/error";
		}
		// 添加solr表
		solrPostService.addSolrPost(new SolrPost(postId, post.getPostTitle(), postText, cover, time));
		session.setAttribute("success", "发表成功！");
		return "redirect:/success";
	}
	
	/**
	 * 上传帖子图片
	 * @param request
	 * @param session
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/upload_post_img")
	public @ResponseBody Map<String, Object> uploadBg(HttpServletRequest request,HttpSession session,
			@RequestParam("editormd_image_file") MultipartFile file){
		Map<String, Object> dataMap = new HashMap<>();
		UploadDTO dto;
		try {
			dto = UploadFileUtils.upload(request, session, file, "post", log);
			dataMap.put("success", 1);
			dataMap.put("message", "上传成功");
			dataMap.put("url", dto.getUrl());
		} catch (IOException e) {
			dataMap.put("success", 0);
			dataMap.put("message", "上传失败");
			log.info("上传帖子图片失败！！异常信息：{}",e.getMessage());
		}
		
		return dataMap;
	}
	
	/**
	 * 获取领域对应的标签，前端先检测是否存在于 Web存储里面
	 * @param areaId
	 * @return
	 */
	@RequestMapping("/area_label")
	public @ResponseBody BaseResponse<List<AreaLabel>> getAreaLabel(@RequestParam("areaId") int areaId){
		return new BaseResponse<List<AreaLabel>>(areaService.getAreaLabel(areaId));
	}
	
	// ---
	
	/**
	 * 删除帖子
	 * @param session
	 * @param postId
	 * @return
	 */
	@RequestMapping("/del_post")
	public @ResponseBody BaseResponse<Integer> delPost(HttpSession session, @RequestParam("postId") String postId){
		User user = globalCheckUser(session);
		Post post = new Post(postId);
		post.setUser(new User(user.getUserId()));
		post.setIsDelete(DeleteStatus.ALR_DEL.code);
		solrPostService.deleteSolrPost(postId);	// 删除solr表
		return new BaseResponse<Integer>(postService.deletePost(post));
	}
	
	/**
	 * 收藏帖子
	 * @param session
	 * @param postId
	 * @return
	 */
	@RequestMapping("/collect_post")
	public @ResponseBody BaseResponse<Integer> collectPost(HttpSession session, @RequestParam("postId") String postId){
		User user = globalCheckUser(session);
		int i = userCollectionService.checkCollect(user.getUserId(), postId);
		if(i == 1) {
			throw new CommonException(ExceptionEnum.COLLECT_POST_FAILD.code, ExceptionEnum.COLLECT_POST_FAILD.msg);
		}
		i = userCollectionService.addCollection(new UserCollection(user.getUserId(), postId));
		// 更新收藏数
		Post temp = new Post(postId);
		temp.setCollectionNum(1);	// 这里极为重要的约定：正数为+，负数为-，PostDAO.xml 做了特殊处理
		postService.updateCollectionNum(temp);
		return new BaseResponse<Integer>(i);
	}
	
	/**
	 * 取消收藏帖子
	 * @param session
	 * @param postId
	 * @return
	 */
	@RequestMapping("/cancel_collect_post")
	public @ResponseBody BaseResponse<Integer> cancelCollectPost(HttpSession session, @RequestParam("postId") String postId){
		User user = globalCheckUser(session);
		int i = userCollectionService.delCollection(new UserCollection(user.getUserId(), postId));
		if(i == 0) {
			throw new CommonException(ExceptionEnum.COLLECT_ALREADY_CANCEL.code, ExceptionEnum.COLLECT_ALREADY_CANCEL.msg);
		}
		// 更新收藏数
		Post temp = new Post(postId);
		temp.setCollectionNum(-1);	// 这里极为重要的约定：正数为+，负数为-，PostDAO.xml 做了特殊处理
		postService.updateCollectionNum(temp);
		return new BaseResponse<Integer>(i);
	}
	
	/**
	 * 赞成
	 * @param session
	 * @param postId
	 * @return
	 */
	@RequestMapping("/support_post")
	public @ResponseBody BaseResponse<Integer> supportPost(HttpSession session, @RequestParam("postId") String postId){
		// 先检查post_up_down是否存在用户-帖子对应关系，如果不存在则添加，反之进行下一步判断：
		// 然后判断type类型，如果为赞成类型，则直接返回提示，否则直接修改类型
		// 最后修改帖子表里面的赞成反对字段(仅仅涉及添加：赞成数+1；如果涉及修改：赞成数+1，反对数-1)
		User user = globalCheckUser(session);
		Post temp = new Post(postId);
		temp.setUser(new User(user.getUserId()));
		return new BaseResponse<Integer>(postService.updateUpNum(temp));
	}
	
	/**
	 * 反对
	 * @param session
	 * @param postId
	 * @return
	 */
	@RequestMapping("/deny_post")
	public @ResponseBody BaseResponse<Integer> denyPost(HttpSession session, @RequestParam("postId") String postId){
		// 先检查post_up_down是否存在用户-帖子对应关系，如果不存在则添加，反之进行下一步判断：
		// 然后判断type类型，如果为反对类型，则直接返回提示，否则直接修改类型
		// 最后修改帖子表里面的赞成反对字段(仅仅涉及添加：反对数+1；如果涉及修改：反对数+1，赞成数-1)
		User user = globalCheckUser(session);
		Post temp = new Post(postId);
		temp.setUser(new User(user.getUserId()));
		return new BaseResponse<Integer>(postService.updateDownNum(temp));
	}
	
	
}
