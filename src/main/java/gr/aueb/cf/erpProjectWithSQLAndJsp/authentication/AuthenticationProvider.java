package gr.aueb.cf.erpProjectWithSQLAndJsp.authentication;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.IUserDAO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Implementations.UserDAOImpl;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.UserLoginDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.user;
public class AuthenticationProvider {
    private static final IUserDAO userDAO = new UserDAOImpl();

    private AuthenticationProvider() {}

    public static boolean authenticate(UserLoginDTO userLoginDTO) {
        //System.out.println("authenticate" + userLoginDTO.getUsername());
        if (userLoginDTO.getUsername().equals("test@aueb.gr")) {
            return false;
        }
        return userDAO.isUserValid(userLoginDTO.getUsername(), userLoginDTO.getPassword());
    }
}
