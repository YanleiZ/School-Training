package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.ItemDAO;
import com.sdcj.domain.Item;
import com.sdcj.util.JDBCUtil;

public class ItemBIZ {
	public List<Item> findAll() {
		try {
			return new ItemDAO().findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}
