package com.test;

import com.yogurt.mapper.ClassMapper;
import com.yogurt.mapper.StudentMapper;
import com.yogurt.po.Clazz;
import com.yogurt.po.Student;
import com.yogurt.po.StudentExt;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MapperProxyTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
	}

	@Test
	public void test() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Student student = new Student(-1, "Podman", 130, 15, 0);
		mapper.insert(student);
		sqlSession.commit();
		System.out.println(student.getId());
//		List<Student> studentList = mapper.findAll();
//		studentList.forEach(System.out::println);
	}

	@Test
	public void testBatchQuery() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> students = mapper.batchFind(Arrays.asList(1, 2, 3, 7, 9));
		students.forEach(System.out::println);
	}

	@Test
	public void testIf() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Student student = new Student();
		student.setAge(20);
		student.setName("");
		List<Student> students = mapper.find(student);
		students.forEach(System.out::println);
	}

	@Test
	public void testCacheLevel1() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> students = mapper.findByName("yogurt");
		students.forEach(System.out::println);
		Student student = new Student();
		student.setName("what");
		mapper.insert(student);
		List<Student> all = mapper.findByName("yogurt");
		all.forEach(System.out::println);
	}

	@Test
	public void testClass() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
		Clazz clazz = new Clazz();
		clazz.setName("Normal Class");
		clazz.setLevel(-1);
		mapper.insert(clazz);
		sqlSession.commit();
		Integer id = clazz.getId();
		System.out.println(id);
	}

	@Test
	public void testLazyLoad() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<StudentExt> list = mapper.findLazy("o");
		for(StudentExt item : list) {
			System.out.println(item.getName());
			System.out.println(item.getScore());
		}
//		Clazz clazz = list.get(0).getClazz();
//		System.out.println(clazz);
		System.out.println("yes");
	}
}
