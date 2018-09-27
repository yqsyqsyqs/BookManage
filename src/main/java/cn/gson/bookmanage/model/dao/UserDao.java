package cn.gson.bookmanage.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.gson.bookmanage.model.entity.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	//通过用户名或者学号找用户密码
	@Query("select u.password  from User u where u.userName=?1 or u.userNumber=?1")
	String findpasswordByUserNameOrUserNumber(String userName);
	
	//通过用户名或者学号找用户
	@Query("from User u where u.userName=?1 or u.userNumber=?1")
	User findUserByUserNameOrUserNumber(String userName);
	
	User findUserByUserName(String userName);
}
