package servlets;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Mirror extends HttpServlet {
    private String login = "";

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        String parameters = request.getParameterMap().toString();
        Map<String, Object> templateParams = new HashMap<>();
        templateParams.put("parameters", parameters);

        response.getWriter().println(PageGenerator.getInstance().getPage("mirror.html", templateParams));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
