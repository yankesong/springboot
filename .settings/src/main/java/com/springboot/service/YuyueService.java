package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springboot.bean.Yuyue;


/**
 * 预约表 方法接口
 * 
 */
public interface YuyueService {

	/**
	 * 保存用户对象  增加
	 * @param yuyue
	 */
	Yuyue save(Yuyue yuyue);
	/**
	 * 获取所有用户对象   查
	 * @return   
	 */
	List<Yuyue> getYuYueList();
	
	Yuyue update(Yuyue user);/*修改*/
	void deleteById(Long id);/*删除*/
	Yuyue findYuyueById(Integer id);/*根据id查询*/
	List<Yuyue> findYuyueByName(String name);/*根据名字查询*/
	Page<Yuyue> findAll(int page,int pageSize);/*分页查询*/
	
}
