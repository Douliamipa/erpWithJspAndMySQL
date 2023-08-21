package gr.aueb.cf.erpProjectWithSQLAndJsp.controllers;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Implementations.SupplierDAOImpl;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.ISupplierDAO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.ClientDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.SupplierDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.supplierDTO.SupplierInsertDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Supplier;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.Interfaces.ISupplierService;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.implementations.SupplierServiceImpl;
import gr.aueb.cf.erpProjectWithSQLAndJsp.validator.ClientValidator;
import gr.aueb.cf.erpProjectWithSQLAndJsp.validator.SupplierValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/erpProjectWithSQLAndJsp/insertSupplier")
public class InsertSupplierController extends HttpServlet {

    private final ISupplierDAO supplierDAO = new SupplierDAOImpl();
    private final ISupplierService supplierService = new SupplierServiceImpl(supplierDAO);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/frontPages/SuppliersMenu.jsp").forward(request,response);
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

        SupplierInsertDTO supplierInsertDTO = new SupplierInsertDTO();

        supplierInsertDTO.setCompanysName(companyName);
        supplierInsertDTO.setVatNo(vatNo);
        supplierInsertDTO.setStreet(street);
        supplierInsertDTO.setStreetNo(streetNO);
        supplierInsertDTO.setZipCode(zipCode);
        supplierInsertDTO.setCountry(country);
        supplierInsertDTO.setPaymentMethod(paymentMethod);
        supplierInsertDTO.setAccountingCategory(accountingCategory);

        try {
            Map<String,String> errors = SupplierValidator.validate(supplierInsertDTO);
//            if (!errors.isEmpty()){
//                String vatNoMessage = (errors.get("VatNo") != null) ? "VatNo"+errors.get("VatNo") :"";
//                String clientCategotyMessage = (errors.get("Accounting Categoty") != null) ? "Accounting Categoty"+errors.get("Domestic client") :"";
//                request.setAttribute("error",vatNoMessage+" " + clientCategotyMessage);
//                request.getRequestDispatcher("/erpProjectWithSQLAndJsp/menu").forward(request,response);
//                return;
//            }
            Supplier  supplier= supplierService.insertSupplier(supplierInsertDTO);
            request.setAttribute("insertedSupplier",supplier);
            request.getRequestDispatcher("/frontPages/SupplierInserted.jsp").forward(request,response);//to do
        }catch (SupplierDAOException e){
            request.setAttribute("sqlError",true);
            request.setAttribute("message ",e.getMessage());
            request.getRequestDispatcher("/erpProjectWithSQLAndJsp/menu").forward(request,response);

        }



    }
}
