package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cms.model.Image;
import com.cms.services.ImageUploadServices;

@RestController
public class UploadImagesControlller {
	
	@Autowired
	private ImageUploadServices imageUploadServices;
	
	@RequestMapping(path="/FormUploadFile", method = {RequestMethod.POST, RequestMethod.GET}, produces="application/json")
	public @ResponseBody List<Image> formUploadFile(@RequestParam("fileToUpload[]") MultipartFile[] multipartFiles) {
		return imageUploadServices.fileUploads(multipartFiles);
	}
	
	@RequestMapping(path="/ImageList", method = {RequestMethod.POST, RequestMethod.GET}, produces="application/json")
	public @ResponseBody List<Image> imageList() {
		return imageUploadServices.getAllImages();
	}
	
}
