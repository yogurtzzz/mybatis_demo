package com.yogurt.mapper;

import com.yogurt.po.Student;
import com.yogurt.po.StudentExt;

import java.util.List;

public interface StudentMapper {

	List<Student> findAll();

	int insert(Student student);

	int delete(Integer id);

	List<Student> findByName(String value);

	List<Student> batchFind(List<Integer> list);

	List<Student> find(Student student);

	List<StudentExt> findLazy(String name);
}
