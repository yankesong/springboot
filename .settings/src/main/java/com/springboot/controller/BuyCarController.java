package com.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.BuyCar;

import com.springboot.service.BuyCarService;

 /**
  * 购车列表控制类，控制数据库，网页，服务端的工作
  * 
  */
@RestController
public class BuyCarController {
	
	@Autowired
	private BuyCarService buyCarService;  
	
     /**
      * 保存 将用户保存到数据库
      * @param buyCar
      * @return
      */
	
	@RequestMapping("/buyCarSave")
	//@ResponseBody
	public BuyCar buyCarSave(BuyCar buyCar) {  
		
		
		return buyCarService.save(buyCar);
	}
	
	/**
	 * 查找所有用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/buyCarList")
	public List<BuyCar> buyCarList(Model model) {
	    
		List<BuyCar> buyCarList = buyCarService.getBuyCarList();
	
	    return buyCarList;
	}
	
	 /**
     * 修改一条学生信息
     * @param student  要修改的学生对象
     * @return
     */
    @RequestMapping("/buyCarUpdate")
    public BuyCar buyCarUpdate(BuyCar buyCar)
    {
    	
    	
       
    	return buyCarService.update(buyCar);
    	
    }


    /**
     * 根据id查询一条学生信息
     * @param id 要查询的学生id
     * @return
     */
    @RequestMapping("/buyCarFindByid/{id}")
    public BuyCar buyCarFindByid(@PathVariable Integer id)
    {
    	
    	
        return buyCarService.findBuyCarById(id);
    }
    
    /**
     * 根据名字查询一条学生信息
     * @param name 要查询的学生名字
     * @return
     */
    @RequestMapping("/buyCarFindbyname")
    public List<BuyCar> buyCarFindbyname(String name)
    {
    	
    	
    	
        return buyCarService.findBuyCarByName(name);
    }
    /**
     * 根据id删除
     * @param upkeep
     * @return
     */
    @RequestMapping("/buyCarDelete")
    public 	BuyCar buyCarDelete(BuyCar buyCar)
    {
    	
    	buyCarService.deleteById(buyCar.getId());
		return buyCar;
    	
    }
    
    /**
     * 分页查询
     * @param page
     * @param response
     * @return
     */
    @RequestMapping("/buyCarFindByPage")
    public Page<BuyCar> buyCarFindByPage(Integer page, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        if(page==null||page<=0)
        {
            page=0;
        }else {
            page-=1;
        }
            return buyCarService.findAll(page,5);
    }


}
