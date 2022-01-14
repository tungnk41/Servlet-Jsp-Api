package service.impl;

import dao.IUserDAO;
import dao.impl.UserDAO;
import model.UserModel;
import service.IUserService;

public class UserService implements IUserService {
    private IUserDAO userDAO;
    public UserService() {
        userDAO = new UserDAO();
    }

    @Override
    public UserModel findUserByNameAndPasswordAndStatus(String username, String password, Integer status) {
        return userDAO.findByNameAndPasswordAndStatus(username,password,status);
    }

    @Override
    public Long insert(UserModel user, Long role_id) {
        return userDAO.insert(user.getUsername(),user.getPassword(),user.getStatus(),role_id);
    }
}
