package com.cms.services;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cms.dao.ImageDao;
import com.cms.model.Image;


public class ImageUploadServices {
	
	@Value("${upload.dir}")
	private String uploadDir;
	
	@Autowired
	private ImageDao imageDao;
	
	public List<Image> fileUploads(MultipartFile[] multipartFiles){
		List<Image> images = new ArrayList<Image>();
		for (MultipartFile multipartFile : multipartFiles) {
			String fileName = getSaltString()+"."+FilenameUtils.getExtension(multipartFile.getOriginalFilename());
			System.out.println(fileName);
			try {
				FileCopyUtils.copy(multipartFile.getBytes(), new File(uploadDir+"/"+fileName));
				images.add(new Image(fileName, new Timestamp(System.currentTimeMillis())));
			} catch (IOException e) {
			}
		}
		imageDao.create(images);
		return images;
	}
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 32) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
	
	public List<Image> getAllImages(){
		return imageDao.findAll();
	}
}
