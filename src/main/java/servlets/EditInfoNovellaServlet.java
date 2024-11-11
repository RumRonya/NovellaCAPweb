package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import novella_dao.NovellaCreateAndPlayDAO;
import novella_models.logicnovellas.NovellaGame;
import novella_models.users.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@MultipartConfig
public class EditInfoNovellaServlet  extends HttpServlet {

    public EditInfoNovellaServlet() {
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
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
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            NovellaCreateAndPlayDAO dao = new NovellaCreateAndPlayDAO();
            int ID_novella = dao.createNovellaGame(1,
                    req.getParameter("title"),
                    "",
                    "",
                    req.getParameterValues("genre[]"),
                    req.getParameter("description"),
                    Integer.parseInt(req.getParameter("age")));


          /*  Part h_poster = req.getPart("h_poster");
            Part v_poster = req.getPart("v_poster");*/
  /*/          String h_fileName = Paths.get(h_poster.getSubmittedFileName()).getFileName().toString(); // Получить имя файла
            String v_fileName = Paths.get(v_poster.getSubmittedFileName()).getFileName().toString(); // Получить имя файла
            InputStream h_fileContent = h_poster.getInputStream(); // Получить содержимое файла
            InputStream v_fileContent = v_poster.getInputStream(); // Получить содержимое файла
            String path = req.getServletContext().getRealPath("/")+"images/novellas/"+ID_novella;
            File uploadsDir = new File(path);
            if (!uploadsDir.exists()) {
                uploadsDir.mkdir();
            }
            Files.copy(h_fileContent, Paths.get(uploadsDir.getPath() + File.separator + h_fileName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(v_fileContent, Paths.get(uploadsDir.getPath() + File.separator + v_fileName), StandardCopyOption.REPLACE_EXISTING);
            File h_uploadedFile = new File(uploadsDir.getPath() + File.separator + h_fileName);
            File v_uploadedFile = new File(uploadsDir.getPath() + File.separator + v_fileName);
            System.out.println(h_uploadedFile.getPath().substring(req.getServletContext().getRealPath("/").length()));
*/
            dao.setPosters(ID_novella,
                    copyAndReturnPath(req.getPart("h_poster"),req,ID_novella).replace("\\","\\\\"),
                    copyAndReturnPath(req.getPart("v_poster"),req,ID_novella).replace("\\","\\\\"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/users");
        rd.forward(req, resp);
    }

    private String copyAndReturnPath(Part poster, HttpServletRequest request, int ID_novella) throws IOException {
        String h_fileName = Paths.get(poster.getSubmittedFileName()).getFileName().toString(); // Получить имя файла
        InputStream h_fileContent = poster.getInputStream(); // Получить содержимое файла
        String path = request.getServletContext().getRealPath("/")+"images/novellas/"+ID_novella;
        File uploadsDir = new File(path);
        if (!uploadsDir.exists()) {
            uploadsDir.mkdir();
        }
        Files.copy(h_fileContent, Paths.get(uploadsDir.getPath() + File.separator + h_fileName), StandardCopyOption.REPLACE_EXISTING);
        File h_uploadedFile = new File(uploadsDir.getPath() + File.separator + h_fileName);
        return h_uploadedFile.getPath().substring(request.getServletContext().getRealPath("/").length());
    }
}

