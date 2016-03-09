package q9029.app.spring.repository;

import java.util.List;

import q9029.app.spring.repository.dto.UsersDto;

/**
 * 新規登録DAOインタフェース
 * 
 * @author cs11028
 */
public interface IUsersDao {
    
    List<UsersDto> selectAll();

    UsersDto select(String userId);
}
