package com.github.q9029.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This filter forces the https connection.
 * 
 * <p>The request header, X-Forwarded-Proto is created by the Elastic Load Balancing.
 * It can be used to identify the protocol a client used to connect to this server.
 * 
 * @author q9029
 * @see Filter
 */
public class HttpsEnforceFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /* do nothing */
    }

    @Override
    public void destroy() {
        /* do nothing */
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if ("https".equals(request.getHeader("X-Forwarded-Proto"))) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(new StringBuilder().append("https://").append(request.getServerName()).append(request.getServletPath()).toString());
        }
    }
}
