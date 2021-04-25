package com.fomularioquejasumg.form;

import com.fomularioquejasumg.Address.Address;
import com.fomularioquejasumg.Address.AddressRepo;
import com.fomularioquejasumg.Complain.Complain;
import com.fomularioquejasumg.Complain.ComplainRepo;
import com.fomularioquejasumg.Contact.Contact;
import com.fomularioquejasumg.Contact.ContactRepo;
import com.fomularioquejasumg.DepMuni.DepoMuni;
import com.fomularioquejasumg.Departamento.Departamento;
import com.fomularioquejasumg.Departamento.DepartamentoRepo;
import com.fomularioquejasumg.Municipio.Municipio;
import com.fomularioquejasumg.Municipio.MunicipioRepo;
import com.fomularioquejasumg.Provider.Provider;
import com.fomularioquejasumg.Provider.ProviderRepo;
import com.fomularioquejasumg.ReporteFecha.Region;
import com.fomularioquejasumg.ReporteFecha.RegionRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

@Service
public class FormService {

    Logger logger = Logger.getLogger((getClass().getName()));

    private AddressRepo addressRepo;
    private ContactRepo contactRepo;
    private ProviderRepo providerRepo;
    private ComplainRepo complainRepo;
    private RegionRepo regionRepo;

    private DepartamentoRepo departamentoRepo;
    private MunicipioRepo municipioRepo;

    public FormService(AddressRepo addressRepo, ContactRepo contactRepo, ProviderRepo providerRepo,
                       ComplainRepo complainRepo, RegionRepo regionRepo, DepartamentoRepo departamentoRepo,
                       MunicipioRepo municipioRepo) {
        this.addressRepo = addressRepo;
        this.contactRepo = contactRepo;
        this.providerRepo = providerRepo;
        this.complainRepo = complainRepo;
        this.regionRepo = regionRepo;
        this.departamentoRepo = departamentoRepo;
        this.municipioRepo = municipioRepo;
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

    public Integer saveComplain(String complainText, String requestText, Integer idProvider, Date complainDate, String invoiceId, Integer idSede) {
        Complain complain = new Complain(complainText, requestText, idProvider, complainDate, invoiceId, idSede);
        return complainRepo.save(complain).getId();
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

        Integer complainId = saveComplain(
                    forma.getComplainText(),
                    forma.getRequestText(),
                    providerId,
                    forma.getComplainDate(),
                    forma.getInvoiceId(),
                    forma.getIdSede()
                );

        ArrayList<Integer> returList  = new ArrayList<>();
        returList.add(addressId);
        returList.add(contactId);
        returList.add(providerId);
        returList.add(complainId);

        return returList;
    }

    public Iterable<Region> getReportOne(String from, String to) {

        try {

           return regionRepo.getReportByDates(from, to);

        } catch (Exception e) {
            logger.severe(e.getMessage());
            return null;
        }

    }

    public ArrayList<DepoMuni> getDepList() {
        try {

            Iterable<Departamento> depList = departamentoRepo.findAll();
            Iterable<Municipio> muniList = municipioRepo.findAll();


            return createDepoMuniList(depList, muniList);

        } catch (Exception e) {
            logger.severe(e.getMessage());
            return null;
        }
    }

    public ArrayList<DepoMuni> createDepoMuniList(Iterable<Departamento> depList,  Iterable<Municipio> muniList) {



        ArrayList<DepoMuni> depoMuniList = new ArrayList<>();

        depList.forEach(departamento -> {
            Integer depId = departamento.getId();

            // get Municipios
            ArrayList<Municipio> municipiosArray = new ArrayList<>();

            muniList.forEach(municipio -> {
                if (municipio.getIdDep() == depId) {
                    municipiosArray.add(municipio);
                }
            });

            DepoMuni depoMuni = new DepoMuni(departamento, municipiosArray);
            depoMuniList.add(depoMuni);

        });

        return depoMuniList;
    }

}























