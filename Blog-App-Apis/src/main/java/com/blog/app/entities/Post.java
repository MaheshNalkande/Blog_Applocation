package com.blog.app.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post id")
	private Integer Id;

	@Column(name = "post title")
	private String title;

	@Column(name = "Post content", length = 5000)
	private String content;

	@Column(name = "image", length = 10000)
	private String image;

	@Column(name = "Date")
	private Date addedDate;

	@ManyToOne
	@JoinColumn(name = "category Id")
	private Category category;

	@ManyToOne
	private User user;

}
