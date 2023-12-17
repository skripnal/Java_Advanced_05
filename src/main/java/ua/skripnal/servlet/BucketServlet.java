package ua.skripnal.servlet;

import com.google.gson.Gson;
import ua.skripnal.dao.BucketDao;
import ua.skripnal.dao.ProductDao;
import ua.skripnal.daoImpl.BucketDaoImpl;
import ua.skripnal.daoImpl.ProductDaoImpl;
import ua.skripnal.model.Bucket;
import ua.skripnal.model.CustomProductBucket;
import ua.skripnal.model.Product;
import ua.skripnal.model.User;
import ua.skripnal.service.BucketService;
import ua.skripnal.service.ProductService;
import ua.skripnal.serviceImpl.BucketServiceImpl;
import ua.skripnal.serviceImpl.ProductServiceImpl;
import ua.skripnal.utils.ConnectionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bucket")
public class BucketServlet extends HttpServlet {

    private Connection connection;
    private BucketDao bucketDao;
    private BucketService bucketService;
    private ProductDao productDao;
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        connection = ConnectionUtils.openConnection();
        bucketDao = new BucketDaoImpl(connection);
        bucketService = new BucketServiceImpl(bucketDao);
        productDao = new ProductDaoImpl(connection);
        productService = new ProductServiceImpl(productDao);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
//        List<Bucket> bucketList = bucketService.readAllByUserId(user.getId());
//        List<CustomProductBucket> productList = new ArrayList<>();
//        for (Bucket bucket: bucketList){
//            productList.add(productService.readById(bucket.getProductId()));
//        }
            String json = new Gson().toJson(productService.readALLProductBucket(user.getId()));
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        bucketService.deleteProduct(Integer.parseInt(req.getParameter("productId")));
    }

}

