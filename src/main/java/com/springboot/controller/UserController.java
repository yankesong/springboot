package com.springboot.controller;
 
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.springboot.bean.ResponseBean;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.User;
import com.springboot.service.UserService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
  * 用户列表控制类，用来控制数据库，网页，服务端的工作
  * 
  */
@RestController
public class UserController {
 
	@Autowired
	private UserService userService;




     /**
      * 保存 将用户保存到数据库
      * @param user
      * @return
      */
	
	@RequestMapping("/userSave")
	//@ResponseBody
	public ResponseBean userSave(User user, HttpServletRequest request, HttpServletResponse response) {
		user.setPhone(request.getParameter("phone"));
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
        user.setYname(request.getParameter("yname"));
		User res  = userService.save(user); //将用户保存到数据库中
		return new ResponseBean<>(res);
	}
	
	/**
	 * 查找所有用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/userList")
	public ResponseBean userList(Model model, HttpServletRequest request, HttpServletResponse response) {
	    List<User> userList = userService.getUserList();
        HashMap<String, List<User>> res = new HashMap<>();
        res.put("rows", userList);
        return new ResponseBean<>(res);
	}
	
	 /**
     * 修改一条学生信息
     * @return
     */
    @RequestMapping("/userUpdate")
    @ResponseBody
    public ResponseBean userUpdate(User user, HttpServletRequest request, HttpServletResponse response)
    {
        user.setId(Long.parseLong(request.getParameter("id")));
        user.setPhone(request.getParameter("phone"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setYname(request.getParameter("yname"));
        User res = userService.update(user);
        
    	return new ResponseBean<>(res);
    	
    }
    
    /**
     * 根据id删除
     * @return
     */
    @RequestMapping("/userDelete")
    public 	ResponseBean userDelete(User user, HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.parseLong(request.getParameter("id"));
        userService.deleteById(id);
		return new ResponseBean<>(id);
    }


    /**
     * 根据id查询一条学生信息
     * @param id 要查询的学生id
     * @return
     */
    @RequestMapping("/userFindbyid/{id}")
    public User userFindbyid(@PathVariable Integer id)
    {
    	id=16;
    	userService.findUserById(id);
        return userService.findUserById(id);
    }
    
    /**
     * 根据名字查询一条学生信息
     * @param name 要查询的学生名字
     * @return
     */
    @RequestMapping("/userFindbyname")
    public List<User> userFindByName(String name)
    {
    	name="db";
    	
    	System.out.println(userService.findUserByName(name));
        return userService.findUserByName(name);
    }
    
    /**
     * 分页查询
     * @param page
     * @param response
     * @return
     */
    @RequestMapping("/userFindByPage")
    public Page<User> userFindByPage(Integer page, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        if(page==null||page<=0)
        {
            page=0;
        }else {
            page-=1;
        }
            return userService.findAll(page,5);
    }






	

}