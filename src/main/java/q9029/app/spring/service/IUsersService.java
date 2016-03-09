package q9029.app.spring.service;

import java.util.List;

import q9029.app.spring.repository.dto.UsersDto;

public interface IUsersService {

    List<UsersDto> getAllUsersInfo();

    UsersDto getUserInfo(String userId);
}
