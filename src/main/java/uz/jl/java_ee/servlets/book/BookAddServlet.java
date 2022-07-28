package uz.jl.java_ee.servlets.book;

import uz.jl.java_ee.service.BookService;
import uz.jl.java_ee.container.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author "Elmurodov Javohir"
 * @since 26/07/22/10:22 (Tuesday)
 * java-ee/IntelliJ IDEA
 */

@WebServlet(value = "/books/add")
@MultipartConfig
public class BookAddServlet extends HttpServlet {
    private final BookService bookService = ApplicationContext.getBean(BookService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dp = req.getRequestDispatcher("/views/book/add.jsp");
        dp.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        session.removeAttribute("userId");
        bookService.create(req);
        resp.sendRedirect("/books");
    }
}
