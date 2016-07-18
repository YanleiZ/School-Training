package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.StageDAO;
import com.sdcj.domain.Stage;
import com.sdcj.util.JDBCUtil;

public class StageBIZ {
	public List<Stage> findAll() {
		try {
			StageDAO stageDAO = new StageDAO();
			return stageDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}
