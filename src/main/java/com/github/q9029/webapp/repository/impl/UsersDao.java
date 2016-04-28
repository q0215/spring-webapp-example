package com.github.q9029.webapp.repository.impl;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.q9029.webapp.repository.IUsersDao;
import com.github.q9029.webapp.repository.dto.UsersDto;

/**
 * UsersテーブルDAO
 * 
 * @author cs11028
 */
@Repository
class UsersDao implements IUsersDao {

    @Autowired
    private Properties applicationProperties;

    /** JDBC */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *
     */
    @Override
    public List<UsersDto> selectAll() {
        return jdbcTemplate.query(
                applicationProperties.getProperty("select-all-user-info"),
                new BeanPropertyRowMapper<UsersDto>(UsersDto.class));
    }

    /**
     * 
     */
    @Override
    public UsersDto select(String userId) {
        return jdbcTemplate.queryForObject(
                applicationProperties.getProperty("select-user-info"),
                new BeanPropertyRowMapper<UsersDto>(UsersDto.class), userId);
    }
}
