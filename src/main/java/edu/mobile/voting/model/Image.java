package edu.mobile.voting.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_image", nullable = false, unique = true)
	private Blob userImage;

	public Blob getUserImage() {
		return userImage;
	}

	public void setUserImage(Blob userImage) {
		this.userImage = userImage;
	}

	public int getId() {
		return id;
	}
	
	
}
