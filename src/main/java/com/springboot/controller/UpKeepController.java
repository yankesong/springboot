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

import com.springboot.bean.UpKeep;

import com.springboot.service.UpKeepService;

 /**
  * 保养列表控制类，用来控制数据库，网页，服务端的工作
  * 
  */
@RestController
public class UpKeepController {
	
	@Autowired
	private UpKeepService upkeepService;  
	
	
	
     /**
      * 保存 将用户保存到数据库
      * @param upkeep
      * @return
      */
	
	@RequestMapping("/upKeepSave")
	//@ResponseBody
	public UpKeep upKeepSave(UpKeep upkeep) {  
		upkeep.setPhone("4545454");
		upkeep.setName("来我");
		upkeep.setCexin("我u在保存");
		upkeep.setDate(new Date());
        upkeepService.save(upkeep); //将用户保存到数据库中
		
		return upkeepService.save(upkeep);
	}
	
	/**
	 * 查找所有用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/upKeepList")
	public List<UpKeep> upKeepList(Model model) {
	    List<UpKeep> upkeepList = upkeepService.getUpKeepList();
	
	    return upkeepList;
	}
	
	 /**
     * 修改一条学生信息
     * @param student  要修改的学生对象
     * @return
     */
    @RequestMapping("/upKeepUpdate")
    public UpKeep upKeepUpdate(UpKeep upkeep)
    {
    	upkeep.setPhone("18462325699");
		upkeep.setName("小明");
		upkeep.setCexin("大众");
        upkeep.setDate(new Date());
    	return upkeepService.update(upkeep);
    	
    }


    /**
     * 根据id查询一条学生信息
     * @param id 要查询的学生id
     * @return
     */
    @RequestMapping("/upKeepFindByid/{id}")
    public UpKeep upKeepFindByid(@PathVariable Integer id)
    {
    	id=16;
    	upkeepService.findUpKeepById(id);
        return upkeepService.findUpKeepById(id);
    }
    
    /**
     * 根据名字查询一条学生信息
     * @param name 要查询的学生名字
     * @return
     */
    @RequestMapping("/upKeepFindByName")
    public List<UpKeep> upKeepFindByName(String name)
    {
    	name="db";
    	
    	System.out.println(upkeepService.findUpKeepByName(name));
        return upkeepService.findUpKeepByName(name);
    }
    
    /**
     * 分页查询
     * @param page
     * @param response
     * @return
     */
    @RequestMapping("/upKeepFindByPage")
    public Page<UpKeep> upKeepFindByPage(Integer page, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        if(page==null||page<=0)
        {
            page=0;
        }else {
            page-=1;
        }
            return upkeepService.findAll(page,5);
    }


}
