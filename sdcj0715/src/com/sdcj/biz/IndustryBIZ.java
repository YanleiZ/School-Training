package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.IndustryDAO;
import com.sdcj.domain.Industry;
import com.sdcj.util.JDBCUtil;

public class IndustryBIZ {
	public List<Industry> findAll() {
		try {
			IndustryDAO industryDAO = new IndustryDAO();
			return industryDAO.findAll();
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}
