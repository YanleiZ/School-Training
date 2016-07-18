package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.Item;
import com.sdcj.util.JDBCUtil;

public class ItemDAO {
	public List<Item> findAll() throws Exception {
		List<Item> itemList = new ArrayList<Item>();
		String sql = "select * from items order by item_date desc";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			Item item = new Item();
			item.setItemId(rs.getInt("ITEM_ID"));
			item.setItemImg(rs.getString("ITME_IMG"));
			item.setItemInvest(rs.getInt("ITEM_INVEST"));
			item.setItemMessage(rs.getString("ITEM_MESSAGE"));
			item.setItemTitle(rs.getString("ITEM_TITLE"));
			item.setItemUnit(rs.getString("ITEM_UNIT"));
			item.setItemDate(rs.getTimestamp("ITEM_DATE"));

			IndustryDAO industryDAO = new IndustryDAO();
			item.setIndustry(industryDAO.findById(rs.getInt("ITME_INDUSTRY")));
			StageDAO stageDAO = new StageDAO();
			item.setStage(stageDAO.findById(rs.getInt("ITEM_STAGE")));
			ItemTypeDAO itemTypeDAO = new ItemTypeDAO();
			item.setTypeList(itemTypeDAO.findById(rs.getString("ITEM_TYPE")));
			itemList.add(item);
		}
		return itemList;

	}
}
