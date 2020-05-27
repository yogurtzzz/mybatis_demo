package com.test;
import com.github.pagehelper.PageHelper;
import mybatis.generator.dao.ProductMapper;
import mybatis.generator.dao.StudentMapper;
import mybatis.generator.model.Product;
import mybatis.generator.model.ProductExample;
import mybatis.generator.model.Student;
import mybatis.generator.model.StudentExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GeneratorTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws IOException {
		InputStream resourceAsStream = Resources.getResourceAsStream("mysql8-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
	}

	@Test
	public void test() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		PageHelper.startPage(1,3);
		List<Product> products = mapper.selectByExample(new ProductExample());
		products.forEach(System.out::println);
	}
}
