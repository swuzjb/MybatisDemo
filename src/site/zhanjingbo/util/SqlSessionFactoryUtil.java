package site.zhanjingbo.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
	private static SqlSessionFactory sqlSessionFactory;
	
	private static SqlSessionFactory getSqlSessionFactory(){
	
		if(sqlSessionFactory == null){
			InputStream is = null;
			try {
				is = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("配置文件加载失败");
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
	public static SqlSession openSession(){
		return getSqlSessionFactory().openSession();
	}
}
