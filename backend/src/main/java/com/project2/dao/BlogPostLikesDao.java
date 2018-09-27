package com.project2.dao;

import com.project2.model.BlogPost;
import com.project2.model.BlogPostLikes;

public interface BlogPostLikesDao {
BlogPostLikes hasUserLikedPost(int postId,String email);
BlogPost updateLikes(int postId,String email);
}
