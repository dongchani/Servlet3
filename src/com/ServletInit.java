package com;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class ServletInit implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class <?>> c, ServletContext ctx) throws ServletException {
        System.out.println("初始化容器的Servlet");
        //
        ServletRegistration.Dynamic registration = ctx.addServlet("app", Servlet.class);
        registration.addMapping("/test");
        /**
         * 添加fitter过滤器
         */
       /* ctx.addFilter()*/
    }
}
