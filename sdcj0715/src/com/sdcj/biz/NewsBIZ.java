package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.NewsDAO;
import com.sdcj.domain.News;
import com.sdcj.util.JDBCUtil;

public class NewsBIZ {
	public List<News> findAll() {
		try {
			NewsDAO newsDAO = new NewsDAO();
			return newsDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}
