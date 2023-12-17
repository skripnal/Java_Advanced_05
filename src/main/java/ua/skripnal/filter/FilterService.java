package ua.skripnal.filter;

import ua.skripnal.eEnum.UserRole;
import ua.skripnal.model.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class FilterService {
    private static FilterService filterService;

    private FilterService(){}

    public static FilterService getFilterService(){
        if (filterService == null){
            filterService = new FilterService();
        }
        return filterService;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain, List<String> userRoleList) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) session.getAttribute("user");


        if (user != null && userRoleList.contains(user.getRole()) && userRoleList.contains(session.getAttribute("status"))){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            if (user == null && (userRoleList.contains(session.getAttribute("status")))){
                filterChain.doFilter(servletRequest,servletResponse);
            }else if (user != null){
                servletRequest.getRequestDispatcher("shop.jsp").forward(servletRequest,servletResponse);
            }else {
                servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest,servletResponse);
            }
        }
    }
}
