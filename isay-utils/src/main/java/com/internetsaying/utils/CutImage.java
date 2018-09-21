package com.internetsaying.utils;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class CutImage {

	public static int[] getXYWH(String imgsrc, int x, int y, int w, int h, int dw, int dh){
		int[] args = new int[4];
		try {
			BufferedImage img = ImageIO.read(new File(imgsrc));
			int width = img.getWidth();
			int height = img.getHeight();
			
			float rx = (float)width / dw;
			float ry = (float)height / dh;
			rx = (float)Math.round(rx*100)/100;
			ry = (float)Math.round(ry*100)/100;
			
			System.out.println("原图宽度：" + width);
			System.out.println("原图高度：" + height);
			System.out.println("宽度放大：" + rx);
			System.out.println("高度放大：" + ry);
			
			x = (int) (x * rx);
			y = (int) (y * ry);
			w = (int) (w * rx);
			h = (int) (h * rx);
			
			args[0] = x;
			args[1] = y;
			args[2] = w;
			args[3] = h;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return args;
	}
	
	public static boolean cutImage(String imgsrc, String imgtar, int x, int y, int w, int h){
		FileInputStream fileIn = null;
		ImageInputStream imageIn = null;
		boolean res = false;
		try {
			fileIn = new FileInputStream(new File(imgsrc));
			String imgType = imgsrc.substring(imgsrc.lastIndexOf(".") + 1);//图片类型
			Iterator<ImageReader> itor = ImageIO.getImageReadersByFormatName(imgType);
			ImageReader imageReader = itor.next();
			
			imageIn = ImageIO.createImageInputStream(fileIn);//获取图片流
			
			imageReader.setInput(imageIn, true);
			
			ImageReadParam iParam = imageReader.getDefaultReadParam();
			
			Rectangle rect = new Rectangle(x, y, w, h);
			
			iParam.setSourceRegion(rect);
			
			BufferedImage bImage = imageReader.read(0, iParam);
			
			res = ImageIO.write(bImage, imgType, new File(imgtar));
			
			
		} catch (FileNotFoundException e) {
			System.out.println("文件读取错误");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("图片流获取失败");
			e.printStackTrace();
		}
		return res;
	}
}
