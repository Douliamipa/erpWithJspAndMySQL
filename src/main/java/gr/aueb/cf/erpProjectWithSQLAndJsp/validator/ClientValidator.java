package gr.aueb.cf.erpProjectWithSQLAndJsp.validator;

import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.clientDTO.ClientInsertDTO;
import gr.aueb.cf.erpProjectWithSQLAndJsp.dto.clientDTO.ClientUpdateDTO;

import java.util.HashMap;
import java.util.Map;

public class ClientValidator {
    public static Map<String, String> validate(ClientInsertDTO dto){
        Map<String,String> errors = new HashMap<>();
        if (String.valueOf(dto.getVatNo()).length() < 9 ||String.valueOf(dto.getVatNo()).length() > 9){
            errors.put("VatNo", "length");
        }

        if (dto.getCountry().equals("Greece")  && !dto.getAccountingCategory().equals("Domestic client")){
            errors.put("Accounting Categoty"," Domestic client");
        }

        return  errors ;
    }

    public static Map<String,String> validate(ClientUpdateDTO dto){
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
