package web.servlet;

import web.login.dao.UserDao;
import web.login.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        //获取请求数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginuser = new User();
        loginuser.setUsename(username);
        loginuser.setPassword(password);

        //调用userdao的login方法
        UserDao dao = new UserDao();
        User login = dao.login(loginuser);

        //判断user
        if (login == null){
            //登录失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            //登录成功,转发数据
            req.setAttribute("login",login);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
