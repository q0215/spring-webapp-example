package com.github.q9029.webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.webapp.dao.UsersDao;
import com.github.q9029.webapp.dao.dto.UsersDto;
import com.github.q9029.webapp.service.UsersService;

@Service
class UsersServiceImpl implements UsersService {

    @Autowired
    UsersDao dao;

    @Override
    public List<UsersDto> getAllUsersInfo() {
        return dao.selectAll();
    }

    @Override
    public UsersDto getUserInfo(String userId) {
        return dao.select(userId);
    }
}
