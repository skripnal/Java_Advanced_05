package ua.skripnal.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/registration.jsp")
public class RegistrationFilter implements Filter {
    private static FilterService filterService = FilterService.getFilterService();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterService.doFilter(servletRequest,servletResponse,filterChain, Arrays.asList("unlog"));
    }

    @Override
    public void destroy() {

    }
}

