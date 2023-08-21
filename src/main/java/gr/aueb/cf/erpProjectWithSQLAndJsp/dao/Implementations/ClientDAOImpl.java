package gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Implementations;


import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.IClientDao;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.ClientDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements IClientDao {
    @Override
    public Client insert(Client client) throws ClientDAOException {
        String sql = "INSERT INTO CLIENTS(COMPANY_NAME,VAT_NO,CITY," +
                "STREET,STREET_NO,ZIPCODE,COUNTRY,PAYMENT_METHOD,ACCOUNTING_CATEGORY) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection connection = DButil.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);){
            String companyName = client.getCompanysName();
            long vatNo = client.getVatNo();
            String city = client.getCity();
            String street = client.getStreet();
            String streetNo = client.getStreetNo();
            int zipcode = client.getZipCode();
            String country = client.getCountry();
            String paymentMethod = client.getPaymentMethod();
            String accountingCategory = client.getAccountingCategory();

            ps.setString(1,companyName);
            ps.setLong(2,vatNo);
            ps.setString(3,city);
            ps.setString(4,street);
            ps.setString(5,streetNo);
            ps.setInt(6,zipcode);
            ps.setString(7,country);
            ps.setString(8,paymentMethod);
            ps.setString(9,accountingCategory);

            DButil.beginTransaction();
            ps.executeUpdate();
            DButil.commitTransaction();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            int generatedId =0 ;
            if (generatedKeys.next()){
                generatedId = generatedKeys.getInt(1);
            }

            client.setId(generatedId);
            generatedKeys.close();



        }catch (SQLException e){
            DButil.rollbackTransaction();
        }
        return client ;
    }

    @Override
    public Client update(Client client) throws ClientDAOException {
        String sql= "UPDATE CLIENTS SET COMPANY_NAME = ?,VAT_NO = ? ,CITY = ? ,STREET = ? ,STREET_NO = ? ,ZIPCODE = ? " +
                ",COUNTRY = ? ,PAYMENT_METHOD = ? ,ACCOUNTING_CATEGORY = ?  WHERE VAT_NO = ?";

        try (Connection connection = DButil.getConnection();
        PreparedStatement ps  = connection.prepareStatement(sql);){

//            if (columnName.equals("CompanysName")) {
//                ps.setString(1,client.getCompanysName());
//            }else if (columnName.equals("street")){
//                ps.setString(1, client.getCity());
//            } else if (columnName.equals("streetNo")) {
//                ps.setString(1,client.getStreetNo());
//            } else if (columnName.equals("city")) {
//                ps.setString(1,client.getCity());
//            } else if (columnName.equals("zipCode")) {
//                ps.setInt(1,client.getZipCode());
//            } else if (columnName.equals("country")) {
//                ps.setString(1, client.getCountry());
//            } else if (columnName.equals("paymentMethod")) {
//                ps.setString(1,client.getPaymentMethod());
//            } else if (columnName.equals("accountingCategory")) {
//                ps.setString(1, client.getAccountingCategory());
//
//            }

            long vatNo = client.getVatNo();
            String city = client.getCity();
            String street = client.getStreet();
            String streetNo = client.getStreetNo();
            int zipcode = client.getZipCode();
            String country = client.getCountry();
            String paymentMethod = client.getPaymentMethod();
            String accountingCategory = client.getAccountingCategory();
            String companyName = client.getCompanysName();

            ps.setString(1,companyName);
            ps.setLong(2,vatNo);
            ps.setString(3,city);
            ps.setString(4,street);
            ps.setString(5,streetNo);
            ps.setInt(6,zipcode);
            ps.setString(7,country);
            ps.setString(8,paymentMethod);
            ps.setString(9,accountingCategory);
            ps.setLong(10,client.getVatNo());



            DButil.beginTransaction();
            ps.executeUpdate();
            DButil.commitTransaction();

            return client ;
        }catch (SQLException e ){
            DButil.rollbackTransaction();
            throw  new ClientDAOException("SQL Error in Client with VAT NO " +client.getVatNo() +"Update");
        }
    }

    @Override
    public void delete(Long vatNo) throws ClientDAOException {
        String sql = "DELETE FROM CLIENTS WHERE VAT_NO = ?";

        try (Connection connection = DButil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){


            ps.setLong(1,vatNo );

            DButil.beginTransaction();
            ps.executeUpdate();
            DButil.commitTransaction();
        }catch (SQLException e){
            DButil.rollbackTransaction();
            throw new ClientDAOException("SQL Error in client deletion with VAT NO" + vatNo +"");
        }
    }

    @Override
    public List<Client> getByCompanyName(String companyName) throws ClientDAOException {
        String sql = "SELECT * FROM CLIENTS WHERE COMPANY_NAME LIKE ?";
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DButil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);){
            ResultSet rs ;
            ps.setString(1,companyName+ "%");
            rs= ps.executeQuery();

            if (rs.next()){
                Client client = new Client(rs.getInt("ID"),rs.getString("COMPANY_NAME"),rs.getLong("VAT_NO"),rs.getString("STREET")
                ,rs.getString("STREET_NO"),rs.getString("CITY"),rs.getInt("ZIPCODE"),rs.getString("COUNTRY"),rs.getString("PAYMENT_METHOD"),
                        rs.getString("ACCOUNTING_CATEGORY"));
                clients.add(client);
            }

        }catch (SQLException e ){
            e.printStackTrace();
        }
        return clients ;
    }

    @Override
    public Client getByVatNo(long vatNo) throws ClientDAOException {
        Client client = null ;
        String sql = "SELECT * FROM CLIENTS WHERE VAT_NO = ?";
        try (Connection connection = DButil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);){
            ResultSet rs ;
            ps.setLong(1,vatNo);
            rs = ps.executeQuery();

            if (rs.next()){
                client = new Client(rs.getInt("ID"),rs.getString("COMPANY_NAME"),rs.getLong("VAT_NO"),rs.getString("STREET")
                        ,rs.getString("STREET_NO"),rs.getString("CITY"),rs.getInt("ZIPCODE"),rs.getString("COUNTRY"),rs.getString("PAYMENT_METHOD"),
                        rs.getString("ACCOUNTING_CATEGORY"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return  client ;
    }
}
