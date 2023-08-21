package gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.SupplierDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Supplier;

import java.util.List;

public interface ISupplierDAO {
    Supplier insert (Supplier supplier) throws SupplierDAOException ;

    Supplier update(Supplier supplier) throws SupplierDAOException;

    void delete (Long vatNo) throws  SupplierDAOException ;

    List<Supplier> getByCompanyName (String companyName) throws SupplierDAOException ;

    Supplier getByVatNo (long vatNo) throws  SupplierDAOException ;
}
