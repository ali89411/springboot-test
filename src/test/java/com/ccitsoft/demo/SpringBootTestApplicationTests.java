package com.ccitsoft.demo;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ccitsoft.domain.Student;
import com.ccitsoft.repository.CommonJPA;
import com.ccitsoft.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.ccitsoft.mapper")
public class SpringBootTestApplicationTests {

	
	@Autowired
	private CommonJPA teacherJpa;
	
	@Autowired
    private StudentService studentService;
	
	@Test
	public void contextLoads() {
		
	}

	@Test
	public void getInfo(){
		teacherJpa.deleteById("2");
		System.out.println("=");
	}
	
	@Test
    public void testInsert() {
		for (int i = 0; i < 10; i++) {
			 Student student = new Student();
	         student.setName("lic"+10*i);
	         student.setSex("28");
	         studentService.insert(student);
		}
       
    }
	
	@Test
    public void testUpdate() {
        Student student = new Student();
        student.setId(1);
        student.setName("lic1");
        student.setSex("28");
        studentService.update(student);
    }
	
	@Test
    public void testByid() {
        Student selectById = studentService.selectById(1L);
        System.out.println(selectById.toString());
    }
	
	@Test
    public void deleteByid() {
        int delete = studentService.delete(1L);
        assertTrue(delete == 1);
    }
	
	
	@Test
    public void count() {
        Long queryCount = studentService.queryCount(new Student());
        assertTrue(queryCount == 11);
    }
	
	@Test
    public void queryByPage() {
		Student student = new Student();
        student.setName("lic10");
        List<Student> queryList = studentService.queryList(student, 10, 1);
        assertTrue(queryList.size() == 1);
    }
	
}
