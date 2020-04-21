package com.springboot.dao;
 
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bean.BuyCar;
import com.springboot.bean.UpKeep;

 
/**
 * 购买公共接口类，连接买车单数据表
 */
@Repository
public interface BuyCarDao extends CommonDao<BuyCar> {


	BuyCar findBuyCarById(Integer id);
 
    /**
     * 自定义查询方法
     * @param name 要查询的名字
     * @return
     */
    @Query(name="findBuyCarByName",nativeQuery = true,value = "select * from buycar where name=:name")
    List<BuyCar> findBuyCarByName(@Param("name") String name);

  


 
}