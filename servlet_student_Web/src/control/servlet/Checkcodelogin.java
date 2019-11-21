package control.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 接收前端获取登录验证码图片请求
 */
@WebServlet(urlPatterns = {"/user/checkcodelogin"})
public class Checkcodelogin extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //告诉浏览器使用何种方式解码响应数据
        resp.setHeader("content-type","image/jpeg;charset=utf-8");
        System.out.println("接收到checkcode请求");
        //获取验证码图片
        BufferedImage image = this.getimg(req);
        //获取字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //将图片返回到前端
        ImageIO.write(image,"jpg",outputStream);

    }

    public BufferedImage getimg(HttpServletRequest req){
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //填充背景色
        Graphics g = image.getGraphics(); //画笔对象
        g.setColor(Color.orange); //设置画笔颜色
        g.fillRect(0,0,width,height);
        //生成随机字符并绘制到图片上
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String checknum = "";
        Random random = new Random();
        g.setColor(Color.BLUE);
        for(int i=1;i<=4;i++){
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            checknum = checknum + ch;
            g.drawString(ch+"",width/5*i,height/2);
        }
        //随机画干扰线
        g.setColor(Color.CYAN);
        for(int i=0;i<5;i++){
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,x2,y1,y2);
        }
        System.out.println("生成登录验证码为："+checknum);
        req.getSession().setAttribute("checkcodelogin",checknum);
        return image;
    }
}
