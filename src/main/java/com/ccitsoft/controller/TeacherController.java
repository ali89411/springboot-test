package com.ccitsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccitsoft.domain.Teacher;
import com.ccitsoft.repository.CommonJPA;

@RestController
@RequestMapping(value="/teacher")
public class TeacherController {
	
	@Autowired
	private CommonJPA teacherJpa;
	
	@RequestMapping(value="/getList",method = RequestMethod.GET)
	public List<Teacher> getList(){
		// 返回Jsp页面
		return teacherJpa.findAll();
	}
	
	/**
	 * <p>Discription:[save OR update]</p>
	 * Created on 2018年5月11日
	 * @param name 
	 * @param sex
	 * teacherJpa.save(teacher) 主键不为null update。为null save
	 * @author:[李超]
	 */
	@RequestMapping(value="/save",method = RequestMethod.GET)
	public void save(@Param(value="name") String name,
					 @Param(value="sex") String sex,
					 @Param(value="id") String id){
		
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setName(name);
		teacher.setSex(sex);
		teacherJpa.save(teacher);
	}
	
	@RequestMapping(value="/del",method = RequestMethod.GET)
	public void del(@Param(value="id") String id){
		teacherJpa.deleteById(id);
	}
	
}
