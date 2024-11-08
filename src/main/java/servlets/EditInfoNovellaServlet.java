package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import novella_dao.NovellaCreateAndPlayDAO;
import novella_models.logicnovellas.NovellaGame;
import novella_models.users.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EditInfoNovellaServlet  extends HttpServlet {

    public EditInfoNovellaServlet() {
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            NovellaCreateAndPlayDAO dao = new NovellaCreateAndPlayDAO();
            Map<Integer, String> genres = dao.getGenres();

            req.setAttribute("genres", genres);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //super.doGet(req, resp);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/edit_info_novella.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        RequestDispatcher rd = req.getRequestDispatcher("/users");

        rd.forward(req, resp);
    }
}

