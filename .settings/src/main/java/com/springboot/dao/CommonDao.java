package com.springboot.dao;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.springboot.bean.BaseBean;
 
/**
 * 公共接口类  处理对数据库的请求
 * 
 */
@Repository
public interface CommonDao<T extends BaseBean> extends JpaRepository<T, Long> {
 
}