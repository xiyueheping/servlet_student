package control.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.serviceimpl.Service_userimpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * 接收前端登录请求
 */
@WebServlet(urlPatterns = {"/user/login"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        //响应消息编码方式
        resp.setCharacterEncoding("utf-8");
        //告诉浏览器使用何种方式解码响应数据
        resp.setHeader("content-type","application/json;charset=utf-8");
        //封装响应信息的map对象
        HashMap<String,String> map = new HashMap<>();

        System.out.println("接收到login请求");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkcodelogin = req.getParameter("checkcodelogin");
        //如果验证码不正确 直接响应登录失败，如果验证码正确再继续验证账号密码
        if(!(checkcodelogin.equalsIgnoreCase((String) req.getSession().getAttribute("checkcodelogin")))){
            req.getSession().removeAttribute("checkcodelogin"); //验证失败之后清除session中验证码信息
            map.put("msg","登录失败,验证码错误");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(map);
            resp.getWriter().write(json); //响应登录信息
            return;
        }
        req.getSession().removeAttribute("checkcodelogin"); //验证成功之后清除session中验证码信息
        String s = new Service_userimpl().login(username,password);
        //如果登录成功在session中保存用户信息
        if(s.equals("登录成功")){
            req.getSession().setAttribute("username",username);  //登录成功把用户name存入session

        }
        map.put("msg",s);
        //创建一个jackson的核心对象
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
        resp.getWriter().write(json); //响应登录信息
    }

}
