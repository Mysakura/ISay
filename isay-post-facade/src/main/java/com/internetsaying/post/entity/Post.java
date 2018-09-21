package com.internetsaying.post.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.internetsaying.user.entity.User;

/**
 * 
 * 模块名称：帖子
 * 一个帖子对应一个领域
 * 一个帖子对应一个分类
 * 一个帖子对应多个标签
 * 一个帖子对应一个发帖人】
 * 
 * Comparable---排序
 *
 * @author 董昕杰
 * @since 2017年11月28日
 */
public class Post implements Comparable<Post>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1527705171754370423L;
	private String postId;
	private String postTitle;
	private String postShortCut;
	private String postContent;
	private String postMarkdown;
	private String postCover;
	private Date postTime;
	private Integer visitNum;
	private Integer upNum;
	private Integer downNum;
	private Integer collectionNum;
	private Integer commentNum;
	
	private User user;
	private Classify classify;
	private WorkArea workArea;
	private String isDelete;
	
	private User modifier;
	private Date modifyTime;
	
	private Set<AreaLabel> labels = new HashSet<>();
	private List<PostComment> comments = new ArrayList<>();
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Post(String postId) {
		super();
		this.postId = postId;
	}

	public Post(String postId, String postTitle) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
	}

	// 添加
	public Post(String postId, String postTitle, String postShortCut, String postContent, String postMarkdown,
			String postCover, Date postTime, User user, Classify classify, WorkArea workArea, User modifier, 
			Date modifyTime) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postShortCut = postShortCut;
		this.postContent = postContent;
		this.postMarkdown = postMarkdown;
		this.postCover = postCover;
		this.postTime = postTime;
		this.visitNum = 0;
		this.upNum = 0;
		this.downNum = 0;
		this.collectionNum = 0;
		this.commentNum = 0;
		this.user = user;
		this.classify = classify;
		this.workArea = workArea;
		this.isDelete = "0";
		this.modifier = modifier;
		this.modifyTime = modifyTime;
	}
	
	// 更新帖子内容-自己
	public Post(String postId, String postTitle, String postShortCut, String postContent, String postMarkdown,
			String postCover, Date modifyTime) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postShortCut = postShortCut;
		this.postContent = postContent;
		this.postMarkdown = postMarkdown;
		this.postCover = postCover;
		this.modifyTime = modifyTime;
	}
	
	// 更新帖子内容-共同
	public Post(String postId, String postTitle, String postShortCut, String postContent, String postMarkdown,
			String postCover, User modifier, Date modifyTime) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postShortCut = postShortCut;
		this.postContent = postContent;
		this.postMarkdown = postMarkdown;
		this.postCover = postCover;
		this.modifier = modifier;
		this.modifyTime = modifyTime;
	}

	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostShortCut() {
		return postShortCut;
	}
	public void setPostShortCut(String postShortCut) {
		this.postShortCut = postShortCut;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostMarkdown() {
		return postMarkdown;
	}
	public void setPostMarkdown(String postMarkdown) {
		this.postMarkdown = postMarkdown;
	}
	public String getPostCover() {
		return postCover;
	}
	public void setPostCover(String postCover) {
		this.postCover = postCover;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public Integer getVisitNum() {
		return visitNum;
	}
	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}
	public Integer getUpNum() {
		return upNum;
	}
	public void setUpNum(Integer upNum) {
		this.upNum = upNum;
	}
	public Integer getDownNum() {
		return downNum;
	}
	public void setDownNum(Integer downNum) {
		this.downNum = downNum;
	}
	public Integer getCollectionNum() {
		return collectionNum;
	}
	public void setCollectionNum(Integer collectionNum) {
		this.collectionNum = collectionNum;
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Classify getClassify() {
		return classify;
	}
	public void setClassify(Classify classify) {
		this.classify = classify;
	}
	public WorkArea getWorkArea() {
		return workArea;
	}
	public void setWorkArea(WorkArea workArea) {
		this.workArea = workArea;
	}
	public Set<AreaLabel> getLabels() {
		return labels;
	}
	public void setLabels(Set<AreaLabel> labels) {
		this.labels = labels;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public User getModifier() {
		return modifier;
	}
	public void setModifier(User modifier) {
		this.modifier = modifier;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public List<PostComment> getComments() {
		return comments;
	}
	public void setComments(List<PostComment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTitle=" + postTitle + ", postShortCut=" + postShortCut
				+ ", postContent=" + postContent + ", postMarkdown=" + postMarkdown + ", postCover=" + postCover
				+ ", postTime=" + postTime + ", visitNum=" + visitNum + ", upNum=" + upNum + ", downNum=" + downNum
				+ ", collectionNum=" + collectionNum + ", commentNum=" + commentNum + ", user=" + user + ", classify="
				+ classify + ", workArea=" + workArea + ", isDelete=" + isDelete + ", modifier=" + modifier
				+ ", modifyTime=" + modifyTime + ", labels=" + labels + ", comments=" + comments + "]";
	}

	@Override
	public int compareTo(Post o) {
		return Long.compare(this.getPostTime().getTime(), o.getPostTime().getTime());
	}
	
}
