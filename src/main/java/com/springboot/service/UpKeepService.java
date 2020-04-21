package com.springboot.service;
 
import java.util.List;

import org.springframework.data.domain.Page;

import com.springboot.bean.UpKeep;


/**
 * 保养表 有关方法接口
 * 
 */
 
public interface UpKeepService {
 
	
	
	/**
	 * 获取所有保养用户   查
	 * @return   
	 */
	List<UpKeep> getUpKeepList();
	
	UpKeep save(UpKeep upkeep);/*增加*/
	UpKeep update(UpKeep upkeep);/*修改*/
	void deleteById(Long id);/*删除*/
	UpKeep findUpKeepById(Integer id);/*根据id查询*/
	List<UpKeep> findUpKeepByName(String name);/*根据名字查询*/
	Page<UpKeep> findAll(int page,int pageSize);/*分页查询*/

	


	
    
   
   
  
     
    
	
	
}