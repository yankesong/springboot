package com.springboot.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.bean.User;
import com.springboot.bean.Yuyue;
 
/**
 * 预约公共接口类，用连接预约数据表
 */
@Repository
public interface YuyueDao extends CommonDao<Yuyue> {

	Yuyue findYuyueById(Integer id);
	 
    /**
     * 自定义查询方法
     * @param name 要查询的名字
     * @return
     */
    @Query(name="findYuyueByName",nativeQuery = true,value = "select * from yuyue where name=:name")
    List<Yuyue> findYuyueByName(@Param("name") String name);
}
