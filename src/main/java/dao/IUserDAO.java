package dao;

import model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
    UserModel findByNameAndPasswordAndStatus(String name, String password, Integer status);
    Long insert(String username, String password, Integer status,Long role_id);
}
