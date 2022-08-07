package com.ezen.project.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Entity
@Table(name="message")
public class Message {
	@Id
	private Long num;
	
	private String sender;
	
	@NotEmpty
	@Column(name="receiver")
	private String receiver;
	
	@NotEmpty
	@Column(name="title")
	private String title;
	
	@NotEmpty
	@Column(name="contents")
	private String contents;
	
	private Date writeDate;
	
	private Integer readed;
}
