package com.yogurt.mapper;

import com.yogurt.po.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PureStudentMapper {

	@Select("SELECT * FROM student")
	List<Student> findAll();

	@Insert("INSERT INTO student (name,age,score,gender) VALUES (#{name},#{age},#{score},#{gender})")
	int insert(Student student);
}
