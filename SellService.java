package com.gyf.bookstore.service;

import java.sql.SQLException;
import java.util.List;


import com.gyf.bookstore.dao.SellDao;
import com.gyf.bookstore.domain.Sell;
import com.gyf.bookstore.utils.ManagerThreadLocal;

public class SellService {

	SellDao sellDao=new SellDao();
	
	/**
	 * @param order
	 */
	public void addSell(Sell sell){
		ManagerThreadLocal.beginTransaction();
		try {
			sellDao.saveSell(sell);
	
			ManagerThreadLocal.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			ManagerThreadLocal.rollback();
		}
	}
	
	/**
	 * @param userid
	 * @return
	 */
	public List<Sell> findsellByUserId(String userid){
		try {
			return sellDao.findSellByUserId(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param orderId
	 * @return
	 */
	public Sell findOrderByOrderId(String sellId){
		try {
			return sellDao.findSellBySellId(sellId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
