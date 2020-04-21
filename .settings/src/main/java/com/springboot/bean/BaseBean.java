package com.springboot.bean;
 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
 
/**
 * 公共实体类
 * 用于存放公共信息
 * 
 */
@MappedSuperclass
public class BaseBean {
 
	/**
	 * 自增长ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
 
}