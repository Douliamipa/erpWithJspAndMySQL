package gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.InvoiceDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Invoice;

import java.util.List;

public interface IInvoiceDAO {
    Invoice insert (Invoice invoice) throws InvoiceDAOException ;
    Invoice update (Invoice invoice) throws InvoiceDAOException ;
    List<Invoice>getInvoicesByCLientName(Client client) throws InvoiceDAOException ;
    Invoice getByInvoiceNo(String invoiceNo , Client client) throws InvoiceDAOException ;

}
