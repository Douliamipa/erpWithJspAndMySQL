package gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Implementations;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.ISupplierDAO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.SupplierDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Supplier;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements ISupplierDAO {
    @Override
    public Supplier insert(Supplier supplier) throws SupplierDAOException {
        String sql = "Insert INTO SUPPLIERS (COMPANY_NAME,VAT_NO,CITY, " +
                "STREET,ZIPCODE,COUNTRY,PAYMENT_METHOD,ACCOUNTING_CATEGORY) VALUES(?,?,?,?,?,?,?,?)";

        try (Connection connection = DButil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)){

            String companyName = supplier.getCompanysName();
            long vatNo = supplier.getVatNo();
            String city = supplier.getCity();
            String street = supplier.getStreet();
            int zipcode = supplier.getZipCode();
            String country = supplier.getCountry();
            String paymentMethod = supplier.getPaymentMethod();
            String accountingCategory = supplier.getAccountingCategory();

            ps.setString(1,companyName);
            ps.setLong(2,vatNo);
            ps.setString(3,city);
            ps.setString(4,street);
            ps.setInt(5,zipcode);
            ps.setString(6,country);
            ps.setString(7,paymentMethod);
            ps.setString(8,accountingCategory);

            DButil.beginTransaction();
            ps.executeUpdate();
            DButil.commitTransaction();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            int generatedId =0 ;
            if (generatedKeys.next()){
                generatedId = generatedKeys.getInt(1);
            }

            supplier.setId(generatedId);
            generatedKeys.close();


        }catch (SQLException e ){
            DButil.rollbackTransaction();

        }
        return  supplier ;
    }

    @Override
    public Supplier update(Supplier supplier) throws SupplierDAOException {
        String sql= "UPDATE SUPPLIERS SET COMPANY_NAME = ?,VAT_NO = ? ,CITY = ? ,STREET = ? ,STREET_NO = ? ,ZIPCODE = ? " +
                ",COUNTRY = ? ,PAYMENT_METHOD = ? ,ACCOUNTING_CATEGORY = ?  WHERE VAT_NO = ?";

        try(Connection connection= DButil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {


//            if (columnName.equals("CompanysName")) {
//                ps.setString(1,supplier.getCompanysName());
//            }else if (columnName.equals("street")){
//                ps.setString(1, supplier.getCity());
//            } else if (columnName.equals("streetNo")) {
//                ps.setString(1,supplier.getStreetNo());
//            } else if (columnName.equals("city")) {
//                ps.setString(1,supplier.getCity());
//            } else if (columnName.equals("zipCode")) {
//                ps.setInt(1,supplier.getZipCode());
//            } else if (columnName.equals("country")) {
//                ps.setString(1, supplier.getCountry());
//            } else if (columnName.equals("paymentMethod")) {
//                ps.setString(1,supplier.getPaymentMethod());
//            } else if (columnName.equals("accountingCategory")) {
//                ps.setString(1, supplier.getAccountingCategory());
//
//            }

            long vatNo = supplier.getVatNo();
            String city = supplier.getCity();
            String street = supplier.getStreet();
            String streetNo = supplier.getStreetNo();
            int zipcode = supplier.getZipCode();
            String country = supplier.getCountry();
            String paymentMethod = supplier.getPaymentMethod();
            String accountingCategory = supplier.getAccountingCategory();
            String companyName = supplier.getCompanysName();

            ps.setString(1,companyName);
            ps.setLong(2,vatNo);
            ps.setString(3,city);
            ps.setString(4,street);
            ps.setString(5,streetNo);
            ps.setInt(6,zipcode);
            ps.setString(7,country);
            ps.setString(8,paymentMethod);
            ps.setString(9,accountingCategory);

            ps.setLong(10,supplier.getVatNo());

            DButil.beginTransaction();
            ps.executeUpdate();
            DButil.commitTransaction();

        }catch (SQLException e){
            DButil.rollbackTransaction();
            throw new SupplierDAOException("SQL Error in Client with VAT NO " + supplier.getVatNo() +"Update");
        }
        return supplier ;
    }

    @Override
    public void delete(Long vatNo) throws SupplierDAOException {
        String sql = "DELETE FROM SUPPLIERS WHERE VAT_NO = ?";

        try (Connection connection = DButil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setLong(1,vatNo);

            DButil.beginTransaction();
            ps.executeUpdate();
            DButil.commitTransaction();

        }catch (SQLException e){
            DButil.rollbackTransaction();
            throw new SupplierDAOException("SQL Error in client deletion with VAT NO" +vatNo+"");
        }

    }

    @Override
    public List<Supplier> getByCompanyName(String companyName) throws SupplierDAOException {
        String sql = "SELECT * FROM SUPPLIERS WHERE COMPANY_NAME LIKE ?";
        List<Supplier> suppliers = new ArrayList<>();

        try (Connection connection = DButil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){

            ResultSet rs ;
            ps.setString(1,companyName + "%");
            DButil.beginTransaction();
            rs = ps.executeQuery();
            DButil.commitTransaction();

            if (rs.next()){
                Supplier supplier = new Supplier(rs.getInt("ID"),rs.getString("COMPANY_NAME"),rs.getLong("VAT_NO"),rs.getString("STREET")
                        ,rs.getString("STREET_NO"),rs.getString("CITY"),rs.getInt("ZIPCODE"),rs.getString("COUNTRY"),rs.getString("PAYMENT_METHOD"),
                        rs.getString("ACCOUNTING_CATEGORY"));

                suppliers.add(supplier);
            }

        }catch (SQLException e ){
            DButil.rollbackTransaction();
        }
        return suppliers ;
    }

    @Override
    public Supplier getByVatNo(long vatNo) throws SupplierDAOException {
       Supplier supplier = null ;
       String sql = "SELECT * FROM SUPPLIERS WHERE VAT_NO = ?";

       try (Connection connection = DButil.getConnection();
       PreparedStatement ps = connection.prepareStatement(sql)){
           ResultSet rs ;
           ps.setLong(1, vatNo);
           DButil.beginTransaction();
           rs = ps.executeQuery();
           DButil.commitTransaction();

           if (rs.next()){
               supplier = new Supplier(rs.getInt("ID"),rs.getString("COMPANY_NAME"),rs.getLong("VAT_NO"),rs.getString("STREET")
                       ,rs.getString("STREET_NO"),rs.getString("CITY"),rs.getInt("ZIPCODE"),rs.getString("COUNTRY"),rs.getString("PAYMENT_METHOD"),
                       rs.getString("ACCOUNTING_CATEGORY"));
           }


       }catch (SQLException e ){
           DButil.rollbackTransaction();
       }
       return supplier ;
    }
}
