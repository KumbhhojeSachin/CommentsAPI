package com.Comments.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * 
 * @author skumbhoj
 *
 */
@Entity
@Table(name = "Comments_Table", schema = "public")
public class Comments implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private BigInteger id;
	private String name;
	private String text;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfComment;

	public Comments() {
		super();
	}

	public Comments(BigInteger id, String name, String text, Date dateOfComment) {
		super();
		this.id = id;
		this.name = name;
		this.text = text;
		this.dateOfComment = dateOfComment;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateOfComment() {
		return dateOfComment;
	}

	public void setDateOfComment(Date dateOfComment) {
		this.dateOfComment = dateOfComment;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", name=" + name + ", text=" + text + ", dateOfComment=" + dateOfComment + "]";
	}

}
