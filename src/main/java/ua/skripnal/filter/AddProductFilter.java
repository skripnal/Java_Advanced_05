package ua.skripnal.filter;

import ua.skripnal.eEnum.UserRole;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/addProduct.jsp")
public class AddProductFilter implements Filter {
    private FilterService filterService = FilterService.getFilterService();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterService.doFilter(servletRequest,servletResponse,filterChain, Arrays.asList(UserRole.ADMIN.toString(), "log"));
    }

    @Override
    public void destroy() {

    }
}
