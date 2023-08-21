package gr.aueb.cf.erpProjectWithSQLAndJsp.controllers;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Implementations.ClientDAOImpl;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.IClientDao;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.ClientDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.clientDTO.ClientInsertDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.Interfaces.IClientService;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.implementations.ClientServiceImpl;
import gr.aueb.cf.erpProjectWithSQLAndJsp.validator.ClientValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/erpProjectWithSQLAndJsp/insertClient")
public class InsertClientController extends HttpServlet {
    private final IClientDao clientDAO = new ClientDAOImpl() ;
    private  final IClientService clientService = new ClientServiceImpl(clientDAO);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("clientsNotFound",false);
//        request.setAttribute("suppliersNotFound",false);
//        request.setAttribute("isError",false);
//        request.setAttribute("error", "");
        request.getRequestDispatcher("/frontPages/menu").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("error","");

        String companyName = request.getParameter("COMPANY_NAME");
        long vatNo = Long.parseLong(request.getParameter("VAT_NO"));
        String city = request.getParameter("CITY");
        String street = request.getParameter("STREET");
        String streetNO = request.getParameter("STREET_NO");
        int zipCode = Integer.parseInt(request.getParameter("ZIPCODE"));
        String country = request.getParameter("COUNTRY");
        String paymentMethod = request.getParameter("PaymentMethod");
        String accountingCategory = request.getParameter("AccountingCategory");

        ClientInsertDTO clientInsertDTO = new ClientInsertDTO();

        clientInsertDTO.setCompanysName(companyName);
        clientInsertDTO.setVatNo(vatNo);
        clientInsertDTO.setStreet(street);
        clientInsertDTO.setStreetNo(streetNO);
        clientInsertDTO.setZipCode(zipCode);
        clientInsertDTO.setCountry(country);
        clientInsertDTO.setPaymentMethod(paymentMethod);
        clientInsertDTO.setAccountingCategory(accountingCategory);

        try {
            Map<String,String> errors = ClientValidator.validate(clientInsertDTO);
//            if (!errors.isEmpty()){
//                String vatNoMessage = (errors.get("VatNo") != null) ? "VatNo"+errors.get("VatNo") :"";
//                String clientCategotyMessage = (errors.get("Accounting Categoty") != null) ? "Accounting Categoty"+errors.get("Domestic client") :"";
//                request.setAttribute("error",vatNoMessage+" " + clientCategotyMessage);
//                request.getRequestDispatcher("/erpProjectWithSQLAndJsp/menu").forward(request,response);
//                return;
//            }
            Client client = clientService.insert(clientInsertDTO);
            request.setAttribute("insertedClient",client);
            request.getRequestDispatcher("/frontPages/clientInserted.jsp").forward(request,response);
        }catch (ClientDAOException e){
            request.setAttribute("sqlError",true);
            request.setAttribute("message ",e.getMessage());
            request.getRequestDispatcher("/erpProjectWithSQLAndJsp/menu").forward(request,response);

        }
    }
}
