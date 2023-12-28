package com.project.notetaker.entities;

import java.util.Date;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="notes")
@Data
public class Note {
	@Id
	private int id;
	private String title;
	@Column(length = 2000)
	private String content;
	private Date addedDate;
	
	public Note(String title, String content, Date addedDate) {
		super();
		this.id = new Random().nextInt(1000);
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
	}

	public Note() {
		super();
	}
	
	

}

