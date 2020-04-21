package com.springboot.bean;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Table;



import com.alibaba.fastjson.annotation.JSONField;
 
/**
 * 保养表单实体类
 * 
 */


@Entity
@Table(name = "upkeep") //指定关联的数据库表名
public class UpKeep extends BaseBean{
	
	private String name;    //姓名
	private String phone;      //电话号码
	private String cexin;   //车型
	@JSONField(format="yyyy-MM-dd")  
	private Date date;     //预定日期
	
	public UpKeep() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCexin() {
		return cexin;
	}
	public void setCexin(String cexin) {
		this.cexin = cexin;
	}
	

}
