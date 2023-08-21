package gr.aueb.cf.erpProjectWithSQLAndJsp.validator;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.clientDTO.ClientInsertDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.clientDTO.ClientUpdateDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.supplierDTO.SupplierInsertDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.supplierDTO.SupplierUpdateDTO;

import java.util.HashMap;
import java.util.Map;

public class SupplierValidator {
    public static Map<String, String> validate(SupplierInsertDTO dto){
        Map<String,String> errors = new HashMap<>();
        if (String.valueOf(dto.getVatNo()).length() < 9 ||String.valueOf(dto.getVatNo()).length() > 9){
            errors.put("VatNo", "length");
        }

        if (dto.getCountry().equals("Greece")  && !dto.getAccountingCategory().equals("Domestic client")){
            errors.put("Accounting Categoty"," Domestic client");
        }

        return  errors ;
    }

    public static Map<String,String> validate(SupplierUpdateDTO dto){
        Map<String,String> errors = new HashMap<>();
        if (String.valueOf(dto.getVatNo()).length() < 9 ||String.valueOf(dto.getVatNo()).length() > 9){
            errors.put("VatNo", "length");
        }

        if (dto.getCountry().equals("Greece")  && !dto.getAccountingCategory().equals("Domestic client")){
            errors.put("Accounting Categoty"," Domestic client");
        }

        return  errors ;
    }
}
