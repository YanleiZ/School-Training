package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sdcj.domain.Stage;
import com.sdcj.util.JDBCUtil;

public class StageDAO {
 public Stage findById (int id) throws Exception{
	 String sql = "select * from stage where stage_id=?";
	 Connection conn = JDBCUtil.getConnection();
	 PreparedStatement pstat = conn.prepareStatement(sql);
	 pstat.setInt(1, id);
	 ResultSet rs = pstat.executeQuery();
	 if (rs.next()) {
		Stage stage = new Stage();
		stage.setStageId(rs.getInt("STAGE_ID"));
		stage.setStageTitle(rs.getString("STAGE_TITLE"));
		return stage;
	}else{
		return null;
	}
 }
}
