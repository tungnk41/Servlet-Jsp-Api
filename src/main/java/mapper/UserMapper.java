package mapper;

import model.RoleModel;
import model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel>{
    @Override
    public UserModel mapRow(ResultSet rs) {
        try{
            UserModel user = new UserModel();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setStatus(rs.getInt("status"));
            try{
                RoleModel role = new RoleModel();
                role.setId(rs.getLong("role_id"));
                role.setName(rs.getString("name"));
                role.setCode(rs.getString("code"));
                user.setRole(role);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return user;
        }catch (SQLException e){
            return null;
        }

    }
}
