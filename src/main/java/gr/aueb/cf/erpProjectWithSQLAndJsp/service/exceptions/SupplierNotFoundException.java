package gr.aueb.cf.erpProjectWithSQLAndJsp.service.exceptions;

import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Supplier;

public class SupplierNotFoundException extends Exception{
    public SupplierNotFoundException(Supplier supplier){
        super("Supplier with Vat No" + supplier.getVatNo() + "does not exist");
    }

    public SupplierNotFoundException(String s ){
        super(s);
    }
}
