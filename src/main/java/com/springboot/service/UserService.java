package com.springboot.service;
 
import java.util.List;

import org.springframework.data.domain.Page;

import com.springboot.bean.User;

/**
 * 用户表 用户方法接口
 * 
 */
 
public interface UserService {
 
	
	
	/**
	 * 获取所有用户对象   查
	 * @return   
	 */
	List<User> getUserList();
	
	
     
	User save(User user);/*增加*/
	User update(User user);/*修改*/
	void deleteById(Long id);/*删除*/
	User findUserById(Integer id);/*根据id查询*/
	List<User> findUserByName(String name);/*根据名字查询*/
	List<User> findUserByYnameAndPassword(String yname, String password);/*根据名字查询*/
	Page<User> findAll(int page,int pageSize);/*分页查询*/

	


	
    
   
   
  
     
    
	
	
}