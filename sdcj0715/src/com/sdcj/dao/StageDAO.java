package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.Industry;
import com.sdcj.domain.Stage;
import com.sdcj.util.JDBCUtil;

public class StageDAO {
	public List<Stage> findAll() throws Exception{
		List<Stage> stageList = new ArrayList<Stage>();
		String sql ="select * from  stage";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		//当前的查询是按主键做为查询条件，所以查询结果只能是一条记录或没有。
		while(rs.next()){
			Stage stage = new Stage();
			stage.setStageId(rs.getInt("STAGE_ID"));
			stage.setStageTitle(rs.getString("STAGE_TITLE"));
			stageList.add(stage);
		}
			return stageList;	
	}
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
