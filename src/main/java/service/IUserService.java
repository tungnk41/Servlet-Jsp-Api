package service;

import model.UserModel;

public interface IUserService {
    UserModel findUserByNameAndPasswordAndStatus(String username, String password, Integer status);
    Long insert(UserModel user, Long role_id);
}
