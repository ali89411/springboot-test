package com.ccitsoft.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface BaseMapper<T> {

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
	int insert(T record);

	/**
	 * <p>Discription:[根据主键查询]</p>
	 * Created on 2018年6月12日
	 * @param id
	 * @return
	 * @author:[李超]
	 */
	T selectById(Long id);

	/**
	 * <p>Discription:[更新]</p>
	 * Created on 2018年6月12日
	 * @param record
	 * @return
	 * @author:[李超]
	 */
	int update(T record);
	
	/**
	 * <p>Discription:[分页查询]</p>
	 * Created on 2018年6月12日
	 * @return
	 * @author:[李超]
	 */
	List<T> queryList(@Param("entity") T entity, @Param("pageSize") int pageSize,
            @Param("offset") int offset);

	/**
	 * <p>Discription:[方法功能中文描述]</p>
	 * Created on 2018年6月12日
	 * @param student
	 * @return 
	 * @author:[李超]
	 */
	Long queryCount(@Param("entity") T entity);
	
}
