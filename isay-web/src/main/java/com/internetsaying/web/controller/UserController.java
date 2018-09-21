package com.internetsaying.web.controller;

import java.io.IOException;
import java.util.Date;
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
import com.internetsaying.common.base.dto.CutImgDTO;
import com.internetsaying.common.base.dto.UploadDTO;
import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.post.dto.PostInfusion;
import com.internetsaying.post.entity.Post;
import com.internetsaying.post.service.PostService;
import com.internetsaying.user.dto.FansDTO;
import com.internetsaying.user.entity.Fans;
import com.internetsaying.user.entity.PersonalLetter;
import com.internetsaying.user.entity.PersonalLetterContent;
import com.internetsaying.user.entity.SystemMessage;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.FansService;
import com.internetsaying.user.service.PersonalLetterService;
import com.internetsaying.user.service.SystemMsgService;
import com.internetsaying.user.service.UserCollectionService;
import com.internetsaying.user.service.UserService;
import com.internetsaying.utils.IDUtils;
import com.internetsaying.utils.UploadFileUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserCollectionService userCollectionService;
	
	@Autowired
	private FansService fansService;
	
	@Autowired
	private SystemMsgService systemMsgService;
	
	@Autowired
	private PersonalLetterService personalLetterService;
	
	@Autowired
	private PostService postService;
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
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
	 * 访问其他用户，获取的内容：基本信息，是否已经关注，他的帖子。
	 * @param userId
	 * @param map
	 * @return
	 */
	@RequestMapping("/{id}")
	public String otherhome(HttpSession session, @PathVariable("id") String userId, Map<String, Object> map){
		int isRelation = 0;	// 没关注
		// 当前用户
		User curUser = (User) session.getAttribute("user");
		if(curUser != null) {
			isRelation = fansService.checkRelation(curUser.getUserId(), userId);
		}
		// 目标用户
		User user = userService.getUserById(userId);
		if (user == null) {
			throw new CommonException(ExceptionEnum.USER_NOT_EXIST.code, ExceptionEnum.USER_NOT_EXIST.msg);
		}
		PostInfusion infusion = postService.getPostInfusionForUser(userId);
		map.put("otherUser", user);
		map.put("otherInfusion", infusion);
		map.put("isRelation", isRelation);
		
		int count = postService.getPostCountOfUser(user.getUserId());
		
		BaseJSONPageResponse<List<Post>> response = new BaseJSONPageResponse<>(1, count);
		response.setData(postService.getPostListOfUser(user.getUserId(), response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		
		return "user_home_other";
	}
	
	/**
	 * 访问其他用户,帖子分页
	 * @param session
	 * @return
	 */
	@RequestMapping("/other_post")
	public @ResponseBody BaseJSONPageResponse<List<Post>> getOtherUserPosts(@RequestParam("userId") String userId, @RequestParam("pageNo") int pageNo){
		int count = postService.getPostCountOfUser(userId);
		
		BaseJSONPageResponse<List<Post>> response = new BaseJSONPageResponse<>(pageNo, count);
		response.setData(postService.getPostListOfUser(userId, response.getPageNo(), response.getPageSize()));
		return response;
	}
	
	/**
	 * 与其他人作比较(这里不全，没时间不做了)
	 * @param userId
	 * @param map
	 * @return
	 */
	@RequestMapping("/pk/{id}")
	public String userPK(@PathVariable("id") String userId, Map<String, Object> map){
		// 不存在的话返回错误
		User other = userService.getUserById(userId);
		PostInfusion otherInfusion = postService.getPostInfusionForUser(userId);
		map.put("other", other);
		map.put("otherInfusion", otherInfusion);
		return "user_home_pk";
	}
	

	/**
	 * 访问自己
	 * @param session
	 * @return
	 */
	@RequestMapping("/home")
	public String userhome(HttpSession session, Map<String, Object> map){
		// 调用帖子服务，获取用户的帖子列表
		User user = globalCheckUser(session);
		
		int count = postService.getPostCountOfUser(user.getUserId());
		
		BaseJSONPageResponse<List<Post>> response = new BaseJSONPageResponse<>(1, count);
		response.setData(postService.getPostListOfUser(user.getUserId(), response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		return "user_home";
	}
	
	/**
	 * 访问自己,帖子分页
	 * @param session
	 * @return
	 */
	@RequestMapping("/own_post")
	public @ResponseBody BaseJSONPageResponse<List<Post>> getUserPosts(HttpSession session, @RequestParam("pageNo") int pageNo){
		// 调用帖子服务，获取用户的帖子列表
		User user = (User) session.getAttribute("user");
		if(user == null)
			throw new CommonException(ExceptionEnum.LOGIN_INFO_OVERDUE.code, ExceptionEnum.LOGIN_INFO_OVERDUE.msg);
		
		int count = postService.getPostCountOfUser(user.getUserId());
		
		BaseJSONPageResponse<List<Post>> response = new BaseJSONPageResponse<>(pageNo, count);
		response.setData(postService.getPostListOfUser(user.getUserId(), response.getPageNo(), response.getPageSize()));
		return response;
	}
	
	
	
	/**
	 * 查看收藏的文章
	 * @param session
	 * @return
	 */
	@RequestMapping("/collection")
	public String collection(HttpSession session, Map<String, Object> map){
		// 默认为第一页，调用重载方法
		return collection(session, 1, map);
	}
	
	/**
	 * 查看收藏的文章
	 * @param session
	 * @param page
	 * @return
	 */
	@RequestMapping("/collection/{page}")
	public String collection(HttpSession session, @PathVariable("page") int page, Map<String, Object> map){
		// 调用帖子服务，获取用户收藏的帖子
		User user = (User) globalCheckUser(session);
		int count = userCollectionService.getUserCollectPostCount(user.getUserId());
		BasePageResponse<List<Post>> response = new BasePageResponse<>(page, count);
		Set<String> postIds = userCollectionService.getUserCollectPostIds(user.getUserId(), response.getPageNo(), response.getPageSize());
		// 判断null
		if(!postIds.isEmpty())
			response.setData(postService.getSpecificPosts(postIds));
		map.put("response", response);
		return "user_home_collection";
	}
	
	/**
	 * 粉丝
	 * @param session
	 * @return
	 */
	@RequestMapping("/fans")
	public String fans(HttpSession session, Map<String, Object> map){
		return fans(session, 1, map);
	}
	
	/**
	 * 粉丝
	 * @param session
	 * @param page
	 * @return
	 */
	@RequestMapping("/fans/{page}")
	public String fans(HttpSession session, @PathVariable("page") int page, Map<String, Object> map){
		// 调用用户服务，获取用户的粉丝
		User user = globalCheckUser(session);
		int count = fansService.countFans(user.getUserId());
		BasePageResponse<List<FansDTO>> response = new BasePageResponse<>(page, count);
		response.setData(fansService.getFans(user.getUserId(), response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		return "user_home_fans";
	}
	
	/**
	 * 我的关注
	 * @param session
	 * @param page
	 * @return
	 */
	@RequestMapping("/follow")
	public String follow(HttpSession session, Map<String, Object> map){
		
		return follow(session, 1, map);
	}
	
	/**
	 * 我的关注
	 * @param session
	 * @param page
	 * @return
	 */
	@RequestMapping("/follow/{page}")
	public String follow(HttpSession session, @PathVariable("page") int page, Map<String, Object> map){
		// 调用用户服务，获得用户关注的人
		User user = globalCheckUser(session);
		int count = fansService.countFocus(user.getUserId());
		BasePageResponse<List<FansDTO>> response = new BasePageResponse<>(page, count);
		response.setData(fansService.getFocus(user.getUserId(), response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		return "user_home_follow";
	}
	
	/**
	 * 动作->关注
	 * @param session
	 * @param otherId
	 * @return
	 */
	@RequestMapping("/focus")
	public @ResponseBody BaseResponse<Integer> focus(HttpSession session, @RequestParam("masterId") String masterId){
		User user = globalCheckUser(session);
		return new BaseResponse<Integer>(fansService.addFans(new Fans(masterId, user.getUserId(), new Date())));
	}
	
	/**
	 * 动作->取消关注
	 * @param session
	 * @param otherId
	 * @return
	 */
	@RequestMapping("/cancelFocus")
	public @ResponseBody BaseResponse<Integer> cancelFocus(HttpSession session, @RequestParam("masterId") String masterId){
		User user = globalCheckUser(session);
		return new BaseResponse<Integer>(fansService.delFans(new Fans(masterId, user.getUserId(), null)));
	}
	
	/**
	 * 私信消息
	 * @param session
	 * @param page
	 * @return
	 */
	@RequestMapping("/msg")
	public String msg(HttpSession session, Map<String, Object> map){
		
		return msg(session, 1, map);
	}
	
	/**
	 * 私信消息
	 * @param session
	 * @param page
	 * @return
	 */
	@RequestMapping("/msg/{page}")
	public String msg(HttpSession session, @PathVariable("page") int page, Map<String, Object> map){
		// 调用用户服务，获取用户的私信列表
		User curUser = globalCheckUser(session);
		int count = personalLetterService.getUserLetterCount(curUser.getUserId());
		BasePageResponse<List<PersonalLetter>> response = new BasePageResponse<>(page, count);
		response.setData(personalLetterService.getLetterList(curUser.getUserId(), response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		return "user_home_msg";
	}
	
	/**
	 * 消息具体
	 * @param session
	 * @return
	 */
	@RequestMapping("/msg_detail/{id}")
	public String msgDetail(HttpSession session, @PathVariable("id") String letterId, @RequestParam("t") String t, Map<String, Object> map){
		// 调用用户服务，获取用户的私信具体内容
		globalCheckUser(session);
		List<PersonalLetterContent> list = personalLetterService.getLetterContentList(letterId, t);
		map.put("data", list);
		return "user_home_msg_detail";
	}
	
	/**
	 * 获取私信记录，按照日期显示
	 * @param session
	 * @param letterId
	 * @param dateStr
	 * @return
	 */
	@RequestMapping("/get_msg_detail")
	public @ResponseBody BaseResponse<List<PersonalLetterContent>> msgDetailOfDate(HttpSession session, @RequestParam("id") String letterId, @RequestParam("dateStr") String dateStr){
		globalCheckUser(session);
		return new BaseResponse<List<PersonalLetterContent>>(personalLetterService.getLetterContentList(letterId, dateStr));
	}
	
	/**
	 * 已经私信过，直接回复
	 * @param session
	 * @param msgContent
	 * @param time
	 * @return
	 */
	@RequestMapping("/reply_letter")
	public @ResponseBody BaseResponse<Integer> replyLetter(HttpSession session, @RequestParam("letterId") String letterId, @RequestParam("otherId") String otherId,
			@RequestParam("letterContent") String letterContent, @RequestParam("time") Date time){
		log.info("私信界面回复：接受参数：私信ID：{}，目标：{}，私信内容：{}，时间：{}",letterId,otherId,letterContent,time);
		User curUser = globalCheckUser(session);
		return new BaseResponse<Integer>(personalLetterService.addLetter(
				new PersonalLetterContent(new PersonalLetter(letterId), new User(curUser.getUserId(), curUser.getNickname(), null), new User(otherId), letterContent, time)));
	}
	
	/**
	 * 不知道私信过没有
	 * @param session
	 * @param msgContent
	 * @param time
	 * @return
	 */
	@RequestMapping("/add_letter")
	public @ResponseBody BaseResponse<Integer> addLetter(HttpSession session, @RequestParam("otherId") String otherId,
			@RequestParam("letterContent") String letterContent, @RequestParam("time") Date time){
		log.info("他人主页私信：接受参数：目标：{}，私信内容：{}，时间：{}",otherId,letterContent,time);
		User curUser = globalCheckUser(session);
		String letterId = IDUtils.createID20(time);
		return new BaseResponse<Integer>(personalLetterService.addLetter(
				new PersonalLetter(letterId, new User(curUser.getUserId()), new User(otherId), time), 
				new PersonalLetterContent(new PersonalLetter(letterId), new User(curUser.getUserId(), curUser.getNickname(), null), new User(otherId), letterContent, time)));
	}
	
	/**
	 * 设置
	 * @param session
	 * @return
	 */
	@RequestMapping("/setting")
	public String setting(HttpSession session){
		globalCheckUser(session);
		return "user_home_setting";
	}
	
	/**
	 * 更新基本信息
	 * @param session
	 * @param user
	 * @return
	 */
	@RequestMapping("/update_base_info")
	public @ResponseBody BaseResponse<Integer> updateBaseInfo(HttpSession session, User user){
		User curUser = globalCheckUser(session);
		String nickname = user.getNickname();
		String sex = user.getSex();
		String graduate = user.getUserGraduate();
		String job = user.getJob();
		String company = user.getCompany();
		String workplace = user.getWorkplace();
		if(nickname != null) {
			curUser.setNickname(nickname);
		}
		if(sex != null) {
			curUser.setSex(sex);
		}
		if(graduate != null) {
			curUser.setUserGraduate(graduate);
		}
		if(job != null) {
			curUser.setJob(job);
		}
		if(company != null) {
			curUser.setCompany(company);
		}
		if(workplace != null) {
			curUser.setWorkplace(workplace);
		}
		session.setAttribute("user", curUser);
		return new BaseResponse<Integer>(userService.updateBaseInfo(new User(curUser.getUserId(), nickname, sex,
				graduate, job, company, workplace)));
	}
	
	/**
	 * 检查密码是否正确
	 * @param session
	 * @param oldPassword
	 * @return
	 */
	@RequestMapping("/check_password")
	public @ResponseBody BaseResponse<Boolean> checkPassword(HttpSession session, @RequestParam("oldPassword") String oldPassword){
		User curUser = globalCheckUser(session);
		// 比较
		return new BaseResponse<Boolean>(curUser.getPassword().equals(IDUtils.saltAndMd5(curUser.getUserEmail(), oldPassword)));
	}
	
	/**
	 * 更新密码
	 * @param session
	 * @param user
	 * @return
	 */
	@RequestMapping("/update_password")
	public @ResponseBody BaseResponse<Integer> updatePassword(HttpSession session, User user){
		User curUser = globalCheckUser(session);
		String pw = IDUtils.saltAndMd5(curUser.getUserEmail(), user.getPassword());
		BaseResponse<Integer> response = new BaseResponse<>(userService.updatePassword(new User(curUser.getUserId(), pw,
				null, null, null, null)));
		curUser.setPassword(pw);
		session.setAttribute("user", curUser);
		return response;
	}
	
	/**
	 * 上传头像，保存到本地服务器
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/upload_photo")
	public @ResponseBody BaseResponse<UploadDTO> uploadPhoto(HttpServletRequest request,HttpSession session,
			@RequestParam("imgFile") MultipartFile file) throws IOException{
		UploadDTO dto = UploadFileUtils.upload(request, session, file, "user_temp", log);
		session.setAttribute("imgName", dto.getNewFileName());
		return new BaseResponse<UploadDTO>(dto);
	}
	
	/**
	 * 保存头像，将本地服务器上的图片剪切
	 * @param session
	 * @return
	 */
	@RequestMapping("/save_photo")
	public @ResponseBody BaseResponse<UploadDTO> savePhoto(HttpServletRequest request,
			HttpSession session,
			CutImgDTO cutImgDTO){
		UploadDTO dto = UploadFileUtils.cut(request, session, cutImgDTO, "user_temp", "user", log);
		// 更新数据库，缓存，session
		User curUser = globalCheckUser(session);
		curUser.setUserPhoto(dto.getSaveToDBUrl());
		session.setAttribute("user", curUser);
		userService.updatePhoto(new User(curUser.getUserId(), null, dto.getSaveToDBUrl(), null, null, null));
		return new BaseResponse<UploadDTO>(dto);
	}
	
	/**
	 * 上传背景，直接上传到文件服务器
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/upload_bg")
	public @ResponseBody BaseResponse<UploadDTO> uploadBg(HttpServletRequest request,HttpSession session,
			@RequestParam("imgFile") MultipartFile file) throws IOException{
		UploadDTO dto = UploadFileUtils.upload(request, session, file, "user", log);
		// 更新数据库，缓存，session
		User curUser = globalCheckUser(session);
		curUser.setUserBg(dto.getSaveToDBUrl());
		session.setAttribute("user", curUser);
		userService.updateBg(new User(curUser.getUserId(), null, null, dto.getSaveToDBUrl(), null, null));
		return new BaseResponse<UploadDTO>(dto);
	}
	
	/**
	 * 上传支付宝二维码，直接上传到文件服务器
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/upload_alipay")
	public @ResponseBody BaseResponse<UploadDTO> uploadAlipay(HttpServletRequest request,HttpSession session,
			@RequestParam("imgFile") MultipartFile file) throws IOException{
		UploadDTO dto = UploadFileUtils.upload(request, session, file, "pay", log);
		// 更新数据库，缓存，session
		User curUser = globalCheckUser(session);
		curUser.setUserAlipay(dto.getSaveToDBUrl());
		session.setAttribute("user", curUser);
		userService.updateAlipay(new User(curUser.getUserId(), null, null, null, dto.getSaveToDBUrl(), null));
		return new BaseResponse<UploadDTO>(dto);
	}
	
	/**
	 * 上传微信二维码，直接上传到文件服务器
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/upload_vxin")
	public @ResponseBody BaseResponse<UploadDTO> uploadVxin(HttpServletRequest request,HttpSession session,
			@RequestParam("imgFile") MultipartFile file) throws IOException{
		UploadDTO dto = UploadFileUtils.upload(request, session, file, "pay", log);
		// 更新数据库，缓存，session
		User curUser = globalCheckUser(session);
		curUser.setUserVxin(dto.getSaveToDBUrl());
		session.setAttribute("user", curUser);
		userService.updateVxin(new User(curUser.getUserId(), null, null, null, null, dto.getSaveToDBUrl()));
		return new BaseResponse<UploadDTO>(dto);
	}
	
	/**
	 * 系统消息
	 * @param session
	 * @return
	 */
	@RequestMapping("/system")
	public String system(HttpSession session, Map<String, Object> map){
		return system(session, 1, map);
	}
	
	/**
	 * 系统消息
	 * @param session
	 * @return
	 */
	@RequestMapping("/system/{page}")
	public String system(HttpSession session, @PathVariable("page") int pageNo, Map<String, Object> map){
		User curUser = globalCheckUser(session);
		// 调用用户服务，获取用户的系统消息
		int count = systemMsgService.getSysCountForUser(curUser.getUserId());
		BasePageResponse<List<SystemMessage>> response = new BasePageResponse<>(pageNo, count);
		response.setData(systemMsgService.getSystemMsgList(curUser.getUserId(), response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		return "user_home_system";
	}
	
}
