package com;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Filter  和  servlet 的生命周期相似
 *  filter 和Interceptor 的区别
 *  1.处理时机不同
 *  2.实现的接口不同
 *  3.依赖核心不同  （filter是依赖于servlet   Interceptor是依赖于SpringMvc）。
 */
@WebFilter(filterName = "newFilter",urlPatterns = "/servlet")
public class newFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       /*再请求之前进行过滤*/
        System.out.println("start....."+Thread.currentThread().getName());

        chain.doFilter(req, resp);
        /*再请求之后进行过滤*/
        System.out.println("end......"+Thread.currentThread().getName());
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
