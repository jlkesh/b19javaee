package uz.jl.java_ee.servlets.storage;

import uz.jl.java_ee.dao.UploadsDao;
import uz.jl.java_ee.domains.Uploads;
import uz.jl.java_ee.exceptions.BadRequestException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {

    private final static UploadsDao uploadDao = new UploadsDao();

    private final Path rootPath = Paths.get("/home/jlkesh/uploads/app/libgen");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        Uploads uploads = uploadDao.findByGeneratedName(filename).orElseThrow(() -> {
            throw new BadRequestException("File not found");
        });
        Path resolvedPath = rootPath.resolve(filename);
        resp.setContentType(uploads.getContentType());
        resp.setHeader("Content-Disposition", "attachment; filename=" + uploads.getOriginalName() + ";");
        Files.copy(resolvedPath, resp.getOutputStream());
    }
}
