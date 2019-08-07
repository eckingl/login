package web.login.dao;

/*
    操作数据库的类
 */

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import web.login.domain.User;
import web.login.util.JDBCUtil;

public class UserDao {
    //声明jdbctemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSourse());

      // 登录方法

    public User login(User loginUser){

        try {

            String sql = "select * from user where username = ? and password = ?";

            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsename(), loginUser.getPassword()
            );

            return user;

        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }


    }



}
