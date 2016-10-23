package com.github.q9029.webapp.dao.impl;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.q9029.webapp.dao.UsersDao;
import com.github.q9029.webapp.dao.dto.UsersDto;

/**
 * UsersテーブルDAO
 *
 * @author cs11028
 */
@Repository
class UsersDaoImpl implements UsersDao {

    @Autowired
    private Properties sqlMap;

    /** JDBC */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *
     */
    @Override
    public List<UsersDto> selectAll() {
        return jdbcTemplate.query(
                sqlMap.getProperty("selectAll"),
                new BeanPropertyRowMapper<UsersDto>(UsersDto.class));
    }

    /**
     *
     */
    @Override
    public UsersDto select(String userId) {
        return jdbcTemplate.queryForObject(
                sqlMap.getProperty("select"),
                new BeanPropertyRowMapper<UsersDto>(UsersDto.class), userId);
    }
}
