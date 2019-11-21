package control.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于登录状态验证的过滤器
 */

@WebFilter(value="/*") //访问所有资源之前都会执行该过滤器
public class Filterlogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //响应消息编码方式  并告诉浏览器使用何种方式解码响应数据
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type","application/json;charset=utf-8");
        System.out.println("登录验证执行过滤器");
        //如果是登录，注册请求，直接放行
        if(
                request.getRequestURI().contains("login")||
                request.getRequestURI().contains("register")||
                request.getRequestURI().contains("checkcode")
        ){

            filterChain.doFilter(servletRequest,servletResponse); //通过过滤器
        }
        //如果是其他请求进行登录态验证
        else{
            //如果登录过了就放行
            if(request.getSession().getAttribute("username")!=null){
                System.out.println("登录过了，放行");
                filterChain.doFilter(servletRequest,servletResponse); //通过过滤器
            }
            //否则进行拦截
            else{
                System.out.println("没有登录，拦截");
                response.getWriter().write("{\"msg\":\"登录态验证失败\"}");
            }
        }
    }

    @Override
    public void destroy() {
    }
}
