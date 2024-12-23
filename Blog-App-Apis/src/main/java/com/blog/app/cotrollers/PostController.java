package com.blog.app.cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.payloads.API_Response;
import com.blog.app.payloads.PostDto;
import com.blog.app.payloads.PostResponse;
import com.blog.app.services.PostService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;

//	create
	@PostMapping("user/{userId}/category/{categoryId}/post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {

		PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);

	}

	// Get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {
		List<PostDto> postsByUser = this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK);

	}

	// Get by Category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {
		List<PostDto> postsByCategory = this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postsByCategory, HttpStatus.OK);

	}

//	 Get all posts
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(value = "sortby", defaultValue = "postId", required = false) String sortBy,
			@RequestParam(value ="sortDir",defaultValue = "asc", required = false)String sortDir) {

		PostResponse postResponse = this.postService.getAllPosts(pageNumber, pageSize,sortBy,sortDir);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}

//	 Get post by id
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable Integer postId) {
		PostDto post = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}

// delete post 
	@DeleteMapping("/post/{postId}")
	public API_Response deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new API_Response("Post is successfully deleted...", true);

	}

//	 Update post
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
		PostDto updatedPost = this.postService.updatePost(postDto, postId);

		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
	}

}
