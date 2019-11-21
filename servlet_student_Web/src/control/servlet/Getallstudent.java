package control.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Student;
import service.Serv_student;
import service.serviceimpl.Serv_studentimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 接收前端获取所有学生请求
 */
@WebServlet(urlPatterns = {"/student/getall"})
public class Getallstudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //响应消息编码方式
        resp.setCharacterEncoding("utf-8");
        //告诉浏览器使用何种方式解码响应数据
        resp.setHeader("content-type","application/json;charset=utf-8");
        //封装响应信息的map对象
        HashMap<String,ArrayList<Student>> map = new HashMap<>();

        System.out.println("接收到student/getall请求");
        Serv_student servStudent = new Serv_studentimpl();
        ArrayList<Student> students = servStudent.getall();
        map.put("msg",students);
        //创建一个jackson的核心对象
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
        resp.getWriter().write(json); //响应登录信息

    }
}
