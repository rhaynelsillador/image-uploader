package com.cms.dao;

import java.util.List;

import com.cms.model.Image;

public interface ImageDao {

	void create(List<Image> images);
	List<Image> findAll();
	
}
