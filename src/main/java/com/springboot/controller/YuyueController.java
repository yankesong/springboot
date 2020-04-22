package com.springboot.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.Yuyue;
import com.springboot.bean.Yuyue;


import com.springboot.service.YuyueService;
 /**
  * 预约列表控制类，用来控制数据库，网页，服务端的工作
  * 
  */
@RestController
public class YuyueController {
	
	@Autowired
	private YuyueService yuyueservice;  
	
	@RequestMapping("/list")
	public String inde1(Model model) {
		model.addAttribute("name", "55k");
		model.addAttribute("phone", 20);
		model.addAttribute("date", "一个爱学习的好青年");
		model.addAttribute("cexin", "一个爱学习的好青年");
		
		
		return "userlist.html";
	}
	

    /**
     * 保存 将用户保存到数据库
     * @param yuyue
     * @return
     */
	
	@RequestMapping("/yuyueSave")
	//@ResponseBody
	public Yuyue yuyueSave(Yuyue yuyue) {  
		yuyue.setPhone("18966547863");
		yuyue.setName("小红");
		yuyue.setDate(new Date());
        yuyue.setCexin("本田");
		yuyueservice.save(yuyue); //将用户保存到数据库中
		
		return yuyueservice.save(yuyue);
	}
	
	/**
	 * 查找所有用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/yuyueList")
	public List<Yuyue> yuyueList(Model model) {
	    List<Yuyue> yuyueList = yuyueservice.getYuYueList();

	    return yuyueList;
	}
	
	 /**
    * 修改一条预约信息
    * @param yuyue  要修改的学生对象
    * @return
    */
   @RequestMapping("/yuyueUpdate")
   public Yuyue yuyueUpdate(Yuyue yuyue)
   {
   	    yuyue.setPhone("18656932566");
		yuyue.setName("小芳");
		yuyue.setDate(new Date());
        yuyue.setCexin("长安");
   	return yuyueservice.update(yuyue);
   	
   }


   /**
    * 根据id查询一条预约信息
    * @param id 
    * @return
    */
   @RequestMapping("/yuyueFindbyid/{id}")
   public Yuyue yuyueFindbyid(@PathVariable Integer id)
   {
   		id=16;
   		yuyueservice.findYuyueById(id);
       return yuyueservice.findYuyueById(id);
   }
   
   /**
    * 根据id删除
    * @return
    */
   @RequestMapping("/yuyueDelete")
   public Yuyue yuyueDelete(Yuyue yuyue)
   {
	   yuyue.setId(1l);
   	
   		yuyueservice.deleteById(yuyue.getId());
		return yuyue;
   	
   }
   /**
    * 根据名字查询一条预约信息
    * @param name 要查询的客户名字
    * @return
    */
   @RequestMapping("/yuyueFindbyname")
   public List<Yuyue> yuyueFindbyname(String name)
   {
   	name="db";
   	
   	System.out.println(yuyueservice.findYuyueByName(name));
       return yuyueservice.findYuyueByName(name);
   }
   
   /**
    * 分页查询
    * @param page
    * @param response
    * @return
    */
   @RequestMapping("/yuyueFindByPage")
   public Page<Yuyue> yuyueFindByPage(Integer page, HttpServletResponse response)
   {
       response.setHeader("Access-Control-Allow-Origin","*");
       if(page==null||page<=0)
       {
           page=0;
       }else {
           page-=1;
       }
           return yuyueservice.findAll(page,5);
   }






}
