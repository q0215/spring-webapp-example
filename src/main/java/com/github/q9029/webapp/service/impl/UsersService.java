package com.github.q9029.webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.webapp.repository.IUsersDao;
import com.github.q9029.webapp.repository.dto.UsersDto;
import com.github.q9029.webapp.service.IUsersService;

@Service
class UsersService implements IUsersService {

    @Autowired
    IUsersDao dao;

    @Override
    public List<UsersDto> getAllUsersInfo() {
        return dao.selectAll();
    }

    @Override
    public UsersDto getUserInfo(String userId) {
        return dao.select(userId);
    }
}
