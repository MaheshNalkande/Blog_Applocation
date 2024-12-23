package com.blog.app.payloads;

import com.blog.app.entities.Category;
import com.blog.app.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer postId;

	private String title;

	private String content;

	private String imageName;

	private CategoryDTO category;

	private UserDto user;

}
