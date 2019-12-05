package ro.sda.service;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("got request");
        filterChain.doFilter(servletRequest, servletResponse);

//        String url = ((HttpServletRequest) servletRequest).getRequestURL().toString();
//        System.out.println("URL: " + url);
    }

    @Override
    public void destroy() {
    }
}
