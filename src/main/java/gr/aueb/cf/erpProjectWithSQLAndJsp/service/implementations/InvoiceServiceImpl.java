package gr.aueb.cf.erpProjectWithSQLAndJsp.service.implementations;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.IInvoiceDAO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.InvoiceDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.InvoiceDTO.InvoiceInsertDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.InvoiceDTO.InvoiceUpdateDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Invoice;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.Interfaces.IInvoiceService;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.exceptions.InvoiceNotFoundException;

import java.util.List;

public class InvoiceServiceImpl implements IInvoiceService {

    private final IInvoiceDAO invoiceDAO ;

    public InvoiceServiceImpl(IInvoiceDAO invoiceDAO){
        this.invoiceDAO=invoiceDAO ;
    }

    @Override
    public Invoice insert(InvoiceInsertDTO dto) throws InvoiceDAOException {
        if(dto == null) return  null ;
        Invoice invoice ;

        try {
            invoice = map(dto);
            System.out.println("Service returned Invoice :"+ invoice.getInvoiceNo());
            return  invoiceDAO.insert(invoice);
        }catch (InvoiceDAOException e){
            e.printStackTrace();
            throw e ;
        }
    }

    @Override
    public Invoice update(InvoiceUpdateDTO dto) throws InvoiceDAOException {
        if (dto == null) return  null ;
        Invoice invoice;

        try {
            invoice = map(dto);
            if (invoiceDAO.getByInvoiceNo(invoice.getInvoiceNo(),invoice.getClient()) == null){
                throw new InvoiceNotFoundException(invoice);
            }
            return  invoiceDAO.update(invoice);
        }catch (InvoiceNotFoundException | InvoiceDAOException e){
            e.printStackTrace();
            return  null ;
        }
    }

    @Override
    public List<Invoice> getInvoicesByCLientName(Client client) throws InvoiceNotFoundException {
        List<Invoice> invoices ;

        try {
            invoices = invoiceDAO.getInvoicesByCLientName(client);
            return  invoices ;
        }catch (InvoiceDAOException e){
            e.printStackTrace();
            return  null ;
        }
    }

    @Override
    public Invoice getByInvoiceNo(String invoiceNo, Client client) throws InvoiceNotFoundException {
       Invoice invoice ;

       try {
           invoice = invoiceDAO.getByInvoiceNo(invoiceNo,client);
           if (invoice == null){
               throw new InvoiceNotFoundException("Invoice with invoice number "+ invoice.getInvoiceNo()+ "not found");
           }
           return  invoice ;
       }catch (InvoiceDAOException | InvoiceNotFoundException e){
           e.printStackTrace();
           return null ;

       }
    }

    private Invoice map (InvoiceInsertDTO dto){
        return  new Invoice(null,dto.getInvoiceNo(),dto.getClient(),dto.getDate(),dto.getVatStatus(),dto.getPaymentMethod(),dto.getVatExemption(),dto.getAmount(),dto.getVatPercentage(),dto.getTotalAmount());
    }

    private Invoice map (InvoiceUpdateDTO dto){
        return  new Invoice(null,dto.getInvoiceNo(),dto.getClient(),dto.getDate(),dto.getVatStatus(),dto.getPaymentMethod(),dto.getVatExemption(),dto.getAmount(),dto.getVatPercentage(),dto.getTotalAmount());
    }


}
