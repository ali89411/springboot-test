package com.ccitsoft.domain;

import java.io.Serializable;
/**
 * <p>Description: [实体信息----mybatis方式]</p>
 * Created on 2018年6月12日
 * @author  <a href="mailto: lichao8941188@163.com">李超</a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class Student implements Serializable {

	/**
	 * <p>* Discription:[字段功能描述]</p>
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}
	
}
