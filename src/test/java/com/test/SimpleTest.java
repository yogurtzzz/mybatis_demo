//package com.test;
//
//import com.yogurt.dao.StudentDao;
//import com.yogurt.po.Student;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.util.List;
//
//public class SimpleTest {
//
//	private StudentDao studentDao;
//
//	@Before
//	public void init() throws IOException {
//		studentDao = new StudentDao("mybatis-config.xml");
//	}
//
//	@Test
//	public void insertTest() {
//		Student student = new Student();
//		student.setName("amber");
//		student.setAge(25);
//		student.setGender(1);
//		student.setScore(100);
//		studentDao.addStudent(student);
//	}
//
//	@Test
//	public void findAllTest() {
//		List<Student> all = studentDao.findAll();
//		all.forEach(System.out::println);
//	}
//
//	@Test
//	public void findByName() {
//		List<Student> students = studentDao.findByName("yogurt");
//		students.forEach(System.out::println);
//	}
//
//}
