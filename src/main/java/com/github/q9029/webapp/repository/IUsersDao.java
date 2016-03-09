package com.github.q9029.webapp.repository;

import java.util.List;

import com.github.q9029.webapp.repository.dto.UsersDto;

/**
 * 新規登録DAOインタフェース
 * 
 * @author cs11028
 */
public interface IUsersDao {
    
    List<UsersDto> selectAll();

    UsersDto select(String userId);
}
