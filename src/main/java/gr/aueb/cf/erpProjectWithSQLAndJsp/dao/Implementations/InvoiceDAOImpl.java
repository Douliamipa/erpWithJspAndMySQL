package gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Implementations;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.IInvoiceDAO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.InvoiceDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Client;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Invoice;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAOImpl implements IInvoiceDAO {
    @Override
    public Invoice insert(Invoice invoice) throws InvoiceDAOException {
      String sql ="INSERT INTO INVOICES(INVOICE_NO,CLIENTS_VAT_NO,DATE,VAT_STATUS,PAYMENT_METHOD," +
              "VAT_EXCEPTION,AMOUNT,VAT_PERCENTAGE,TOTAL_AMOUNT) VALUES(?,?,?,?,?,?,?,?,?)";

      try (Connection connection = DButil.getConnection();
           PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){

          String invoiceNo = invoice.getInvoiceNo();
          Long clientsVatNo = invoice.getClient().getVatNo();
          java.sql.Date date = invoice.getDate();
          String vatStatus = invoice.getClient().getAccountingCategory();
          String paymentMethod = invoice.getPaymentMethod();
          String vatException = invoice.getVatExemption();
          double amount = invoice.getAmount();
          double vatPercentage = invoice.getVatPercentage();
          double totalAmount ;
          if (vatPercentage != 0){
              totalAmount = amount + vatPercentage*amount ;
          }else {
              totalAmount = amount ;
          }
          ps.setString(1,invoiceNo);
          ps.setLong(2,clientsVatNo);
          ps.setDate(3,date);
          ps.setString(4,vatStatus);
          ps.setString(5,paymentMethod);
          ps.setString(6,vatException);
          ps.setDouble(7,amount);
          ps.setDouble(8,vatPercentage);
          ps.setDouble(9,totalAmount);

          DButil.beginTransaction();
          ps.executeUpdate();
          DButil.commitTransaction();

          ResultSet generatedKeys = ps.getGeneratedKeys();
          int generatedId =0 ;
          if (generatedKeys.next()){
              generatedId = generatedKeys.getInt(1);
          }

          invoice.setId(generatedId);
          generatedKeys.close();


      }catch (SQLException e){
          DButil.rollbackTransaction();
      }
      return invoice;
    }

    @Override
    public Invoice update(Invoice invoice) throws InvoiceDAOException {
        String sql = "UPDATE INVOICES  SET PAYMENT_METHOD = ? WHERE CLIRNTS_VAT_NO  = ? AND INVOICE_NO = ?" ;

        try (Connection connection = DButil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){

            String paymentMethod = invoice.getPaymentMethod();

            ps.setString(1,paymentMethod);
            ps.setLong(2,invoice.getClient().getVatNo());
            ps.setString(3,invoice.getInvoiceNo());

            DButil.beginTransaction();
            ps.executeUpdate();
            DButil.commitTransaction();

            return invoice ;

        }catch (SQLException e ){
            DButil.rollbackTransaction();
            throw  new InvoiceDAOException("SQL Error in Invoice with invoice number" + invoice.getInvoiceNo() + "update");
        }
    }

    @Override
    public List<Invoice> getInvoicesByCLientName(Client client) throws InvoiceDAOException {
        String sql = "SELECT * FROM INVOICES WHERE CLIENTS_VAT_NO = ?" ;
        List<Invoice> invoices= new ArrayList<>() ;

        try (Connection connection = DButil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){

            ResultSet rs ;
            ps.setLong(1,client.getVatNo());
            DButil.beginTransaction();
            rs= ps.executeQuery();
            DButil.commitTransaction();

            if (rs.next()){


                Invoice invoice =new Invoice(rs.getLong("ID"),rs.getString("INVOICE_NO"),
                       getClientByVatNo(rs.getLong("CLIENTS_VAT_NO")),rs.getDate("DATE")
                ,rs.getString("VAT_STATUS"),rs.getString("PAYMENT_METHOD"),
                        rs.getString("VAT_EXCEPTION"),rs.getDouble("AMOUNT"), rs.getDouble("VAT_PERCENTAGE"),
                        rs.getDouble("TOTAL_AMOUNT"));
                invoices.add(invoice);
            }

        }catch (SQLException e ){
            e.printStackTrace();
        }
        return  invoices ;
    }

    @Override
    public Invoice getByInvoiceNo(String invoiceNo, Client client) throws InvoiceDAOException {
       Invoice invoice = null ;

       String sql = "SELECT * FROM INVOICES WHERE  INVOICE_NO = ?  AND  CLIENTS_VAT_NO = ?";

       try (Connection connection = DButil.getConnection();
       PreparedStatement ps = connection.prepareStatement(sql)){
           ResultSet rs ;
           DButil.beginTransaction();
           rs = ps.executeQuery();
           DButil.commitTransaction();
           if (rs.next()){
               invoice = new Invoice(rs.getLong("ID"),rs.getString("INVOICE_NO"),
                       getClientByVatNo(rs.getLong("CLIENTS_VAT_NO")),rs.getDate("DATE")
                       ,rs.getString("VAT_STATUS"),rs.getString("PAYMENT_METHOD"),
                       rs.getString("VAT_EXCEPTION"),rs.getDouble("AMOUNT"), rs.getDouble("VAT_PERCENTAGE"),
                       rs.getDouble("TOTAL_AMOUNT"));
           }

       }catch (SQLException e ){
           DButil.rollbackTransaction();
       }
       return invoice ;
    }

    public Client getClientByVatNo(Long vatNo){
        String sql1= "SELECT * FROM CLIENTS WHERE VAT_NO = ?";

        try (Connection connection=DButil.getConnection();
                PreparedStatement ps1 = connection.prepareStatement(sql1)){
            ps1.setLong(1,vatNo);
            ResultSet rs1 ;
            DButil.beginTransaction();
            rs1 = ps1.executeQuery();
            DButil.commitTransaction();

            if (rs1.next()){
                Client client1 = new Client(rs1.getInt("ID"),rs1.getString("COMPANY_NAME"),rs1.getLong("VAT_NO"),rs1.getString("STREET")
                        ,rs1.getString("STREET_NO"),rs1.getString("CITY"),rs1.getInt("ZIPCODE"),rs1.getString("COUNTRY"),rs1.getString("PAYMENT_METHOD"),
                        rs1.getString("ACCOUNTING_CATEGORY"));
                return client1 ;
            }


        }catch (SQLException e1){
            DButil.rollbackTransaction();

        }
        return null ;
    }
}
