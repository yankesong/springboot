package com.springboot.dao;
 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.bean.UpKeep;

 
/**
 * 保养单公共接口类，用连接保养单数据表
 */
@Repository
public interface UpKeepDao extends CommonDao<UpKeep> {


	UpKeep findUpKeepById(Integer id);
 
    /**
     * 自定义查询方法
     * @param name 要查询的名字
     * @return
     */
    @Query(name="findUpKeepByName",nativeQuery = true,value = "select * from upkeep where name=:name")
    List<UpKeep> findUpKeepByName(@Param("name") String name);



 
}