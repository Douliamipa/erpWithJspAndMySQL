package gr.aueb.cf.erpProjectWithSQLAndJsp.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get-Invoice")
public class InvoiceController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = "coding fACTORY";

        request.setAttribute("codingTitle",title);
        request.getRequestDispatcher("/frontPages/Invoice1.jsp").forward(request,response);
    }
}
