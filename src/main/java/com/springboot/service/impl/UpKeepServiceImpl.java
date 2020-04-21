package com.springboot.service.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.bean.UpKeep;
import com.springboot.dao.UpKeepDao;
import com.springboot.service.UpKeepService;

 
/**
 * 
 * 保养表 有关方法实现类
 * 
 */
@Service
public class UpKeepServiceImpl implements UpKeepService {
 
	@Autowired
	private UpKeepDao upkeepDao;
	
	@Override
	public List<UpKeep> getUpKeepList() {
		
		return upkeepDao.findAll(); //从数据库中获取所有用户信息
	}

	@Override
	public UpKeep save(UpKeep upkeep) {
		
		return upkeepDao.save(upkeep);
	}

	@Override
	public UpKeep update(UpKeep user) {
		return upkeepDao.save(user);
	}

	@Override
	public UpKeep findUpKeepById(Integer id) {
		
		return upkeepDao.findUpKeepById(id);
	}

	@Override
	public List<UpKeep> findUpKeepByName(String name) {
		
		return upkeepDao.findUpKeepByName(name);
	}


	/**
     * 分页查询所有
     * @param page 当前页，表示当前要查第几页
     * @param pageSize 每页记录数，表示一页要查几条数据
     * @return
     */
	@Override
	public Page<UpKeep> findAll(int page, int pageSize) {
		
		Pageable pageable=PageRequest.of(page,pageSize);
        return upkeepDao.findAll(pageable);

	}

	@Override
	public void deleteById(Long id) {
		
		upkeepDao.deleteById(id);
	}

	



	
 
}