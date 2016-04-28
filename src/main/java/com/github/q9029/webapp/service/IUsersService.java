package com.github.q9029.webapp.service;

import java.util.List;

import com.github.q9029.webapp.repository.dto.UsersDto;

public interface IUsersService {

    List<UsersDto> getAllUsersInfo();

    UsersDto getUserInfo(String userId);
}
