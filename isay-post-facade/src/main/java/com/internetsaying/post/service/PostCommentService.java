package com.internetsaying.post.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.post.entity.PostComment;
import com.internetsaying.post.entity.PostReply;

/**
 * 帖子评论回复业务
 * @author dong
 *
 */
public interface PostCommentService {

	/**
	 * 添加帖子评论(这里是直接进缓存的，所以用户信息也要一同添加！！)
	 * @param comment
	 * @return
	 */
	int addPostComment(PostComment comment) throws CommonException;
	
	/**
	 * 删除帖子评论，仅仅本人或者有删除权限的管理员可以操作，实际上是更新is_delete字段
	 * @param comment
	 * @return
	 */
	int deletePostComment(PostComment comment) throws CommonException;
	
	/**
	 * 获得帖子下面的评论
	 * @param postId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<PostComment> getPostCommentList(String postId, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 添加帖子回复
	 * @param reply
	 * @return
	 */
	int addPostReply(PostReply reply) throws CommonException;
	
	/**
	 * 删除帖子回复，仅仅本人或者有删除权限的管理员可以操作，实际上是更新is_delete字段
	 * @param reply
	 * @return
	 */
	int deletePostReply(PostReply reply) throws CommonException;
	
	/**
	 * 获取某一条评论下面的回复列表
	 * @param commentId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<PostReply> getCommentReplyList(String commentId, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获取所有评论数--貌似没啥用
	 * @return
	 */
	int getAllCommentCount() throws CommonException;
	
	/**
	 * 获取帖子的评论数
	 * @return
	 */
	int getCommentCount(String postId) throws CommonException;
	
	/**
	 * 获取评论下面的回复数
	 * @param commentId
	 * @return
	 */
	int getReplyCount(String commentId) throws CommonException;
	
	/**
	 * 根据id获取评论
	 * @param commentId
	 * @return
	 */
	PostComment getCommentById(String commentId) throws CommonException;
}
