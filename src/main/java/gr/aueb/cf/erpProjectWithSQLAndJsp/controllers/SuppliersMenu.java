package gr.aueb.cf.erpProjectWithSQLAndJsp.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/erpProjectWithSQLAndJsp/suppliersMenu")
public class SuppliersMenu extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clientsNotFound",false);
        request.setAttribute("suppliersNotFound",false);
        request.setAttribute("isError",false);
        request.setAttribute("error", "");
        request.getRequestDispatcher("/frontPages/SuppliersMenu.jsp").forward(request,response);
    }

}
