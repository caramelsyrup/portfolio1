package com.mysql.pro.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity(name = "name")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String account;
	
	private String pwd;
	
	private String name;
	
	@Column(name = "reg_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
	
	
}
