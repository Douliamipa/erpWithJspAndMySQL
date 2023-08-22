package gr.aueb.cf.erpProjectWithSQLAndJsp.controllers;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Implementations.ClientDAOImpl;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.IClientDao;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.ClientDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.clientDTO.ClientUpdateDTO;
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

@WebServlet("erpProjectWithSQLAndJsp/updateClient")
public class ClientUpdateController extends HttpServlet {
    private static final  long serialVersionUID = 1L ;
    private final IClientDao clientDao = new ClientDAOImpl();
    private final IClientService clientService = new ClientServiceImpl(clientDao);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("frontPages/clientUpdate.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Clientid"));
        String companyName = request.getParameter("CompanysName");
        long vatNo = Long.parseLong(request.getParameter("VAT_NO"));
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String streetNO = request.getParameter("streetNo");
        int zipCode = Integer.parseInt(request.getParameter("zipCode"));
        String country = request.getParameter("country");
        String paymentMethod = request.getParameter("PaymentMethod");
        String accountingCategory = request.getParameter("AccountingCategory");

        ClientUpdateDTO clientUpdateDTO =new ClientUpdateDTO();

        clientUpdateDTO.setCompanysName(companyName);
        clientUpdateDTO.setVatNo(vatNo);
        clientUpdateDTO.setCity(city);
        clientUpdateDTO.setStreet(street);
        clientUpdateDTO.setStreetNo(streetNO);
        clientUpdateDTO.setZipCode(zipCode);
        clientUpdateDTO.setCountry(country);
        clientUpdateDTO.setPaymentMethod(paymentMethod);
        clientUpdateDTO.setAccountingCategory(accountingCategory);

        try {
            Client client = clientService.update(clientUpdateDTO);
            request.setAttribute("client",client);
            request.getRequestDispatcher("frontPages/clientUpdated.jsp").forward(request,response);
        }catch (ClientDAOException  e){
            request.setAttribute("sqlError",true);
            request.setAttribute("message ",e.getMessage());
            request.getRequestDispatcher("/erpProjectWithSQLAndJsp/menu").forward(request,response);
        }
    }
}
