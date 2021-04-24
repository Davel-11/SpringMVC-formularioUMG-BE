package com.fomularioquejasumg.form;

import com.fomularioquejasumg.Address.Address;
import com.fomularioquejasumg.Address.AddressRepo;
import com.fomularioquejasumg.Contact.Contact;
import com.fomularioquejasumg.Contact.ContactRepo;
import com.fomularioquejasumg.Provider.Provider;
import com.fomularioquejasumg.Provider.ProviderRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

@Service
public class FormService {

    Logger logger = Logger.getLogger((getClass().getName()));

    private AddressRepo addressRepo;
    private ContactRepo contactRepo;
    private ProviderRepo providerRepo;

    public FormService(AddressRepo addressRepo, ContactRepo contactRepo, ProviderRepo providerRepo) {
        this.addressRepo = addressRepo;
        this.contactRepo = contactRepo;
        this.providerRepo = providerRepo;
    }

    public Integer saveAddress(Integer idMunicipio, String iAddress) {
        Address address = new Address();
        address.setIdMunicipio(idMunicipio);
        address.setAddress(iAddress);

        Address newAddress = addressRepo.save(address);
        return newAddress.getId();
    }

    public Integer saveContact(Integer officeNumber, String emailAddres) {
        try {
            Contact contact = new Contact(officeNumber, emailAddres);
            return contactRepo.save(contact).getId();
        } catch (Exception e) {
            logger.severe(e.getMessage());
            return -1;
        }
    }

    public Integer saveProvider(String socialReason, String nit, Integer idContact, Integer idAddress, String name) {
        try {
            Provider provider = new Provider( socialReason, nit, idContact, idAddress, name );
            return providerRepo.save(provider).getId();
        } catch (Exception e) {
            logger.severe(e.getMessage());
            return -1;
        }
    }

    public ArrayList<Integer> saveQueja(Forma forma) {


        Integer addressId = saveAddress(forma.getIdMunicipio(), forma.getAddress());
        Integer contactId = saveContact(forma.getOfficeNumber(), forma.getEmailAddress());

        Integer providerId = saveProvider(
                forma.getSocialReason(),
                forma.getNit(),
                contactId,
                addressId,
                forma.getName()
        );

        ArrayList<Integer> returList  = new ArrayList<>();
        returList.add(addressId);
        returList.add(contactId);
        returList.add(providerId);

        return returList;
    }
}























