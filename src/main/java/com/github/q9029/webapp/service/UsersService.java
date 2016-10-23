package com.github.q9029.webapp.service;

import java.util.List;

import com.github.q9029.webapp.dao.dto.UsersDto;

public interface UsersService {

    List<UsersDto> getAllUsersInfo();

    UsersDto getUserInfo(String userId);
}
