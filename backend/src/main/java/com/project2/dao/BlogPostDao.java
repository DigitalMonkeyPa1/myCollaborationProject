package com.project2.dao;

import java.util.List;

import com.project2.model.BlogComment;
import com.project2.model.BlogPost;

public interface BlogPostDao {
	
	void addBlogPost(BlogPost blogPost);
	List<BlogPost> getBlogs(boolean approved);
	BlogPost getBlogById(int id);
	void blogApproved(int id);
	void blogRejected(int id,String rejectionReason);
	void addBlogComment(BlogComment blogComment);
	List<BlogComment> getAllBlogComments(int blogPostId);
}
