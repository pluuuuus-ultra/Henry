package com.gyf.bookstore.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.gyf.bookstore.domain.Sell;
import com.gyf.bookstore.domain.User;
import com.gyf.bookstore.service.SellService;

@WebServlet("/createSell")
public class CreateSellServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("sellAddress"));
		System.out.println(request.getParameter("sellName"));
		System.out.println(request.getParameter("sellPhone"));
		Sell sell = new Sell();
		
		//获取当前登录用户的信息
		User user = (User) request.getSession().getAttribute("user");
		
		try {
			//1.把请求通过封闭到Order中
			BeanUtils.populate(sell, request.getParameterMap());
			
			//2.设置用户
			sell.setUser(user);
			
			//3.设置ID
			sell.setId(UUID.randomUUID().toString());
			sell.setSellAddress(request.getParameter("sellAddress"));
			sell.setSellBook(request.getParameter("sellBook"));
			sell.setSellName(request.getParameter("sellName"));
			sell.setSellPhone(request.getParameter("sellPhone"));
			
			//4.订单保存
			SellService ss = new SellService();
			ss.addSell(sell);
			request.getRequestDispatcher("/sellsuccess.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
