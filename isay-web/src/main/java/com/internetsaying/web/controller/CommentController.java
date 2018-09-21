package com.internetsaying.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.internetsaying.common.base.BaseJSONPageResponse;
import com.internetsaying.common.base.BaseResponse;
import com.internetsaying.common.base.dto.UploadDTO;
import com.internetsaying.common.enums.DeleteStatus;
import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.post.entity.PostComment;
import com.internetsaying.post.entity.PostReply;
import com.internetsaying.post.service.PostCommentService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;
import com.internetsaying.utils.UploadFileUtils;

/**
 * 负责帖子的评论回复
 * @author 001977
 *
 */
@Controller
public class CommentController {
	
	@Autowired
	private PostCommentService postCommentService;

	private static Logger log = LoggerFactory.getLogger(CommentController.class);
	
	private User globalCheckUser(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null)
			throw new CommonException(ExceptionEnum.LOGIN_INFO_OVERDUE.code, ExceptionEnum.LOGIN_INFO_OVERDUE.msg);
		return user;
	}
	
	/**
	 * 获取评论的回复
	 * @param commantId
	 * @return
	 */
	@RequestMapping("/getPostReplies")
	public @ResponseBody BaseJSONPageResponse<List<PostReply>> getReplies(@RequestParam("pageNo") int pageNo, @RequestParam("commentId") String commentId){
		int replyCount = postCommentService.getReplyCount(commentId);
		BaseJSONPageResponse<List<PostReply>> response = new BaseJSONPageResponse<>(pageNo, replyCount);
		response.setData(postCommentService.getCommentReplyList(commentId, response.getPageNo(), response.getPageSize()));
		return response;
	}
	
	/**
	 * 获取评论
	 * @param postId
	 * @return
	 */
	@RequestMapping("/getPostComments")
	public @ResponseBody BaseJSONPageResponse<List<PostComment>> getComments(@RequestParam("pageNo") int pageNo, @RequestParam("postId") String postId){
		int commentCount = postCommentService.getCommentCount(postId);
		BaseJSONPageResponse<List<PostComment>> response = new BaseJSONPageResponse<>(pageNo, commentCount);
		response.setData(postCommentService.getPostCommentList(postId, response.getPageNo(), response.getPageSize()));
		return response;
	}
	
	/**
	 * 添加评论
	 * @param session
	 * @param comment
	 * @return
	 */
	@RequestMapping("/addComment")
	public @ResponseBody BaseResponse<PostComment> addComment(HttpSession session, PostComment comment) {
		log.info("帖子评论：评论内容：{}",comment.getCommentContent());
		User user = globalCheckUser(session);
		Date time = new Date();
		comment.setCommentId(IDUtils.createID20(time));
		comment.setUser(user);
		comment.setCommentTime(time);
		
		BaseResponse<PostComment> response = null;
		int i = postCommentService.addPostComment(comment);
		if(i == 1) {
			response = new BaseResponse<>(comment);
		}else {
			response = new BaseResponse<>(null);	// 测试如果返回null，前台是undefined还是什么
		}
		return response;
	}
	
	/**
	 * 添加回复
	 * @param session
	 * @param reply
	 * @return
	 */
	@RequestMapping("/addReply")
	public @ResponseBody BaseResponse<PostReply> addReply(HttpSession session, PostReply reply) {
		log.info("帖子评论回复：评论内容回复：{}", reply.getReplyContent());
		User user = globalCheckUser(session);
		Date time = new Date();
		reply.setReplyId(IDUtils.createID20(time));
		reply.setReplyUser(new User(user.getUserId(), user.getNickname(), user.getUserPhoto()));
		reply.setReplyTime(time);
		
		BaseResponse<PostReply> response = null;
		int i = postCommentService.addPostReply(reply);
		if(i == 1) {
			response = new BaseResponse<>(reply);
		}else {
			response = new BaseResponse<>(null);	// 测试如果返回null，前台是undefined还是什么
		}
		return response;
	}
	
	/**
	 * 删除评论
	 * @param session
	 * @param comment
	 * @return
	 */
	@RequestMapping("/delComment")
	public @ResponseBody BaseResponse<Integer> delComment(HttpSession session, PostComment comment) {
		User user = globalCheckUser(session);
		log.info("删除评论：操作者：{}，评论ID：{}，帖子ID：{}",user.getUserId(), comment.getCommentId(), comment.getPost().getPostId());
		comment.setUser(user);
		comment.setIsDelete(DeleteStatus.ALR_DEL.code);
		return new BaseResponse<>(postCommentService.deletePostComment(comment));
	}
	
	/**
	 * 删除回复
	 * @param session
	 * @param reply
	 * @return
	 */
	@RequestMapping("/delReply")
	public @ResponseBody BaseResponse<Integer> delReply(HttpSession session, PostReply reply) {
		User user = globalCheckUser(session);
		log.info("删除评论的回复：操作者：{}，回复ID：{}，评论ID：{}",user.getUserId(), reply.getReplyId(), reply.getPostComment().getCommentId());
		reply.setReplyUser(user);
		reply.setIsDelete(DeleteStatus.ALR_DEL.code);
		return new BaseResponse<>(postCommentService.deletePostReply(reply));
	}
	
	/**
	 * 上传评论图片
	 * @param request
	 * @param session
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/upload_comment_img")
	public @ResponseBody BaseResponse<UploadDTO> uploadBg(HttpServletRequest request,HttpSession session,
			@RequestParam("imgFile") MultipartFile file) throws IOException{
		UploadDTO dto = UploadFileUtils.upload(request, session, file, "comment", log);
		return new BaseResponse<UploadDTO>(dto);
	}
	
}
