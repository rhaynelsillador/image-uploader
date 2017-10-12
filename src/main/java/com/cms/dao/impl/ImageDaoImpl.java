package com.cms.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cms.dao.ImageDao;
import com.cms.model.Image;

public class ImageDaoImpl implements ImageDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final static String INSERT = "INSERT INTO IMAGE (name, timestamp) VALUES (?,?)";
	private final static String SQL = "SELECT * FROM IMAGE";
	public void create(final List<Image> images) {
		jdbcTemplate.batchUpdate(INSERT, new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Image image = images.get(i);
				ps.setString(1, image.getName());
				ps.setTimestamp(2, image.getTimestamp());
			}
			
			public int getBatchSize() {
				return images.size();
			}
		});
	}

	public List<Image> findAll() {
		return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<Image>(Image.class));
	}

}
