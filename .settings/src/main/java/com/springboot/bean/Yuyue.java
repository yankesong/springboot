package com.springboot.bean;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.alibaba.fastjson.annotation.JSONField;
 
/**
 * 预约表单
 * 
 */
@Entity
@Table(name = "yuyue") //指定关联的数据库表名
public class Yuyue extends BaseBean {
	
	private String name;
	private String phone;
	private String cexin;
	@JSONField(format="yyyy-MM-dd")
	private Date date;
	
	public Yuyue() {
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
