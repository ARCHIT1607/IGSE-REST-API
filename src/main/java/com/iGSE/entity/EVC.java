package com.iGSE.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EVC")
public class EVC {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "image", unique = false, nullable = false, length = 100000)
	private byte[] image;

	@Column(name = "evc", unique = true, nullable = false)
	private String evc;
	
	@Column(name = "isExpired", unique = false)
	private boolean isExpired;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getEvc() {
		return evc;
	}

	public void setEvc(String evc) {
		this.evc = evc;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public EVC(Long id, String name, String type, byte[] image, String evc, boolean isExpired) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.image = image;
		this.evc = evc;
		this.isExpired = isExpired;
	}

	public EVC() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EVC [id=" + id + ", name=" + name + ", type=" + type + ", image=" + Arrays.toString(image) + ", evc="
				+ evc + ", isExpired=" + isExpired + "]";
	}

}
