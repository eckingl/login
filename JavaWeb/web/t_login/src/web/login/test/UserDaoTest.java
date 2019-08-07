package web.login.test;


import org.junit.*;
import web.login.dao.UserDao;
import web.login.domain.User;

public class UserDaoTest {


    @Test
    public void testLogin(){

        User loginuser = new User();
        loginuser.setUsename("zhangsan");
        loginuser.setPassword("13");

        UserDao userDao = new UserDao();

        User login = userDao.login(loginuser);

        System.out.println(login);

    }


}
