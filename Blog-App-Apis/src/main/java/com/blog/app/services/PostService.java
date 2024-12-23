package com.blog.app.services;

import java.util.List;

import com.blog.app.entities.Post;
import com.blog.app.payloads.PostDto;
import com.blog.app.payloads.PostResponse;

public interface PostService {

	// Post Creation
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// Update post
	PostDto updatePost(PostDto postDto, Integer postId);

	// Delete post
	void deletePost(Integer postId);

	// Get all posts
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

	//Get post by Id
	PostDto getPostById(Integer postId);
	
	//Get posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//Get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//Search posts
	List<Post> searchPosts(String Keyword);
}
