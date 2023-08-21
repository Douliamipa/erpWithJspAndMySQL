package gr.aueb.cf.erpProjectWithSQLAndJsp.service.implementations;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.IClientDao;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.ClientDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.clientDTO.ClientInsertDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.clientDTO.ClientUpdateDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.Interfaces.IClientService;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.exceptions.ClientNotFoundException;

import java.util.List;

public class ClientServiceImpl implements IClientService {
    private final IClientDao clientDao ;
    public ClientServiceImpl(IClientDao clientDao){this.clientDao = clientDao;}
    @Override
    public Client insert(ClientInsertDTO dto) throws ClientDAOException {
        if (dto == null)return null;
        Client client ;

        try {
            client = map(dto);
            System.out.println("Service returned client :" + client.getCompanysName());
            return clientDao.insert(client);
        }catch (ClientDAOException  e){
            e.printStackTrace();
            throw e ;
        }
    }

    @Override
    public Client update(ClientUpdateDTO dto) throws ClientDAOException {
        if (dto == null) return  null ;
        Client client ;

        try {
            client = map(dto);
            if (clientDao.getByVatNo(client.getVatNo()) == null){
                throw new ClientNotFoundException(client);
            }
            return clientDao.update(client);
        }catch (ClientNotFoundException | ClientDAOException e){
            e.printStackTrace();
            return null ;
        }
    }

    @Override
    public void delete(Long vatNo) throws ClientDAOException, ClientNotFoundException {
        Client client ;

        try {
            client = clientDao.getByVatNo(vatNo);
            if (client == null){
                throw new ClientNotFoundException("Client with vat No "+ vatNo +"not found");
            }
            clientDao.delete(vatNo);
        }catch (ClientDAOException |ClientNotFoundException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Client> getByCompanyName(String companyName) throws ClientNotFoundException {
        List<Client> clients ;
        try {
            clients = clientDao.getByCompanyName(companyName);
            return clients ;
        }catch (ClientDAOException e){
            e.printStackTrace();
            return  null ;
        }

    }

    @Override
    public Client getClientByVatNo(long vatNo) throws ClientDAOException, ClientNotFoundException {
        Client client ;

        try {
            client = clientDao.getByVatNo(vatNo);
            if (client == null){
                throw  new ClientNotFoundException("Client with Vat No "+ vatNo +"not found");
            }
            return client ;
        }catch (ClientDAOException |ClientNotFoundException e){
            e.printStackTrace();
            return  null ;
        }

    }

    private Client map (ClientInsertDTO dto){
        return new Client(null, dto.getCompanysName(), dto.getVatNo()
                ,dto.getStreet(),dto.getStreetNo(),dto.getCity(),dto.getZipCode(),dto.getCountry(), dto.getPaymentMethod(), dto.getAccountingCategory());
    }

    private Client map(ClientUpdateDTO dto) {
        return  new Client(dto.getId(), dto.getCompanysName(), dto.getVatNo(),dto.getStreet(), dto.getStreetNo(), dto.getCity(),dto.getZipCode(),dto.getCountry(), dto.getPaymentMethod(), dto.getAccountingCategory());
    }
}
