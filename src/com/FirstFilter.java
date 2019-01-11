package com;

import javax.servlet.*;
import java.io.IOException;

/*过滤器也有生命周期（与servlet相似）*/
/*urlPatterns="/" 所有的请求经过过滤器过滤一下*/
/*@WebFilter(filterName = "FirstFilter",urlPatterns = "/servlet")*/
public class FirstFilter implements Filter {
    public void destroy() {/*销毁*/
    }
    /**
     * 拦截器：
     * 在disparcherservlet之后有一个preHandle拦截放法 在HandleApdater方法值之前
     *
     * 过滤器与拦截器的区别 ：
     *
     * 1.处理时机不同
     * （再请求资源之前就进行拦截和过滤，在响应过后就进行过滤）
     * 2.实现接口不同
     * 3.依赖的核心不同
     * （过滤器是servlet-api提供的，他是一种只要servlet规范   应用兼容比拦截器更广）
     * 特点：在相关资源（servlet或者静态资源）请求之前，或者是在相关资源响应之后，进行相关操作
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*在请求之前进行过滤*/
        System.out.println("开始过滤...");
        chain.doFilter(req, resp);/**/
        /*在请求之后进行过滤*/
        System.out.println("过滤结束....");
    }
    /*初始化*/
    public void init(FilterConfig config) throws ServletException {


    }

}
