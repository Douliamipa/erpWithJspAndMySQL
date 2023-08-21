package gr.aueb.cf.erpProjectWithSQLAndJsp.service.util;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class DButil {
    private static BasicDataSource ds = new BasicDataSource() ;
    private static Connection connection ;

    static {
        ds.setUrl("jdbc:mysql://localhost:3306/erpdb?serverTimezone=UTC");
        ds.setUsername("user1DB-ERP");
        ds.setPassword("123456");
        ds.setInitialSize(8);
        ds.setMaxIdle(10);
        ds.setMaxTotal(32);
        ds.setMinIdle(8);

    }

    public static Connection getConnection () throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection  = ds.getConnection();
            return connection ;
        }catch (ClassNotFoundException e ){
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(){
        try {
            if (connection!=null)connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void beginTransaction(){
        try {
            connection.setAutoCommit(false);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void commitTransaction(){
        try {
            connection.commit();
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }

    public static  void rollbackTransaction(){
        try {
            connection.rollback();
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }
}
