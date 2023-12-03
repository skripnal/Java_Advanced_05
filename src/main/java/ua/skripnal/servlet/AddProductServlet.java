package ua.skripnal.servlet;

import ua.skripnal.dao.ProductDao;
import ua.skripnal.daoImpl.ProductDaoImpl;
import ua.skripnal.service.ProductService;
import ua.skripnal.serviceImpl.ProductServiceImpl;
import ua.skripnal.utils.ConnectionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;


@WebServlet("/addProductServlet")
public class AddProductServlet extends HttpServlet {
    private Connection connection;
    private ProductDao productDao;
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        connection = ConnectionUtils.openConnection();
        productDao = new ProductDaoImpl(connection);
        productService = new ProductServiceImpl(productDao);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        productService.insert(req.getParameter("name"), req.getParameter("description"), Double.parseDouble(req.getParameter("price")));
        resp.getWriter().write("success");
    }
}
