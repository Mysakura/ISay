package com.internetsaying.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.post.entity.PostComment;
import com.internetsaying.post.entity.PostReply;

@Repository
public interface PostCommentDAO {
	
	/**
	 * 添加帖子评论
	 * @param comment
	 * @return
	 */
	int addPostComment(PostComment comment);
	
	/**
	 * 删除帖子评论，仅仅本人或者有删除权限的管理员可以操作，实际上是更新is_delete字段
	 * @param comment
	 * @return
	 */
	int updatePostComment(PostComment comment);
	
	/**
	 * 验证评论的所有者
	 * @param userId
	 * @param commentId
	 * @return
	 */
	int checkCommentOwner(@Param("userId") String userId, @Param("commentId") String commentId);
	
	/**
	 * 获得帖子下面的评论
	 * @param postId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<PostComment> getPostCommentList(@Param("postId") String postId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 添加帖子回复
	 * @param reply
	 * @return
	 */
	int addPostReply(PostReply reply);
	
	/**
	 * 删除帖子回复，仅仅本人或者有删除权限的管理员可以操作，实际上是更新is_delete字段
	 * @param reply
	 * @return
	 */
	int updatePostReply(PostReply reply);
	
	/**
	 * 验证回复的所有者
	 * @param userId
	 * @param commentId
	 * @return
	 */
	int checkReplyOwner(@Param("userId") String userId, @Param("replyId") String replyId);
	
	/**
	 * 获取某一条评论下面的回复列表
	 * @param commentId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<PostReply> getCommentReplyList(@Param("commentId") String commentId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 获取评论数
	 * @return
	 */
	int getAllCommentCount();
	
	/**
	 * 获取文章评论数
	 * @return
	 */
	int getCommentCount(@Param("postId") String postId);
	
	/**
	 * 获取回复数
	 * @param commentId
	 * @return
	 */
	int getReplyCount(@Param("commentId") String commentId);
	
	/**
	 * 获取评论内容
	 * @param commentId
	 * @return
	 */
	String getPostIdById(@Param("commentId") String commentId);
}
