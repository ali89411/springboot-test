package com.ccitsoft.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * <p>Description: [模拟实体类----JPA方式]</p>
 * Created on 2018年5月11日
 * @author  <a href="mailto: lichao8941188@163.com">李超</a>
 * @version 1.0 
 * 主键策略生产UUID
 * @GenericGenerator(name = "system-uuid", strategy = "uuid")
 *	@GeneratedValue(generator = "system-uuid")
 * Copyright (c) 2018
 */
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable{

	/**
	 * <p>Discription:[字段功能描述]</p>
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	// 自增
	@GeneratedValue(generator = "system-uuid")
	@Column
	private String id;

	@Column
	private String sex;

	@Column
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
