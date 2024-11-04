package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import novella_dao.NovellaCreateAndPlayDAO;

import java.io.IOException;
import java.sql.SQLException;

public class NovellaServlet extends HttpServlet {

    public NovellaServlet(){

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("List novellas", new NovellaCreateAndPlayDAO().getUsers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //super.doGet(req, resp);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/novellas.jsp");
        rd.forward(req, resp);
    }
}
