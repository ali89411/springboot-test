package com.ccitsoft.service;

import java.util.List;

import com.ccitsoft.domain.Student;

public interface StudentService {

	/**
	 * <p>Discription:[根据ID删除]</p>
	 * Created on 2018年6月12日
	 * @param id
	 * @return
	 * @author:[李超]
	 */
	int delete(Long id);

	/**
	 * <p>Discription:[新增一个对象]</p>
	 * Created on 2018年6月12日
	 * @param record
	 * @return
	 * @author:[李超]
	 */
	int insert(Student record);

	/**
	 * <p>Discription:[根据主键查询]</p>
	 * Created on 2018年6月12日
	 * @param id
	 * @return
	 * @author:[李超]
	 */
	Student selectById(Long id);

	/**
	 * <p>Discription:[更新]</p>
	 * Created on 2018年6月12日
	 * @param record
	 * @return
	 * @author:[李超]
	 */
	int update(Student record);
	
	/**
	 * <p>Discription:[分页查询]</p>
	 * Created on 2018年6月12日
	 * @return
	 * @author:[李超]
	 */
	List<Student> queryList(Student student, int pageSize,int offset);

	/**
	 * <p>Discription:[方法功能中文描述]</p>
	 * Created on 2018年6月12日
	 * @param student
	 * @return 
	 * @author:[李超]
	 */
	Long queryCount(Student student);
	
}
