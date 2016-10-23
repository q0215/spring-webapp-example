package com.github.q9029.webapp.dao;

import java.util.List;

import com.github.q9029.webapp.dao.dto.UsersDto;

/**
 * 新規登録DAOインタフェース
 * 
 * @author cs11028
 */
public interface UsersDao {
    
    List<UsersDto> selectAll();

    UsersDto select(String userId);
}
