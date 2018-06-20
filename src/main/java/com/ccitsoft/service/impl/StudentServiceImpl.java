package com.ccitsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccitsoft.domain.Student;
import com.ccitsoft.mapper.StudentMapper;
import com.ccitsoft.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public int delete(Long id) {
		return studentMapper.delete(id);
	}

	@Override
	public int insert(Student record) {
		return studentMapper.insert(record);
	}

	@Override
	public Student selectById(Long id) {
		return studentMapper.selectById(id);
	}

	@Override
	public int update(Student record) {
		return studentMapper.update(record);
	}

	@Override
	public List<Student> queryList(Student student, int pageSize, int offset) {
		return studentMapper.queryList(student, pageSize, offset);
	}

	@Override
	public Long queryCount(Student student) {
		return studentMapper.queryCount(student);
	}

}
