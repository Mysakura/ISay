package com.internetsaying.post.service;

import java.util.List;
import java.util.Set;

import com.internetsaying.exception.CommonException;
import com.internetsaying.post.dto.PostInfusion;
import com.internetsaying.post.entity.AreaLabel;
import com.internetsaying.post.entity.Post;

/**
 * 帖子业务
 * @author dong
 *
 */
public interface PostService {

	/**
	 * 添加帖子，更新post表，post_label表
	 * @param post
	 * @return
	 */
	int addPost(Post post) throws CommonException;
	
	/**
	 * A集合，B集合：AB共有的不需要更改，只属于A的，要删除，只属于B的要添加
	 * 更新帖子，更新post表，post_label表，这里要注意：
	 * 如果在原来的基础上加了标签，直接添加进post_label表。
	 * 如果对于原来的标签有删除的，则需要删除老的。
	 * 当有更新操作的时候，先把老标签放入session，等用户提交修改后再放入post里，新标签放入新Set里
	 * 点击修改：先从数据库读出要显示的字段，根据所属的领域，只读出该领域下的标签。
	 * @param post
	 * @param newLabels
	 * @return
	 */
	int updatePost(Post post, Set<AreaLabel> newLabels) throws CommonException;
	
	/**
	 * 更新浏览量
	 * @param post
	 * @return
	 */
	int updateVisitNum(Post post) throws CommonException;
	
	/**
	 * 更新赞成数
	 * @param post
	 * @return
	 */
	int updateUpNum(Post post) throws CommonException;
	
	/**
	 * 更新反对数
	 * @param post
	 * @return
	 */
	int updateDownNum(Post post) throws CommonException;
	
	/**
	 * 更新收藏数
	 * @param post
	 * @return
	 */
	int updateCollectionNum(Post post) throws CommonException;
	
	/**
	 * 删除帖子，仅仅本人或者有删除权限的管理员可以操作，实际上是更新is_delete字段
	 * @param post
	 * @return
	 */
	int deletePost(Post post) throws CommonException;
	
	/**
	 * 获得帖子详细信息，需要获取标签，用户信息
	 * @param postId
	 * @return
	 */
	Post getPostById(String postId) throws CommonException;
	
	/**
	 * 获得帖子详细信息，以供修改
	 * 领域对应的标签列表需要单独调用服务获取
	 * @param postId
	 * @return
	 */
	Post getPostByIdForModify(String postId) throws CommonException;
	
	/**
	 * 获得全部帖子，分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Post> getAllPost(int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 根据是否删除获取帖子，直接从数据库
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Post> getAllPostOfDel(String isDelete, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得帖子列表，用户信息，不用获得帖子对应的标签，非删除的
	 * @param userId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Post> getPostListOfUser(String userId, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得分类最新，用户信息，非删除的
	 * @param classifyId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Post> getPostByClassifyOfNew(int classifyId, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得分类最热，用户信息，非删除的
	 * @param classifyId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Post> getPostByClassifyOfHot(int classifyId, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得分类对应的领域的帖子，时间倒序，用户信息，非删除的
	 * @param classifyId
	 * @param areaId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Post> getPostByClassifyOfArea(int classifyId, int areaId, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得全部帖子
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	int getAllPostCount() throws CommonException;
	
	/**
	 * 根据是否删除获取帖子
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	int getAllPostOfDelCount(String isDelete) throws CommonException;
	
	/**
	 * 获得用户的帖子数，非删除的
	 * @param userId
	 * @return
	 */
	int getPostCountOfUser(String userId) throws CommonException;
	
	/**
	 * 获得某个分类下的帖子数，非删除的
	 * @param classifyId
	 * @return
	 */
	int getPostCountForClassify(int classifyId) throws CommonException;
	
	/**
	 * 获得某个分类对应的领域下的帖子数，非删除的
	 * @param classifyId
	 * @param areaId
	 * @return
	 */
	int getPostCountOfAreaForClassify(int classifyId, int areaId) throws CommonException;
	
	
	/**
	 * 获得用户需要的帖子信息，以供个人主页展示
	 * select count(*) count,sum(up_num) up,sum(down_num) down from post where author_id = ''
	 * @param userId
	 * @return
	 */
	PostInfusion getPostInfusionForUser(String userId) throws CommonException;
	
	/**
	 * 获得指定的帖子列表(先不缓存了，没时间)
	 * @param postIds
	 * @return
	 */
	List<Post> getSpecificPosts(Set<String> postIds) throws CommonException;
	
	/**
	 * 检查帖子是否属于这个用户
	 * @param userId
	 * @param postId
	 * @return
	 * @throws CommonException
	 */
	int checkPost(String userId,String postId) throws CommonException;
	
	/**
	 * 已删除和未删除的帖子列表，数量！！！显示的话，只显示未删除的。
	 * 评论回复列表，数量！！！显示的话，全部显示，只不过删除的要标识出来-已删除（友好的方式）
	 * 只查询用得到的字段！！！
	 * 帖子列表展示数据少，具体帖子展示数据多
	 */
	
}
