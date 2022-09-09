package com.nagarro.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.comparator.PriceComparator;
import com.nagarro.comparator.RatingComparator;
import com.nagarro.dao.TshirtDao;
import com.nagarro.dao.UserDao;
import com.nagarro.model.Tshirt;
import com.nagarro.watcher.Watcher;

@Controller
public class LoginController {
	@Autowired
	UserDao userDao;
	@Autowired
	TshirtDao tshirtDao;
	@RequestMapping("/LoginCheck")
	public ModelAndView checkUser(HttpServletRequest request,HttpServletResponse response)throws InterruptedException{
		ModelAndView mv=new ModelAndView();
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Watcher watcher = new Watcher();
		watcher.watcherThread.start();
		Thread.sleep(200);
		 
		if(userDao.isValid(username, password)){
			mv.setViewName("home.jsp");
		}
		
		else {
			mv.setViewName("login.jsp");
		}
		return mv;
	}

	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		String colour=request.getParameter("colour");
		String size=request.getParameter("size");
		String gender=request.getParameter("gender_recommendation");
		String sortingType=request.getParameter("sortingType");
		
		List<Tshirt> tshirts=tshirtDao.getSessionWithoutTransaction(colour, size, gender);
		if(sortingType.equals("price")) {
			Collections.sort(tshirts,new PriceComparator());
		}
		else if(sortingType.equals("rating")) {
			Collections.sort(tshirts,new RatingComparator());
		}
		
		mv.setViewName("display.jsp");
		mv.addObject("tshirts",tshirts);
		return mv;
		
		
		
		
	}
	
	

}
