package com.internetsaying.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.solr.client.solrj.SolrServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.internetsaying.common.base.BasePageResponse;
import com.internetsaying.common.base.BaseResponse;
import com.internetsaying.data.solr.IsaySolrRepository;
import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.post.service.PostService;
import com.internetsaying.site.entity.Announcement;
import com.internetsaying.site.entity.FriendLink;
import com.internetsaying.site.service.AboutService;
import com.internetsaying.site.service.AnnouncementService;
import com.internetsaying.site.service.FriendService;
import com.internetsaying.site.service.TimeLineService;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;
import com.internetsaying.utils.IDUtils;
import com.internetsaying.utils.Sending;
import com.internetsaying.web.dto.SolrPostDTO;

@Controller
public class SiteController {
	
	@Autowired
	private AboutService aboutService;
	
	@Autowired
	private AnnouncementService announcementService;

	@Autowired
	private FriendService friendService;
	
	@Autowired
	private TimeLineService timeLineService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	private static Logger log = LoggerFactory.getLogger(SiteController.class);
	
	/**
	 * 站点首页
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value={"/","/home"})
	public String home(HttpSession session, Map<String, Object> map){
		return "home";
	}
	
	/**
	 * 关于
	 * @param map
	 * @return
	 */
	@RequestMapping(value={"/about"})
	public String about(Map<String, Object> map){
		// 查询
		map.put("about", aboutService.getAboutSiteOfNew());
		return "about";
	}
	
	/**
	 * 关于作者
	 * @param map
	 * @return
	 */
	@RequestMapping(value={"/about_author"})
	public String aboutAuthor(Map<String, Object> map){
		// 查询
		map.put("about", aboutService.getAboutAuthorOfNew());
		return "about_author";
	}
	
	/**
	 * 联系我们
	 * @param map
	 * @return
	 */
	@RequestMapping(value={"/about_contact"})
	public String aboutContact(Map<String, Object> map){
		// 查询
		map.put("about", aboutService.getAboutContactOfNew());
		return "about_contact";
	}
	
	/**
	 * 公告
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value={"/announcement/{id}"})
	public String announce(@PathVariable("id") String id, Map<String, Object> map){
		// 查询
		map.put("announce", announcementService.getAnnouncement(id));
		return "announcement";
	}
	
	/**
	 * 公告列表
	 * @param map
	 * @return
	 */
	@RequestMapping(value={"/announcement_list"})
	public String announceList(Map<String, Object> map){
		// 查询
		return announceList(map, 1);
	}
	
	/**
	 * 公告列表
	 * @param map
	 * @return
	 */
	@RequestMapping(value={"/announcement_list/{page}"})
	public String announceList(Map<String, Object> map, @PathVariable("page") int pageNo){
		// 查询
		int count = announcementService.getAnnouncementCount();
		
		BasePageResponse<List<Announcement>> response = new BasePageResponse<>(pageNo, count);
		response.setData(announcementService.getAnnouncementList(response.getPageNo(), response.getPageSize()));
		
		map.put("response", response);
		
		
		return "announcement_list";
	}
	
	/**
	 * 友情链接
	 * @param map
	 * @return
	 */
	@RequestMapping(value={"/friend"})
	public String friend(){
		return "friend";
	}
	
	/**
	 * 友情链接-页脚
	 * @param map
	 * @return
	 */
	@RequestMapping(value={"/friend_foot"})
	public @ResponseBody BaseResponse<List<FriendLink>> friendFoot(){
		// 查询
		List<FriendLink> list = friendService.getFriendLinkListOfAccept(1, 20);
		return new BaseResponse<List<FriendLink>>(list);
	}
	
	/**
	 * 提交友情链接
	 * @param map
	 * @return
	 */
	@RequestMapping(value={"/submit_friend"})
	public @ResponseBody BaseResponse<Integer> addFriend(HttpSession session, FriendLink link){
		// 判断是否登录
		User user = (User) session.getAttribute("user");
		if (user == null) {
			throw new CommonException(ExceptionEnum.RE_LOGIN.code, ExceptionEnum.RE_LOGIN.msg);
		}
		link.setFlUser(new User(user.getUserId()));
		// 添加
		int data = friendService.addFriend(link);
		return new BaseResponse<Integer>(ExceptionEnum.ADD_FRIEND_SUCCESS.msg, data);
	}
	
	/**
	 * 搜索结果
	 * @param key
	 * @param map
	 * @return
	 * @throws IOException 
	 * @throws SolrServerException 
	 * @throws ParseException 
	 */
	@RequestMapping(value={"/search_result"})
	public String search(@RequestParam("key") String key, Map<String, Object> map) throws SolrServerException, IOException, ParseException{
		// 搜索结果
		List<SolrPostDTO> list = IsaySolrRepository.queryOfHighlightIsayPost(log, key);
		map.put("data", list);
		map.put("key", key);
		return "search_result";
	}
	
	/**
	 * 时间轴
	 * @param map
	 * @return
	 */
	@RequestMapping(value={"/timeline"})
	public String timeline(Map<String, Object> map){
		map.put("timeline", timeLineService.getTimeLineList());
		return "time_line";
	}
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping(value={"/login_p"})
	public String loginPage(){
		return "login";
	}
	
	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping(value={"/register_p"})
	public String registerPage(){
		return "register";
	}
	
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/";
	}
	
	/**
	 * 登录，RequestMethod=post
	 * @param request
	 * @param attr
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password){
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(email, password);
		
		subject.login(token);
		
		User principal = (User) subject.getPrincipal();
		if("1".equals(principal.getShield())) {
			throw new CommonException(ExceptionEnum.LOGIN_CANCEL.code, ExceptionEnum.LOGIN_CANCEL.msg);
		}
		session.setAttribute("user", principal);
		session.setAttribute("infusion", postService.getPostInfusionForUser(principal.getUserId()));
		
		return "redirect:/";
	}
	
	/**
	 * 注册：成功之后直接登录，先跳转到成功页面
	 * @param user
	 * @return
	 */
	@RequestMapping("/register")
	public String register(HttpSession session, User user){
		int i = userService.addUser(user);
		if(i != 1) {
			session.setAttribute("error", ExceptionEnum.REGISTER_FAILED.msg);
			return "redirect:/error";
		}
		session.setAttribute("success", ExceptionEnum.REGISTER_SUCCESS.msg);
		return "redirect:/success";
	}
	
	/**
	 * 校验用户名
	 * @param nickname
	 * @return
	 */
	@RequestMapping(value = "/checkNickName", method = RequestMethod.GET)
	public @ResponseBody BaseResponse<Integer> checkNickName(@RequestParam("nickname") String nickname){
		return new BaseResponse<Integer>(userService.checkNickName(nickname));
	}
	
	/**
	 * 校验邮箱
	 * @param userEmail
	 * @return
	 */
	@RequestMapping(value = "/checkUserEmail", method = RequestMethod.GET)
	public @ResponseBody BaseResponse<Integer> checkUserEmail(@RequestParam("userEmail") String userEmail){
		return new BaseResponse<Integer>(userService.checkEmail(userEmail));
	}
	
	/**
	 * 找回密码页面：未实现
	 * @return
	 */
	@RequestMapping("/find_password")
	public String findPassword() {
		return "find_password";
	}
	
	/**
	 * 验证邮箱，发送验证码
	 * @param email
	 * @return
	 */
	@RequestMapping("/check_email")
	public @ResponseBody BaseResponse<String> checkEmail(HttpSession session, @RequestParam("email") String email){
		// 生成验证码，保存到session
		String validCode = IDUtils.createToken();
		String content = "<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Isay邮件通知</title><style type='text/css'>        .container{            font-family: 'Microsoft YaHei';            width: 600px;            margin: 0 auto;            padding: 8px;            border: 3px dashed #db303f;            border-radius: 6px;        }        .title{            text-align: center;            color: #db303f;        }        .content{            text-align: justify;            color: #717273;            font-weight: 600;        }        footer{            text-align: right;            color: #db303f;            font-weight: 600;            font-size: 18px;        }</style></head><body><div class='container'><h2 class='title'>ISay验证码</h2><p class='content'>您的验证码为："+ validCode +"</p><footer>Isay邮件通知</footer></div></body></html>";
		new Thread(new Sending(email, "ISay通知", content, null)).start();
		session.setAttribute("validCode", validCode);
		return new BaseResponse<String>("我们已将您的验证码发送到您的邮箱，请注意查收！");
	}
	
	/**
	 * 验证验证码，与保存在session里面的验证码比对
	 * @param code
	 * @return
	 */
	@RequestMapping("/check_code")
	public @ResponseBody BaseResponse<Boolean> checkValidateCode(HttpSession session, @RequestParam("validCode") String validCode){
		String code = (String) session.getAttribute("validCode");
		return new BaseResponse<Boolean>(code.equals(validCode));
	}
	
	/**
	 * 提交新密码：未实现
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/submit_new_pass")
	public Map<String,Object> addNewPassword(String password){
		Map<String,Object> map = new HashMap<>();
		
		return map;
	}
	
	/**
	 * 错误页面
	 * @param request
	 * @param attr
	 * @return
	 */
	@RequestMapping("/error")
	public String error(){
		return "tip/error";
	}
	
	/**
	 * 成功界面
	 * @param request
	 * @param attr
	 * @return
	 */
	@RequestMapping("/success")
	public String success(){
		return "tip/success";
	}
	
	/**
	 * 404页面
	 * @return
	 */
	@RequestMapping("/404")
	public String notFound(){
		return "tip/404";
	}
	
}
