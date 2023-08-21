package gr.aueb.cf.erpProjectWithSQLAndJsp.service.exceptions;

import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;

public class ClientNotFoundException extends Exception{
    public ClientNotFoundException(Client client){
        super("Client with Vat No"+ client.getVatNo()+"does not exist");
    }

    public ClientNotFoundException(String s){super(s);}
}
