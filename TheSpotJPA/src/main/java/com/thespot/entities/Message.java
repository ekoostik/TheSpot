package com.thespot.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@CreationTimestamp
	@Column(name="date_sent")
	private LocalDateTime dateSent;
	
	private String body;
	
	@Column(name="is_read")
	private Boolean read;
	
	@ManyToOne
	@JoinColumn(name="sender_id")
	private User sender;
	
	@ManyToOne
	@JoinColumn(name="reciver_id")
	private User reciver;
	
	public Message() {}

	public Message(int id, LocalDateTime dateSent, String body, Boolean read) {
		super();
		this.id = id;
		this.dateSent = dateSent;
		this.body = body;
		this.read = read;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateSent() {
		return dateSent;
	}

	public void setDateSent(LocalDateTime dateSent) {
		this.dateSent = dateSent;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReciver() {
		return reciver;
	}

	public void setReciver(User reciver) {
		this.reciver = reciver;
	}

	@Override
	public int hashCode() {
		return Objects.hash(body, dateSent, id, read);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(body, other.body) && Objects.equals(dateSent, other.dateSent) && id == other.id
				&& Objects.equals(read, other.read);
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", dateSent=" + dateSent + ", body=" + body + ", read=" + read + "]";
	};
	
	

}
