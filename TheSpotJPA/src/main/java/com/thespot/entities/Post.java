package com.thespot.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Post {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String body;
	
	private String image;
	
	@CreationTimestamp
	@Column(name="post_date")
	private LocalDateTime postDate;
	
	private String title;


	public Post() {}


	public Post(int id, String body, String image, LocalDateTime postDate, String title) {
		super();
		this.id = id;
		this.body = body;
		this.image = image;
		this.postDate = postDate;
		this.title = title;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public LocalDateTime getPostDate() {
		return postDate;
	}


	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public int hashCode() {
		return Objects.hash(body, id, image, postDate, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(body, other.body) && id == other.id && Objects.equals(image, other.image)
				&& Objects.equals(postDate, other.postDate) && Objects.equals(title, other.title);
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", body=" + body + ", image=" + image + ", postDate=" + postDate + ", title=" + title
				+ "]";
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
