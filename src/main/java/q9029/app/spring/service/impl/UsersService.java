package q9029.app.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import q9029.app.spring.repository.IUsersDao;
import q9029.app.spring.repository.dto.UsersDto;
import q9029.app.spring.service.IUsersService;

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
