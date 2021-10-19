package lab2.javaeelab2.controller;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lab2.javaeelab2.file_repository.RecordsFileRepository;
import lab2.javaeelab2.model.Category;
import lab2.javaeelab2.model.Record;

@WebServlet(name = "controllerServlet", value = "/controller-servlet")
public class ControllerServlet extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        if(name != null && name.equals("input")) {
            request.setAttribute("category",new Category("Drama"));
            request.getRequestDispatcher("/view/" + name + ".jsp").forward(request, response);
        } else if(name != null && name.equals("response")){
            request.setAttribute("recordsData", RecordsFileRepository.readRecordsFromFile());
            request.getRequestDispatcher("/view/" + name + ".jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RecordsFileRepository.writeRecordToFile(
                new Category(request.getParameter("category")),
                request.getParameter("key"),
                request.getParameter("value")
        );
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}