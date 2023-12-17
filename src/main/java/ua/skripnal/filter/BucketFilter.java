package ua.skripnal.filter;

import ua.skripnal.eEnum.UserRole;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/bucket.jsp")
public class BucketFilter implements Filter {
    private FilterService filterService = FilterService.getFilterService();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterService.doFilter(servletRequest,servletResponse,filterChain, Arrays.asList(UserRole.ADMIN.toString(), UserRole.USER.toString(), "log"));
    }

    @Override
    public void destroy() {

    }
}
