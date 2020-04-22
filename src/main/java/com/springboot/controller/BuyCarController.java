package com.springboot.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.springboot.bean.ResponseBean;
import com.springboot.bean.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.BuyCar;
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
	public ResponseBean buyCarSave(BuyCar buyCar, HttpServletRequest request, HttpServletResponse response) {
		buyCar.setPhone(request.getParameter("phone"));
		buyCar.setName(request.getParameter("name"));
		buyCar.setCexin(request.getParameter("cexin"));
        try {
            buyCar.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("time")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        buyCar.setMoney(Double.parseDouble(request.getParameter("money")));
        BuyCar res =  buyCarService.save(buyCar); //将用户保存到数据库中
        return new ResponseBean<>(res);
	}
	
	/**
	 * 查找所有用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/buyCarList")
	public ResponseBean buyCarList(Model model, HttpServletRequest request, HttpServletResponse response) {
	    List<BuyCar> buyCarList = buyCarService.getBuyCarList();
        HashMap<String, List<BuyCar>> res = new HashMap<>();
        res.put("rows", buyCarList);
        return new ResponseBean<>(res);
	}
	
	 /**
     * 修改一条学生信息
     * @return
     */
    @RequestMapping("/buyCarUpdate")
    public ResponseBean buyCarUpdate(BuyCar buyCar, HttpServletRequest request, HttpServletResponse response)
    {
        buyCar.setId(Long.parseLong(request.getParameter("id")));
        buyCar.setPhone(request.getParameter("phone"));
        buyCar.setName(request.getParameter("name"));
        buyCar.setCexin(request.getParameter("cexin"));
        try {
            buyCar.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("time")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        buyCar.setMoney(Double.parseDouble(request.getParameter("money")));
        BuyCar res = buyCarService.update(buyCar);
        return new ResponseBean<>(res);
    	
    }


    /**
     * 根据id查询一条学生信息
     * @param id 要查询的学生id
     * @return
     */
    @RequestMapping("/buyCarFindByid/{id}")
    public BuyCar buyCarFindByid(@PathVariable Integer id)
    {
    	id=16;
    	buyCarService.findBuyCarById(id);
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
    	name="db";
    	
    	System.out.println(buyCarService.findBuyCarByName(name));
        return buyCarService.findBuyCarByName(name);
    }
    /**
     * 根据id删除
     * @return
     */
    @RequestMapping("/buyCarDelete")
    public 	ResponseBean buyCarDelete(BuyCar buyCar, HttpServletRequest request, HttpServletResponse response)
    {

        Long id = Long.parseLong(request.getParameter("id"));
        buyCarService.deleteById(id);
        return new ResponseBean<>(id);
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
