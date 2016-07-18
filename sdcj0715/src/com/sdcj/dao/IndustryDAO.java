package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sdcj.domain.Industry;
import com.sdcj.domain.Stage;
import com.sdcj.util.JDBCUtil;

public class IndustryDAO {
	public Industry findById(int id) throws Exception{
		String sql ="select * from  industry where industry_id = ?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, id);
		ResultSet rs = pstat.executeQuery();
		//当前的查询是按主键做为查询条件，所以查询结果只能是一条记录或没有。
		if(rs.next()){
			Industry industry = new Industry();
			industry.setIndustryId(rs.getInt("INDUSTRY_ID"));
			industry.setIndustryTitle(rs.getString("INDUSTRY_TITLE"));
			return industry;
		}else{
			return null;
		}
	}
}
