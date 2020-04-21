package com.springboot.bean;
 
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
 
/**
 * 用户表信息实体类
 */

@Entity
@Table(name = "user") //指定关联的数据库表名
public class User extends BaseBean {
 
	private String name;   //用户姓名
	private String yname;  //用户注册的用户名，即账号
	private String password;  //用户密码
	private String phone;    //用户电话号码
	
	public User() {
		
	}

	public User(String name, String yname, String password, String phone) {
		super();
		this.name = name;
		this.yname = yname;
		this.password = password;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}

	public String getYname() {
		return yname;
	}

	public void setYname(String yname) {
		this.yname = yname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", yname=" + yname + ", password=" + password + ", phone=" + phone + "]";
	}

	
 

}