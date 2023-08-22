package gr.aueb.cf.erpProjectWithSQLAndJsp.controllers;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Implementations.ClientDAOImpl;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.IClientDao;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.Interfaces.IClientService;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.implementations.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/erpProjectWithSQLAndJsp/deleteClient")
public class ClientDeleteController extends HttpServlet {
    private static  final  long serialVersionUID = 1L;
     IClientDao clientDao = new ClientDAOImpl();
     IClientService clientService = new ClientServiceImpl(clientDao);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
