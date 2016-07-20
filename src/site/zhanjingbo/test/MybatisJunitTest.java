package site.zhanjingbo.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import site.zhanjingbo.mapper.UserMapper;
import site.zhanjingbo.model.Role;
import site.zhanjingbo.model.User;
import site.zhanjingbo.util.SqlSessionFactoryUtil;

public class MybatisJunitTest {
	private SqlSession sqlSession = null;
	private UserMapper userMapper = null;

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
	}

	@After
	public void tearDown() throws Exception {
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdate() {
		User user = new User(4,"testAdmin","123456");
		userMapper.updateUser(user);
	}
	@Test
	public void testDelete(){
		userMapper.deleteUser(3);
	}
	@Test
	public void testSelect(){
		User user = userMapper.getUserById(4);
		System.out.println(user);
	}
	@Test
	public void testUserList(){
		List<User> userList = userMapper.getAllUser();
		System.out.println(userList);
		
	}
	
	@Test
	public void testSearch(){
		Role role = new Role();
		role.setId(1);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("role", role);
		
		List<User> userList = userMapper.searchUser(map);
		for(User user:userList){
			System.out.println(user);
		}
		
	}

}
