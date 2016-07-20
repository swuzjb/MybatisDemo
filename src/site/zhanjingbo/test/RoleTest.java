package site.zhanjingbo.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import site.zhanjingbo.mapper.RoleMapper;
import site.zhanjingbo.model.Role;
import site.zhanjingbo.util.SqlSessionFactoryUtil;

public class RoleTest {
	private SqlSession sqlSession = null;
	private RoleMapper roleMapper = null;

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		roleMapper = sqlSession.getMapper(RoleMapper.class);
	}

	@After
	public void tearDown() throws Exception {
		sqlSession.commit();
		sqlSession.close();
	}


	@Test
	public void testGetRole() {
		Role role = roleMapper.getRoleById(1);
		System.out.println(role);
		System.out.println(role.getUserList());
	}

}
