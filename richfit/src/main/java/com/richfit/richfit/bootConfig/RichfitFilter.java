package com.richfit.richfit.bootConfig;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName richfitFilter
 * @Description:过滤器
 * @Author BruthLi
 * @Date 2020/1/15
 * @Version V1.0
 **/

@WebFilter(urlPatterns = {"/sys/user/jk"},filterName = "RichfitFilter")
public class RichfitFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
