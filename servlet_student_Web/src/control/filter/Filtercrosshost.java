package control.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 允许跨域访问所有的servlet
 */
@WebFilter(value="/*") //访问所有资源之前都会执行该过滤器
public class Filtercrosshost implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("执行允许跨域过滤器");
        /* 允许跨域的主机地址  这里放前端所在服务器的url地址 */
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:9000");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        response.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        response.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        response.setHeader("Access-Control-Allow-Credentials", "true");




        filterChain.doFilter(servletRequest,servletResponse); //通过过滤器
    }

    @Override
    public void destroy() {
    }
}
