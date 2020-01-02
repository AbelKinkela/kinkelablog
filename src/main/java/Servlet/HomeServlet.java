package Servlet;

import Model.Connect;
import View.Article;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class HomeServlet extends HttpServlet{
    ArrayList<Article> articles =new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // create a database connection
            Connection connection = Connect.initializeDatabase();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ARTICLE");
            while (rs.next()) {
                // read the result set
                String title= rs.getString("TITLE");
                Date published = rs.getDate("PUBLISHED");
                String content = rs.getString("CONTENT");

                System.out.println("DATA >>> "+title + published.toString()+ content);
                articles.add(new Article(title, content, published));
            }
            connection.close();
        } catch (Exception e) {

            System.err.println(e.getMessage());
        }

        request.setAttribute("articles", articles);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
