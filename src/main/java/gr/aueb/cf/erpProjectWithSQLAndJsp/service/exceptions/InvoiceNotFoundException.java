package gr.aueb.cf.erpProjectWithSQLAndJsp.service.exceptions;

import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Invoice;

public class InvoiceNotFoundException extends Exception{
    public InvoiceNotFoundException(Invoice invoice){
        super("Invoice with"+ invoice.getInvoiceNo()+"was not found ");
    }

    public InvoiceNotFoundException(String s ){
        super(s);
    }
}
