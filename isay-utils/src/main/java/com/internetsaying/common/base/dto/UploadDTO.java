package com.internetsaying.common.base.dto;

import java.io.Serializable;

public class UploadDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5197190180400231786L;

	
	private String fileName;
	private String newFileName;
	private String fileSize;
	private String url;
	private String saveToDBUrl;
	public UploadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UploadDTO(String fileName, String newFileName, String fileSize, String url, String saveToDBUrl) {
		super();
		this.fileName = fileName;
		this.newFileName = newFileName;
		this.fileSize = fileSize;
		this.url = url;
		this.saveToDBUrl = saveToDBUrl;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSaveToDBUrl() {
		return saveToDBUrl;
	}
	public void setSaveToDBUrl(String saveToDBUrl) {
		this.saveToDBUrl = saveToDBUrl;
	}
	
	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	@Override
	public String toString() {
		return "UploadDTO [fileName=" + fileName + ", newFileName=" + newFileName + ", fileSize=" + fileSize + ", url="
				+ url + ", saveToDBUrl=" + saveToDBUrl + "]";
	}

	
}
