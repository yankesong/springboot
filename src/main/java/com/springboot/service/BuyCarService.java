package com.springboot.service;
 
import java.util.List;

import org.springframework.data.domain.Page;

import com.springboot.bean.BuyCar;

/**
 * 购车表  有关方法接口
 * 
 */
 
public interface BuyCarService {
 
	
	
	/**
	 * 获取所有用户对象   查
	 * @return   
	 */
	List<BuyCar> getBuyCarList();
	
	
     
	BuyCar save(BuyCar buyCar);/*增加*/
	BuyCar update(BuyCar buyCar);/*修改*/
	
	BuyCar findBuyCarById(Integer id);/*根据id查询*/
	List<BuyCar> findBuyCarByName(String name);/*根据名字查询*/
	Page<BuyCar> findAll(int page,int pageSize);/*分页查询*/
	void deleteById(Long id);
	


	
    
   
   
  
     
    
	
	
}