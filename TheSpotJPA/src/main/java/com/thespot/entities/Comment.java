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
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String body;
	
	@CreationTimestamp
	@Column(name="comment_date")
	private LocalDateTime commentDate;
	
	public Comment() {}

	public Comment(int id, String body, LocalDateTime commentDate) {
		super();
		this.id = id;
		this.body = body;
		this.commentDate = commentDate;
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

	public LocalDateTime getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDateTime commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(body, commentDate, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(body, other.body) && Objects.equals(commentDate, other.commentDate) && id == other.id;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", body=" + body + ", commentDate=" + commentDate + "]";
	};
	
	

}
