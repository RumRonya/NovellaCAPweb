package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import novella_dao.NovellaCreateAndPlayDAO;
import novella_dao.NovellaGameDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet ("/users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("List users", new NovellaCreateAndPlayDAO().getUsers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        super.doGet(req, resp);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/users.jsp");
        rd.forward(req, resp);
    }
}
