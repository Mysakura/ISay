package com.internetsaying.post.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.post.dto.PostInfusion;
import com.internetsaying.post.entity.AreaLabel;
import com.internetsaying.post.entity.Post;

@Repository
public interface PostDAO {

	int addPost(Post post);
	
	int addPostLabel(@Param("postId") String postId, @Param("labels") Set<AreaLabel> labels);
	
	int delPostLabel(@Param("postId") String postId, @Param("labels") Set<AreaLabel> labels);
	
	int updatePost(Post post);
	
	/**
	 * 检查帖子与用户是否有关系
	 * @param userId
	 * @param postId
	 * @return
	 */
	int checkPost(@Param("userId") String userId,@Param("postId") String postId);
	
	Set<AreaLabel> getPostLabels(@Param("postId") String postId);
	
	/**
	 * 文章具体信息
	 * @param postId
	 * @return
	 */
	Post getPostById(@Param("postId") String postId);
	
	/**
	 * 读出信息以供修改
	 * @param postId
	 * @return
	 */
	Post getPostByIdForModify(@Param("postId") String postId);
	
	List<Post> getAllPost(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	List<Post> getAllPostOfDel(@Param("isDelete") String isDelete, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	List<Post> getPostListOfUser(@Param("userId") String userId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	List<Post> getPostByClassifyOfNew(@Param("classifyId") int classifyId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	List<Post> getPostByClassifyOfHot(@Param("classifyId") int classifyId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	List<Post> getPostByClassifyOfArea(@Param("classifyId") int classifyId, @Param("areaId")int areaId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 参数为Object
	 * @param ids
	 * @return
	 */
	List<Post> getPostOfSpecific(@Param("ids") Set<Object> ids);
	
	/**
	 * 参数为String
	 * @param ids
	 * @return
	 */
	List<Post> getSpecificPosts(@Param("ids") Set<String> ids);
	
	int getAllPostCount();
	
	int getAllPostOfDelCount(@Param("isDelete") String isDelete);
	
	int getPostCountOfUser(@Param("userId") String userId);
	
	int getPostCountForClassify(@Param("classifyId") int classifyId);
	
	int getPostCountOfAreaForClassify(@Param("classifyId") int classifyId, @Param("areaId")int areaId);
	
	PostInfusion getPostInfusionForUser(@Param("userId") String userId);
}
