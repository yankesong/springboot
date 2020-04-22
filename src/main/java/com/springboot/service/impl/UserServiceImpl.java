package com.springboot.service.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.bean.User;
import com.springboot.dao.UserDao;
import com.springboot.service.UserService;
 
/**
 * 
 * 用户方法实现类
 * 
 */
@Service
public class UserServiceImpl implements UserService {
 
	@Autowired
	private UserDao userDao;
	
	@Override
	public User save(User user) {
	
		return userDao.save(user);  //保存到数据库中
		
	}

	@Override
	public List<User> getUserList() {
		
		return userDao.findAll(); //从数据库中获取所有用户信息
	}

	/**
	 * 更新
	 */
	@Override
	public User update(User user) {
		
		return userDao.save(user);
	}

	
	

	@Override
	public User findUserById(Integer id) {    //通过id查找用户
		
		return userDao.findUserById(id);
	}

	@Override
	public List<User> findUserByName(String name) {  //通过姓名查找用户
		 return userDao.findUserByName(name);
	}

	/**
     * 分页查询所有
     * @param page 当前页，表示当前要查第几页
     * @param pageSize 每页记录数，表示一页要查几条数据
     * @return
     */
	@Override
	public Page<User> findAll(int page, int pageSize) {
		
		Pageable pageable=PageRequest.of(page,pageSize);
        return userDao.findAll(pageable);

	}

	@Override
	public void deleteById(Long id) {
		
		userDao.deleteById(id);
		
	}



	@Override
	public List<User> findUserByYnameAndPassword(String yname, String password) {  //通过姓名查找用户
		return userDao.findUserByYnameAndPassword(yname, password);
	}

	
 
}