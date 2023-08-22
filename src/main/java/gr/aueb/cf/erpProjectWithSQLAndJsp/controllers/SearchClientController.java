package gr.aueb.cf.erpProjectWithSQLAndJsp.controllers;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Implementations.ClientDAOImpl;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.IClientDao;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.ClientDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.Interfaces.IClientService;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.exceptions.ClientNotFoundException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.implementations.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/erpProjectWithSQLAndJsp/searchClient")
public class SearchClientController extends HttpServlet {
    private  static  final long serialVersionUID = 1L;
    IClientDao clientDao = new ClientDAOImpl();
    IClientService clientService = new ClientServiceImpl(clientDao);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isError", false);
        request.setAttribute("error", "");
        request.setAttribute("clientsNotFound", false);
        request.getRequestDispatcher("/frontPages/Menu.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String companysName  = request.getParameter("CompanyName").trim();

        String message = "";

        try {
            List<Client> clients  = clientService.getByCompanyName(companysName);
            if (clients.size() == 0){
                request.setAttribute("clientsNotFound",true);
                request.getRequestDispatcher("/frontPages/Menu.jsp").forward(request,response);
            }
            request.setAttribute("clients",clients);
            request.getRequestDispatcher("frontPages/clients.jsp").forward(request,response);

        } catch ( ClientNotFoundException e) {
            message = e.getMessage();
            request.setAttribute("isError", true);
            request.setAttribute("errorMessage", message);
            request.getRequestDispatcher("/frontPages/Menu.jsp").forward(request, response);
        }
    }
}
