package cn.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet( "/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        获取浏览器头
        String agent = request.getHeader("user-agent");

        if (agent.contains("Chrome")){
            System.out.println("chrome");
        }else if (agent.contains("Firefox")){
            System.out.println("Firefox");
        }

    }
}
