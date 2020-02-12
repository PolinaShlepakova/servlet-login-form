package src.com.polinashlepakova;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"login\" method=\"POST\">");
            out.println("Login: ");
            out.println("<input type=\"text\" name=\"login\"/>");
            out.println("Password: ");
            out.println("<input type=\"password\" name=\"password\"/>");
            out.println("<input type=\"submit\" value=\"Submit\"/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        boolean authSuccessful = login.equals(LOGIN) && password.equals(PASSWORD);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + (authSuccessful ? "Hello" : "Error") + "</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(authSuccessful ? ("Hello, " + login + "!") : "Wrong login or password!");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
