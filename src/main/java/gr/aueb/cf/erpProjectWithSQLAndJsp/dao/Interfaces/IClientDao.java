package gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.ClientDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;

import java.util.List;

public interface IClientDao {
    Client insert (Client client) throws ClientDAOException;

    Client update (Client client ) throws ClientDAOException ;

    void delete (Long vatNo ) throws ClientDAOException ;
    List<Client> getByCompanyName (String companyName) throws ClientDAOException ;

    Client getByVatNo(long vatNo) throws ClientDAOException;


}
