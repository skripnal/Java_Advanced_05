package ua.skripnal.servlet;

import com.google.gson.Gson;
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

@WebServlet("/singleProduct")
public class SingleProductServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("id"));
        String json = new Gson().toJson(productService.readById(productId));
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
