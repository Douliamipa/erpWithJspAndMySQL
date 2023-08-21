package gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Implementations;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.IUserDAO;

public class UserDAOImpl implements IUserDAO {
    @Override
    public boolean isUserValid(String username, String password) {
        return  true ;
    }
}
