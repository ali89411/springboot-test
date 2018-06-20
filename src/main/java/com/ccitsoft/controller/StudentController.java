package com.ccitsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ccitsoft.domain.Student;
import com.ccitsoft.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * <p> Description: [Restful--API]</p>
 * Created on 2018年6月13日
 * @author <a href="mailto: lichao8941188@163.com">李超</a>
 * @version 1.0 Copyright (c) 2018
 */
@Api("测试类student接口")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@ApiOperation(value = "添加学生信息", notes = "添加学生信息", tags = "student",httpMethod = "POST")
	@ApiResponses({
          @ApiResponse(code=200,message="成功",response=Integer.class),
    })
	@RequestMapping(value = "rest/student", method = RequestMethod.POST)
	public Integer saveArticle(@RequestBody Student student) {
		return studentService.insert(student);
	}

	 @ApiOperation(value = "删除学生信息", notes = "根据ID删除学生信息", tags = "student",httpMethod = "DELETE")
	@RequestMapping(value = "rest/student/{id}", method = RequestMethod.DELETE)
	public Integer deleteArticle(@PathVariable Long id) {
		return studentService.delete(id);
	}

	 @ApiOperation(value = "更新学生信息", notes = "更新学生信息", tags = "student",httpMethod = "PUT")
	    @ApiImplicitParams({
	            @ApiImplicitParam(name = "name", value = "姓名", required = false, dataType = "String"),
	            @ApiImplicitParam(name = "sex", value = "性别", required = false, dataType = "String"),
	})
	@RequestMapping(value = "rest/student/{id}", method = RequestMethod.PUT, produces = "application/json")
	public Integer updateArticle(@PathVariable Long id,
			@RequestParam(value = "name",required = false)  String name,
			@RequestParam(value = "sex",required = false)  String sex
			) {
		Student student = studentService.selectById(id);
		student.setSex(sex);
		return studentService.update(student);
	}

	@ApiOperation(value = "获取学生信息", notes = "可以根据学生名字模糊查询", tags = "student",httpMethod = "GET")
	    @ApiImplicitParams({
	            @ApiImplicitParam(name = "name", value = "学生姓名", required = false, dataType = "String"),
	            @ApiImplicitParam(name = "pageSize", value = "每页文章数量", required = false, dataType = "Integer"),
	            @ApiImplicitParam(name = "pageNum", value = "分页的页码", required = false, dataType = "Integer")
	})
	@RequestMapping(value = "rest/student", method = RequestMethod.GET)
	public String getArticle(
			@RequestParam(value = "name",required = false)  String name,
			@RequestParam(value = "pageSize",required = false) Integer pageSize,
			@RequestParam(value = "pageNum",required = false) Integer pageNum
			) {
		List<Student> list = studentService.queryList(new Student(), pageNum, pageSize);
		return JSON.toJSONString(list);
	}

}
