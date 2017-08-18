package com.joe.infokeeperbackend.post.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	@GeneratedValue
	@Id
	private long id;
	
	@Column(name="source")
	private String source;
	
	@Column(name="info_id")
	private String infoId;
	
	@Column(name="info_password")
	private String infoPassword;
	
	@Column(name="key_notes")
	private String keyNotes;
	
	@Column(name="delete_yn")
	private char deleteYN;

	public Post(long id, String source, String infoId, String infoPassword, String keyNotes,char deleteYN) {
		super();
		this.id = id;
		this.source = source;
		this.infoId = infoId;
		this.infoPassword = infoPassword;
		this.keyNotes = keyNotes;
		this.deleteYN = deleteYN;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	public String getInfoPassword() {
		return infoPassword;
	}

	public void setInfoPassword(String infoPassword) {
		this.infoPassword = infoPassword;
	}

	public String getKeyNotes() {
		return keyNotes;
	}

	public void setKeyNotes(String keyNotes) {
		this.keyNotes = keyNotes;
	}

	public char getDeleteYN() {
		return deleteYN;
	}

	public void setDeleteYN(char deleteYN) {
		this.deleteYN = deleteYN;
	}
}
