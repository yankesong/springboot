package com.springboot.bean;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Table;



import com.alibaba.fastjson.annotation.JSONField;
 
/**
 * 购车实体类
 * 
 */


@Entity
@Table(name = "buycar") //指定关联的数据库表名
public class BuyCar extends BaseBean{
	
	private String name; //姓名
	private String phone; //电话号码
	private String cexin;  //车型
	@JSONField(format="yyyy-MM-dd")  //输出时将日期转化为JSON格式
	private Date date;     //购车日期
	private double money;    //已付金额
	
	
	public BuyCar() {
		super();
	}
	
	public BuyCar(String name, String phone, String cexin, Date date, double money) {
		super();
		this.name = name;
		this.phone = phone;
		this.cexin = cexin;
		this.date = date;
		this.money = money;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
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
