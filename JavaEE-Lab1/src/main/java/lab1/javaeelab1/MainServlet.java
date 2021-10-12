package lab1.javaeelab1;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "mainServlet", value = "/main-servlet")
public class MainServlet extends HttpServlet {
    private String confirmationMessage;

    public void init() {
        confirmationMessage = "Request received.";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String requestKey = request.getParameter("key");
        int requestValue = Integer.parseInt(request.getParameter("value"));
        boolean requestMock = Boolean.parseBoolean(request.getParameter("mock"));
        boolean requestSync = Boolean.parseBoolean(request.getParameter("sync"));
        LocalDateTime timestamp = LocalDateTime.now();
        PrintWriter out = response.getWriter();

        System.out.print(request.getMethod() + "\n" + request.getRemoteAddr() + "\n" + request.getHeader("User-Agent") +
                            "\n" + request.getLocale().getLanguage() + "\n" + Collections.list(request.getParameterNames()));

        if (requestMock) {
            out.println(confirmationMessage);
        } else {
            ServletHelper.configWriteInfo(requestKey, requestValue, timestamp, requestSync);
            List<String> htmlLines = ServletHelper.readAndFormatContent();
            RequestDispatcher dispatcher = request.getRequestDispatcher("response.jsp");
            request.setAttribute("lines", htmlLines);
            dispatcher.forward(request, response);
        }



    }

    public void destroy() {
    }
}