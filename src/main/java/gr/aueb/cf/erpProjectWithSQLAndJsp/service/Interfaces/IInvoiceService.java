package gr.aueb.cf.erpProjectWithSQLAndJsp.service.Interfaces;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.InvoiceDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.InvoiceDTO.InvoiceInsertDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.InvoiceDTO.InvoiceUpdateDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Invoice;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.exceptions.InvoiceNotFoundException;

import java.util.List;

public interface IInvoiceService {
    Invoice insert (InvoiceInsertDTO dto) throws InvoiceDAOException ;

    Invoice update (InvoiceUpdateDTO dto) throws InvoiceDAOException ;

    List<Invoice> getInvoicesByCLientName(Client client) throws InvoiceNotFoundException ;

    Invoice getByInvoiceNo(String invoiceNo , Client client) throws InvoiceNotFoundException ;
}
