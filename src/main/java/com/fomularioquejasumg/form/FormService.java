package com.fomularioquejasumg.form;

import com.fomularioquejasumg.Address.Address;
import com.fomularioquejasumg.Address.AddressRepo;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class FormService {

    Logger logger = Logger.getLogger((getClass().getName()));

    private AddressRepo addressRepo;

    public FormService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public Integer saveAddress(Integer idMunicipio, String iAddress) {
        Address address = new Address();
        address.setIdMunicipio(idMunicipio);
        address.setAddress(iAddress);

        Address newAddress = addressRepo.save(address);

        return newAddress.getId();
    }
}
