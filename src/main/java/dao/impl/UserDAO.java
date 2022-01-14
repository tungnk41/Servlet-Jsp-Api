package dao.impl;

import dao.IUserDAO;
import mapper.UserMapper;
import model.UserModel;
import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

    @Override
    public UserModel findByNameAndPasswordAndStatus(String name, String password, Integer status) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
        sql.append(" INNER JOIN role AS r ON r.id = u.role_id");
        sql.append(" WHERE username = ? AND password = ? AND status = ?");
        List<UserModel> users = query(sql.toString(), new UserMapper(), name, password, status);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public Long insert(String username, String password, Integer status, Long role_id) {
        String sql_find = "SELECT * FROM user WHERE username = ?";
        if(query(sql_find,new UserMapper(),username).size() > 0){
            System.out.println("User already exist");
            return -1L;
        }
        String sql_insert = "INSERT INTO user (username,password,status,role_id) VALUES(?,?,?,?)";
        return insert(sql_insert,username,password,status,role_id);
    }
}
