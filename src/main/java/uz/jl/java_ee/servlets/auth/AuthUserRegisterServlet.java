package uz.jl.java_ee.servlets.auth;

import uz.jl.java_ee.container.ApplicationContext;
import uz.jl.java_ee.dto.auth.RegisterDTO;
import uz.jl.java_ee.service.AuthUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/auth/register")
public class AuthUserRegisterServlet extends HttpServlet {

    private final AuthUserService authUserService = ApplicationContext.getBean(AuthUserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterDTO dto = RegisterDTO.builder()
                .username(req.getParameter("username"))
                .password(req.getParameter("password"))
                .confirmPassword(req.getParameter("confirmPassword"))
                .build();
        authUserService.create(dto);
        resp.sendRedirect("/auth/login");
    }
}
