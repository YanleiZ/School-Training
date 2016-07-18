package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.ItemTypes;
import com.sdcj.util.JDBCUtil;

public class ItemTypeDAO {
	public List<ItemTypes> findById(String ids) throws Exception {
		List<ItemTypes> itemTypeList = new ArrayList<ItemTypes>();
		String sql = "select * from itemtypes where type_id in (" + ids + ")";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			ItemTypes itemTypes = new ItemTypes();
			itemTypes.setTypeId(rs.getInt("TYPE_ID"));
			itemTypes.setTypeName(rs.getString("TYPE_NAME"));
			itemTypeList.add(itemTypes);
		}
		return itemTypeList;
	}
}
