package site.zhanjingbo.test;

import org.apache.ibatis.session.SqlSession;

import site.zhanjingbo.mapper.UserMapper;
import site.zhanjingbo.model.User;
import site.zhanjingbo.util.SqlSessionFactoryUtil;

public class MyBatisTest {
	public static void main(String[] args) {
		//获取SqlSession实例
		SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
		//根据sqlSession生成对应的Mapper对象
		UserMapper userDao = sqlSession.getMapper(UserMapper.class);
		
		User user = new User("test", "123");
		int flag = userDao.addUser(user);
		
		if(flag > 0){
			System.out.println("添加成功");
		}
		
		//提交事务
		sqlSession.commit();
		//关闭SQLSession
		sqlSession.close();
		
	}
}
