package gr.aueb.cf.erpProjectWithSQLAndJsp.service.Interfaces;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.SupplierDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.supplierDTO.SupplierInsertDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.supplierDTO.SupplierUpdateDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Supplier;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.exceptions.SupplierNotFoundException;

import java.util.List;

public interface ISupplierService {
    Supplier insertSupplier (SupplierInsertDTO dto)throws SupplierDAOException ;

    Supplier updateSupplier (SupplierUpdateDTO dto) throws SupplierDAOException , SupplierNotFoundException ;

    void deleteSupplier(Long vatNo) throws  SupplierDAOException,SupplierNotFoundException;

    List<Supplier> getByCompanyName(String companyName) throws  SupplierNotFoundException ;

    Supplier getSupplierByVatNo (long Vatno) throws SupplierDAOException,SupplierNotFoundException ;

}
