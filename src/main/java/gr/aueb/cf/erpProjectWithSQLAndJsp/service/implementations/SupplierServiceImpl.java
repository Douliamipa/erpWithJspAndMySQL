package gr.aueb.cf.erpProjectWithSQLAndJsp.service.implementations;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.Interfaces.ISupplierDAO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dao.exceptions.SupplierDAOException;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.supplierDTO.SupplierInsertDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.supplierDTO.SupplierUpdateDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.model.Supplier;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.Interfaces.ISupplierService;
import gr.aueb.cf.erpProjectWithSQLAndJsp.service.exceptions.SupplierNotFoundException;

import java.util.List;

public class SupplierServiceImpl implements ISupplierService {
    private final ISupplierDAO supplierDAO ;

    public  SupplierServiceImpl(ISupplierDAO supplierDAO){this.supplierDAO = supplierDAO ;}
    @Override
    public Supplier insertSupplier(SupplierInsertDTO dto) throws SupplierDAOException {
        if (dto == null) return  null ;

        Supplier supplier ;
        try {
            supplier= map(dto);
            System.out.println("Service returned Supplier :"+ supplier.getCompanysName());
            return  supplierDAO.insert(supplier);
        }catch (SupplierDAOException e){
            e.printStackTrace();
            throw e ;
        }


    }

    @Override
    public Supplier updateSupplier(SupplierUpdateDTO dto) throws SupplierDAOException, SupplierNotFoundException {
        if (dto == null) return  null ;
        Supplier supplier ;
        try {
            supplier = map(dto);
            if (supplierDAO.getByVatNo(supplier.getVatNo())==null){
                throw  new SupplierNotFoundException(supplier);
            }
            return  supplierDAO.update(supplier);
        }catch (SupplierDAOException | SupplierNotFoundException e){
            e.printStackTrace();
            throw e ;
        }
    }

    @Override
    public void deleteSupplier(Long vatNo) throws SupplierDAOException, SupplierNotFoundException {
        Supplier supplier;

        try {
            supplier = supplierDAO.getByVatNo(vatNo);
            if (supplier == null){
                throw  new SupplierNotFoundException("supplier with vat no " + vatNo + "not dound");
            }
            supplierDAO.delete(vatNo);
        }catch (SupplierDAOException | SupplierNotFoundException e){
            e.printStackTrace();
            throw  e ;
        }

    }

    @Override
    public List<Supplier> getByCompanyName(String companyName) throws SupplierNotFoundException {
       List<Supplier> suppliers;

       try {
           suppliers = supplierDAO.getByCompanyName(companyName);
           return suppliers ;
       }catch (SupplierDAOException e){
           e.printStackTrace();
           return  null;
       }

    }

    @Override
    public Supplier getSupplierByVatNo(long vatNo) throws SupplierDAOException, SupplierNotFoundException {
        Supplier supplier ;
        try {
            supplier = supplierDAO.getByVatNo(vatNo);
            if (supplier == null){
                throw new SupplierNotFoundException("Supplier with Vat No "+ vatNo + "not found");
            }
        }catch (SupplierDAOException |SupplierNotFoundException e){
            e.printStackTrace();
            throw e ;

        }
        return supplier ;
    }

    private Supplier map(SupplierInsertDTO dto){
        return new Supplier(null, dto.getCompanysName(), dto.getVatNo()
            ,dto.getStreet(),dto.getStreetNo(),dto.getCity(),dto.getZipCode(),dto.getCountry(), dto.getPaymentMethod(), dto.getAccountingCategory());
    }

    private Supplier map(SupplierUpdateDTO dto){
        return  new Supplier(dto.getId(), dto.getCompanysName(), dto.getVatNo(),dto.getStreet(), dto.getStreetNo(), dto.getCity(),dto.getZipCode(),dto.getCountry(), dto.getPaymentMethod(), dto.getAccountingCategory());
    }
}
