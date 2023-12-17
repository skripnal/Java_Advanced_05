package ua.skripnal.servlet;

import com.google.gson.Gson;
import ua.skripnal.dao.ProductDao;
import ua.skripnal.daoImpl.ProductDaoImpl;
import ua.skripnal.model.Product;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
        productService.insert(req.getParameter("name"), req.getParameter("description"), Double.parseDouble(req.getParameter("price")),req.getParameter("category"),req.getParameter("sub_category"), req.getParameter("image_path"));
        resp.getWriter().write("success");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] categories = req.getParameterValues("category[]");
        String[] subCategories = req.getParameterValues("subCategory[]");
        String json;
        List<Object> list = new ArrayList<>();
        if (categories == null && subCategories == null){
            list.addAll(productService.readAll());
        }else {
            for (int i = 0; i < categories.length; i++){
                for (int j = i; j <= i; j++){
                    list.addAll(productService.readByCategory(categories[i],subCategories[j]));
                }
            }
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        json = new Gson().toJson(list);
        resp.getWriter().write(json);
    }
}
