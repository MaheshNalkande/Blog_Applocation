package com.blog.app.services;

import java.util.List;

import com.blog.app.entities.Category;
import com.blog.app.entities.Post;
import com.blog.app.payloads.PostDto;

public interface PostService {

	// Post Creation
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// Update post
	Post updatePost(PostDto postDto, Integer postId);

	// Delete post
	void deletePost(Integer postId);

	// Get all posts
	List<Post> getAllPosts();

	//Get post by Id
	Post getPostById(Integer postId);
	
	//Get posts by category
	List<Post> getAllPostsByCategory(Integer categoryId);
	
	//Get all posts by user
	List<Post> getAllPostsByUser(Integer userId);
	
	//Search posts
	List<Post> searchPosts(String Keyword);
}
