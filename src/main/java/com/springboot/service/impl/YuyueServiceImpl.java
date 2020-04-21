package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.bean.Yuyue;
import com.springboot.dao.YuyueDao;
import com.springboot.service.YuyueService;

/**
 * 预约表  方法实现类
 * @author Administrator
 *
 */
@Service
public class YuyueServiceImpl implements YuyueService {
	
	@Autowired
	private YuyueDao yuyueDao;

	@Override
	public Yuyue save(Yuyue yuyue) {
		
		return yuyueDao.save(yuyue);
	}




	@Override
	public List<Yuyue> getYuYueList() {
	
		return yuyueDao.findAll(); //从数据库中获取所有预约表信息
	}


	@Override
	public Yuyue update(Yuyue user) {
		return yuyueDao.save(user);
	}

	@Override
	public Yuyue findYuyueById(Integer id) {
		
		return yuyueDao.findYuyueById(id);
	}

	@Override
	public List<Yuyue> findYuyueByName(String name) {
		
		return yuyueDao.findYuyueByName(name);
	}


	/**
     * 分页查询所有
     * @param page 当前页，表示当前要查第几页
     * @param pageSize 每页记录数，表示一页要查几条数据
     * @return
     */
	@Override
	public Page<Yuyue> findAll(int page, int pageSize) {
		
		Pageable pageable=PageRequest.of(page,pageSize);
        return yuyueDao.findAll(pageable);

	}


	@Override
	public void deleteById(Long id) {
		
		yuyueDao.deleteById(id);
	}

	





}
