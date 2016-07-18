package com.sdcj.domain;

import java.sql.Timestamp;

public class Info {
	private int infoId;
	private String infoTitle;
	private Timestamp infoTime;
	private String infoContext;
	private String infoImg;

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public Timestamp getInfoTime() {
		return infoTime;
	}

	public void setInfoTime(Timestamp infoTime) {
		this.infoTime = infoTime;
	}

	public String getInfoContext() {
		return infoContext;
	}

	public void setInfoContext(String infoContext) {
		this.infoContext = infoContext;
	}

	public String getInfoImg() {
		return infoImg;
	}

	public void setInfoImg(String infoImag) {
		this.infoImg = infoImag;
	}

}
