package gr.aueb.cf.erpProjectWithSQLAndJsp.controllers;

import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/erpProjectWithSQLAndJsp/clients-crud")

public class ClientController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/erpProjectWithSQLAndJsp/menu").forward(request,response);
    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/erpProjectWithSQLAndJsp/mainMenu").forward(request,response);
//    }
}
