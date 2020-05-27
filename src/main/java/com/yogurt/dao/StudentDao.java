package com.yogurt.dao;

import com.yogurt.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentDao {

	private SqlSessionFactory sqlSessionFactory;

	public StudentDao(String configPath) throws IOException {
		InputStream inputStream = Resources.getResourceAsStream(configPath);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public List<Student> findAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> studentList = sqlSession.selectList("findAll");
		sqlSession.close();
		return studentList;
	}

	public int addStudent(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int rowsAffected = sqlSession.insert("insert", student);
		sqlSession.commit();
		sqlSession.close();
		return rowsAffected;
	}

	public int deleteStudent(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int rowsAffected = sqlSession.delete("delete",id);
		sqlSession.commit();
		sqlSession.close();
		return rowsAffected;
	}

	public List<Student> findByName(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> students = sqlSession.selectList("findByName", name);
		return students;
	}
}
