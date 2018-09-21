package com.internetsaying.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.internetsaying.common.base.dto.CutImgDTO;
import com.internetsaying.common.base.dto.UploadDTO;
import com.internetsaying.common.enums.UploadPathEnum;

public class UploadFileUtils {
	
	/**
	 * 
	 * @param request
	 * @param session
	 * @param file
	 * @param uploadType	什么类型的上传：比如用户头像
	 * @throws IOException
	 */
	public static UploadDTO upload(HttpServletRequest request,HttpSession session,
			MultipartFile file, String uploadType, Logger log) throws IOException {
		String basePath = UploadPathEnum.getValueByCode(uploadType);
		String fileName = file.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = new Date().getTime() + fileType;
		String fileSize = FileUtils.byteCountToDisplaySize(file.getSize());
		String path = request.getServletContext().getRealPath("/" + basePath);
		File targetFile = new File(path + newFileName);
		FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);
		String imgPath = targetFile.getPath();
		String saveToDBUrl = basePath + newFileName;
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +
				"/" + saveToDBUrl;
		
		log.info("*****************图片上传********************");
		log.info("来源：" + uploadType);
		log.info("文件名：" + fileName);
		log.info("新文件名：" + newFileName);
		log.info("文件大小：" + fileSize);
		log.info("保存路径：" + imgPath);
		log.info("访问URL:" + url);
		log.info("保存到数据库URL:" + saveToDBUrl);
		log.info("*******************************************");
		
		UploadDTO dto = new UploadDTO(fileName, newFileName, fileSize, url, saveToDBUrl);
		return dto;
	}
	
	/**
	 * 
	 * @param request
	 * @param session
	 * @param cutImgDTO
	 * @param from	来源目录
	 * @param to	目标目录
	 * @param log
	 */
	public static UploadDTO cut(HttpServletRequest request,HttpSession session,CutImgDTO cutImgDTO,
			String from, String to, Logger log) {
		String imgName = (String) session.getAttribute("imgName");
		String oldPath = request.getServletContext().getRealPath("/" + UploadPathEnum.getValueByCode(from)) + imgName;
		String newPath = request.getServletContext().getRealPath("/" + UploadPathEnum.getValueByCode(to)) + imgName;
		System.out.println("剪切源目录：" + oldPath);
		System.out.println("剪切目标目录：" + newPath);
		
		int[] args = new int[4];
		args = CutImage.getXYWH(oldPath, Integer.parseInt(cutImgDTO.getX()), 
				Integer.parseInt(cutImgDTO.getY()), Integer.parseInt(cutImgDTO.getW()), Integer.parseInt(cutImgDTO.getH()),
						Integer.parseInt(cutImgDTO.getDw()), Integer.parseInt(cutImgDTO.getDh()));
		CutImage.cutImage(oldPath, newPath, args[0], args[1], args[2], args[3]);
		String saveToDBURL = UploadPathEnum.getValueByCode(to) + imgName;
		String newUrl = request.getScheme()+"://"+request.getServerName()+ ":" + request.getServerPort() +
				request.getContextPath()+"/"+saveToDBURL;
		System.out.println("浏览器访问新路径：" + newUrl);
		
		UploadDTO dto = new UploadDTO(null, null, null, newUrl, saveToDBURL);
		return dto;
	}
}
