package com.springboot.dao;
 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 
import com.springboot.bean.User;
 
/**
 * 用户公共接口类，用连接用户数据表
 */
@Repository
public interface UserDao extends CommonDao<User> {


	User findUserById(Integer id);
 
    /**
     * 自定义查询方法
     * @param name 要查询的名字
     * @return
     */
    @Query(name="findUserByName",nativeQuery = true,value = "select * from user where name=:name")
    List<User> findUserByName(@Param("name") String name);
    @Query(name="findUserByName",nativeQuery = true,value = "select * from user where yname=:yname and password=:password")
    List<User> findUserByYnameAndPassword(@Param("yname") String yname, @Param("password") String password);
}