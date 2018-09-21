package com.internetsaying.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.internetsaying.common.base.BasePageResponse;
import com.internetsaying.common.base.BaseResponse;
import com.internetsaying.common.base.dto.UploadDTO;
import com.internetsaying.common.enums.DeleteStatus;
import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.site.entity.MessageBoard;
import com.internetsaying.site.entity.MessageBoardReply;
import com.internetsaying.site.service.MessageBoardService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;
import com.internetsaying.utils.UploadFileUtils;

/**
 * 完成 2018-05-10
 * @author dong
 *
 */
@Controller
public class MessageBoardController {
	
	@Autowired
	private MessageBoardService messageBoardService;
	
	private static Logger log = LoggerFactory.getLogger(MessageBoardController.class);

	private User globalCheckUser(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null)
			throw new CommonException(ExceptionEnum.LOGIN_INFO_OVERDUE.code, ExceptionEnum.LOGIN_INFO_OVERDUE.msg);
		return user;
	}
	
	/**
	 * 留言板
	 * @param map
	 * @return
	 */
	@RequestMapping("/message_board")
	public String messageBoard(Map<String, Object> map){
		// 查询
		return messageBoard(1, map);
	}
	
	/**
	 * 留言板分页
	 * @param map
	 * @return
	 */
	@RequestMapping("/message_board/{page}")
	public String messageBoard(@PathVariable("page") int page, Map<String, Object> map){
		// 查询
		int count = messageBoardService.getMessageCount();
		BasePageResponse<List<MessageBoard>> response = new BasePageResponse<>(page, count);
		response.setData(messageBoardService.getMessageList(response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		return "message_board";
	}
	
	/**
	 * 提交留言
	 * @param session
	 * @param board
	 * @return
	 */
	@RequestMapping("/submit_message")
	public @ResponseBody BaseResponse<MessageBoard> addMessage(HttpSession session, MessageBoard board){
		log.info("留言：留言内容：{}",board.getMessageContent());
		User user = globalCheckUser(session);
		Date time = new Date();
		board.setMessageId(IDUtils.createID20(time));	// ID
		board.setUser(new User(user.getUserId(), user.getNickname(), user.getUserPhoto()));		// 用户
		board.setMessageTime(time);						// 留言时间
		
		BaseResponse<MessageBoard> response = null;
		int i = messageBoardService.addMessage(board);
		if(i == 1) {
			response = new BaseResponse<>(board);
		}else {
			response = new BaseResponse<>(null);	// 测试如果返回null，前台是undefined还是什么
		}
		return response;
	}
	
	/**
	 * 提交留言回复
	 * @param session
	 * @param board
	 * @return
	 */
	@RequestMapping("/submit_message_reply")
	public @ResponseBody BaseResponse<MessageBoardReply> addMessageReply(HttpSession session, MessageBoardReply reply){
		log.info("留言回复：留言ID：{}，回复内容：{}，回复目标：{}",reply.getMrMessage().getMessageId(), reply.getMrContent(), reply.getToUser().getUserId());
		User user = globalCheckUser(session);
		Date time = new Date();
		String mrId = IDUtils.createID20(time);
		reply.setMrId(mrId);
		reply.setFromUser(new User(user.getUserId(), user.getNickname(), user.getUserPhoto()));
		reply.setMrTime(time);
		BaseResponse<MessageBoardReply> response = null;
		int i = messageBoardService.addReply(reply);
		if(i == 1) {
			response = new BaseResponse<>(reply);
		}else {
			response = new BaseResponse<>(null);
		}
		return response;
	}
	
	/**
	 * 删除留言
	 * @param session
	 * @param board
	 * @return
	 */
	@RequestMapping("/delete_message")
	public @ResponseBody BaseResponse<Integer> deleteMessage(HttpSession session, MessageBoard board){
		User user = globalCheckUser(session);
		log.info("删除留言：操作者：{}，留言ID：{}",user.getUserId(), board.getMessageId());
		board.setUser(user);
		board.setIsDelete(DeleteStatus.ALR_DEL.code);
		return new BaseResponse<>(messageBoardService.deleteMessage(board));
	}
	
	/**
	 * 删除留言回复
	 * @param session
	 * @param board
	 * @return
	 */
	@RequestMapping("/delete_message_reply")
	public @ResponseBody BaseResponse<Integer> deleteMessageReply(HttpSession session, MessageBoardReply reply){
		User user = globalCheckUser(session);
		log.info("删除留言的回复：操作者：{}，回复ID：{}",user.getUserId(), reply.getMrId());
		reply.setFromUser(user);
		reply.setIsDelete(DeleteStatus.ALR_DEL.code);
		return new BaseResponse<>(messageBoardService.deleteReply(reply));
	}
	
	//上传留言图片
	@RequestMapping(value="/upload_message_pic")
	public @ResponseBody BaseResponse<UploadDTO> uploadUserPic(HttpServletRequest request,HttpSession session,
			@RequestParam(value="imgFile", required=true) MultipartFile file) throws IOException{
		UploadDTO dto = UploadFileUtils.upload(request, session, file, "message", log);
		return new BaseResponse<UploadDTO>(dto);
	}
}
