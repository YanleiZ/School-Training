package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.Info;
import com.sdcj.util.JDBCUtil;

public class InfoDAO {
	public List<Info> findAll() throws Exception {
		List<Info> infoList = new ArrayList<Info>();
		String sql = "select *from informations order by INFO_TIME desc";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			Info info = new Info();
			info.setInfoId(rs.getInt("INFO_ID"));
			info.setInfoTitle(rs.getString("INFO_TITLE"));
			info.setInfoContext(rs.getString("INFO_CONTEXT"));
			info.setInfoImg(rs.getString("INFO_IMG"));
			info.setInfoTime(rs.getTimestamp("INFO_TIME"));
			infoList.add(info);
		}
		return infoList;
	}
}
