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

public class CreateNovellaServlet  extends HttpServlet {

    public CreateNovellaServlet() {
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            NovellaCreateAndPlayDAO dao = new NovellaCreateAndPlayDAO();
            List<User> users = dao.getCreatingUsers();

            req.setAttribute("List users", users);

            List<NovellaGame>  bests = new ArrayList<>();
            for (User user : users) {
                bests.add(dao.getTheBestNovellaGameByUserId(user.getID_USER()));
            }

            req.setAttribute("bests", bests);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //super.doGet(req, resp);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/users.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

