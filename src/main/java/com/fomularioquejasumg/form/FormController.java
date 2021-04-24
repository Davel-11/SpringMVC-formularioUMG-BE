package com.fomularioquejasumg.form;


import com.fomularioquejasumg.Address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "api/quejaumg", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormController {

    @Autowired
    FormService formService;

    @PostMapping("/form")
    public ResponseEntity getFormData(@RequestBody Address address) {
        return new ResponseEntity( formService.saveAddress(address.getIdMunicipio(), address.getAddress()), HttpStatus.OK );
    }


}
