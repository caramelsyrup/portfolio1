package com.mysql.pro.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity(name = "board")
public class Board {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String writer;
	
	@NotNull
	private String title;
	
	@NotNull
	private String content;
	
	@NotNull
	@ColumnDefault(value = "1")
	private Long readcount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;
	
	
	
}
