package com.springboot.controller;
 
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.UpKeep;
import com.springboot.bean.User;
import com.springboot.service.UserService;
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
	public User userSave(User user) {  
		user.setPhone("18966547863");
		user.setName("小红");
		user.setPassword("ss4568");
        user.setYname("1445689");
		userService.save(user); //将用户保存到数据库中
		
		return userService.save(user);
	}
	
	/**
	 * 查找所有用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/userList")
	public List<User> userList(Model model) {
	    List<User> userList = userService.getUserList();
	
	    return userList;
	}
	
	 /**
     * 修改一条学生信息
     * @param student  要修改的学生对象
     * @return
     */
    @RequestMapping("/userUpdate")
    @ResponseBody
    public User userUpdate(User user)
    {
    	
    	user.setPhone("18656932566");
		user.setName("小芳");
		user.setPassword("sssc52.");
        user.setYname("4511525689");
        
    	return userService.update(user);
    	
    }
    
    /**
     * 根据id删除
     * @param upkeep
     * @return
     */
    @RequestMapping("/userDelete")
    public 	User userDelete(User user)
    {
    	
    	userService.deleteById(user.getId());
		return user;
    	
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