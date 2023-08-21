package gr.aueb.cf.erpProjectWithSQLAndJsp.service.Interfaces;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.ClientDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.clientDTO.ClientInsertDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.clientDTO.ClientUpdateDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.exceptions.ClientNotFoundException;

import java.util.List;

public interface IClientService {
    Client insert (ClientInsertDTO dto) throws ClientDAOException ;
    Client update (ClientUpdateDTO dto) throws ClientDAOException ;
    void  delete (Long vatNo) throws ClientDAOException , ClientNotFoundException ;

    List<Client> getByCompanyName(String companyName) throws ClientNotFoundException ;

    Client getClientByVatNo(long vatNo)  throws ClientDAOException ,ClientNotFoundException ;
}
