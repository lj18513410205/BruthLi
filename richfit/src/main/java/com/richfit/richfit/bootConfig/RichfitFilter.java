package com.richfit.richfit.bootConfig;

/**
 * @ClassName richfitFilter
 * @Description:过滤器
 * @Author BruthLi
 * @Date 2020/1/15
 * @Version V1.0
 **/
//@Component
//加了@ServletComponentScan,无论过滤器类加不加@Componment都可以,单使用@Component会默认过滤/*,
//@Order(1)  多个过滤器的时候
//@WebFilter(urlPatterns = {"/sys/user/jk"},filterName = "RichfitFilter")
public class RichfitFilter{
//implements Filter {
   /* @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我可以过滤/sys/user/jk的请求");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }*/
}
