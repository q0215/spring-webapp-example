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

import org.apache.log4j.Logger;

/**
 * <p>https通信を強制するフィルタリングを行います。</p>
 * <p>ロードバランサなどでhttp通信に変換されてしまう環境では、<br>
 * SpringSecutiryの設定でhttps通信を強制することができないため、<br>
 * リクエストヘッダーを基に判断し、https通信としてリダイレクトします。</p>
 *
 * @author q9029
 */
public class HerokuHttpsEnforceFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(HerokuHttpsEnforceFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /* do nothing */
    }

    @Override
    public void destroy() {
        /* do nothing */
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String xForwardedProto = request.getHeader("X-Forwarded-Proto");

        LOGGER.debug("X-Forwarded-Proto:" + xForwardedProto);

        if ("https".equals(xForwardedProto)) {
            filterChain.doFilter(request, response);

        } else {
            String redirectUrl = new StringBuilder()
                    .append("https://").append(request.getServerName()).append(request.getServletPath()).toString();

            LOGGER.debug("redirect:" + redirectUrl);
            response.sendRedirect(redirectUrl);
        }
    }
}
