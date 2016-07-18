package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.News;
import com.sdcj.util.JDBCUtil;

public class NewsDAO {

	public List<News> findAll() throws Exception {
		List<News> newsList = new ArrayList<News>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from news order by news_time desc";
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			News news = new News();
			news.setNewsId(rs.getInt("NEWS_ID"));
			news.setNewsTitle(rs.getString("NEWS_TITLE"));
			news.setNewsContext(rs.getString("NEWS_CONTEXT"));
			news.setNewsImg(rs.getString("NEWS_IMG"));
			news.setNewsTime(rs.getTimestamp("NEWS_TIME"));
			newsList.add(news);
		}
		return newsList;

	}
}

