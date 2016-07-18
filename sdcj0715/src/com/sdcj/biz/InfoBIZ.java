package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.InfoDAO;
import com.sdcj.domain.Info;
import com.sdcj.util.JDBCUtil;

public class InfoBIZ {
	public Info findById(int id) {
		try {
			InfoDAO infoDAO = new InfoDAO();
			Info info = infoDAO.findById(id);
			return info;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
	public List<Info> findAll() {
		try {
			InfoDAO infoDAO = new InfoDAO();
			List<Info> infoList = infoDAO.findAll();
			return infoList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}
