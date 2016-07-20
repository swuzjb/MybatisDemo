package site.zhanjingbo.mapper;

import java.util.List;
import java.util.Map;

import site.zhanjingbo.model.User;

public interface UserMapper {
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(Integer id);
	
	public User getUserById(Integer id);
	public List<User> getAllUser();
	
	public List<User> getUserByRole(Integer roleId);
	
	public List<User> searchUser(Map<String, Object> searchMap);
	
	
}
