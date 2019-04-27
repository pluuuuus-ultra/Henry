package com.gyf.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gyf.bookstore.domain.Sell;
import com.gyf.bookstore.utils.C3P0Utils;
import com.gyf.bookstore.utils.ManagerThreadLocal;

public class SellDao {

	public void saveSell(Sell sell)throws SQLException {
		
		QueryRunner qr = new QueryRunner();
		
		String sql = "insert into sell values (?,?,?,?,?,?)";
		
		List<Object> prmts = new ArrayList<>();
		prmts.add(sell.getId());
		prmts.add(sell.getUser().getId());
		prmts.add(sell.getSellAddress());
		prmts.add(sell.getSellName());
		prmts.add(sell.getSellPhone());
		prmts.add(sell.getSellBook());
		
		qr.update(ManagerThreadLocal.getConnection(), sql,prmts.toArray());
		
	}

	/**
	 * 根据用户id查找定单
	 * @param userid
	 * @return
	 * @throws SQLException
	 */
	public List<Sell> findSellByUserId(String userid) throws SQLException {
		String sql = "select * from sell where user_id = ?";
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		return qr.query(sql, new BeanListHandler<Sell>(Sell.class),userid);
	}

	/**
	 * 根据定单ID查询定单和详情信息
	 */
	public Sell findSellBySellId(String sellId)throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		//1.查询定单表
		String sql = "select * from sell where id = ?";
		Sell sell = qr.query(sql, new BeanHandler<Sell>(Sell.class),sellId);
		
		return sell;
	}

}
