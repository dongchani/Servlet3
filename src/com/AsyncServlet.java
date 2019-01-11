package com;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet3.0规范的一个安全性  ServletSecurity，
 * 1.加上@ServletSecurity这个注解
 * 2.参数为httpMethodConstraints：http方法的安全约束
 * 3.加上@参数为httpMethodConstraints
 * 4.括号里的值
 * value：什么请求（GET,POST）
 * emptyRoleSemantic=ServletSecurity.EmptyRoleSemantic.PERMIT(允许访问)
 * rolesAllowed：角色的自定义
 * getRemoteUser：对我们登录用户名字的认证 输出在日志上
 */

@ServletSecurity(httpMethodConstraints = {@HttpMethodConstraint(value = "GET",emptyRoleSemantic = ServletSecurity.EmptyRoleSemantic.PERMIT,rolesAllowed = {"tomcat","admin"})})
@WebServlet(urlPatterns = "/async",asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 认证用户
         */
        System.out.println("loginUser："+request.getRemoteUser());

        AsyncContext asyncContext= request.startAsync();/*开启异步请求模式*/
        asyncContext.addListener(new AsyncListener() {/*添加监听事件*/
            /*完成时间*/
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                System.out.println(Thread.currentThread()+"complete...");
            }
            /*超时事件*/
            @Override
            public void onTimeout(AsyncEvent event) throws IOException {

            }
            /*出错事件*/
            @Override
            public void onError(AsyncEvent event) throws IOException {

            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {

            }

        });
           asyncContext.start(new Runnable() {
               @Override
               public void run() {
                   System.out.println(Thread.currentThread()+"执行异步操作");
                   try {
                     /*  Thread.sleep(15000);*/
                       /*跳转时使用（转发）*/
                       asyncContext.getRequest().getRequestDispatcher("/index.jsp").forward(request,response);
                      /* asyncContext.dispatch("index.jsp");*/
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           });
           /*无论如何都会执行这个准备结束*/
        System.out.println(Thread.currentThread()+"准备结束");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
    }
}
