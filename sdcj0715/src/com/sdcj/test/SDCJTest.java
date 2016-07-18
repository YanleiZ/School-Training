package com.sdcj.test;

import java.util.List;

import org.junit.Test;

import com.sdcj.biz.InfoBIZ;
import com.sdcj.domain.Info;
import com.sdcj.util.MD5_Encoding;

public class SDCJTest {
	@Test
	public void infoFindAllTest() {
		InfoBIZ infoBIZ = new InfoBIZ();
		List<Info> infoList = infoBIZ.findAll();
		for (Info info : infoList) {
			System.out.println(info.getInfoId() + "：" + info.getInfoTitle());
		}
		MD5_Encoding md5 = new MD5_Encoding();
		System.out.println(md5.getMD5ofStr("123456"));
	}
}
