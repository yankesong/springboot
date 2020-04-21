package com.springboot.service.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.bean.BuyCar;
import com.springboot.dao.BuyCarDao;
import com.springboot.service.BuyCarService;


 
/**
 * 
 * 购车表，有关方法实现类
 * 
 */
@Service
public class BuyCarServiceImpl implements BuyCarService {
 
	@Autowired
	private BuyCarDao buyCarDao;
	

	@Override
	public List<BuyCar> getBuyCarList() {
		
		return buyCarDao.findAll(); //从数据库中获取所有用户信息
	}

	@Override
	public BuyCar save(BuyCar buyCar) {
		
		return buyCarDao.save(buyCar);
	}

	@Override
	public BuyCar update(BuyCar buyCar) {
		return buyCarDao.save(buyCar);
	}

	@Override
	public BuyCar findBuyCarById(Integer id) {
		
		return buyCarDao.findBuyCarById(id);
	}

	@Override
	public List<BuyCar> findBuyCarByName(String name) {
		
		return buyCarDao.findBuyCarByName(name);
	}


	/**
     * 分页查询所有
     * @param page 当前页，表示当前要查第几页
     * @param pageSize 每页记录数，表示一页要查几条数据
     * @return
     */
	@Override
	public Page<BuyCar> findAll(int page, int pageSize) {
		
		Pageable pageable=PageRequest.of(page,pageSize);
        return buyCarDao.findAll(pageable);

	}

	@Override
	public void deleteById(Long id) {
		
		buyCarDao.deleteById(id);
		
	}

	



	
 
}