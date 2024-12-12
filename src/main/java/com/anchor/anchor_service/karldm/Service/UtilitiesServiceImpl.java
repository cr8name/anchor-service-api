package com.anchor.anchor_service.karldm.Service;

import com.anchor.anchor_service.karldm.Entity.Billing;
import com.anchor.anchor_service.karldm.Entity.Customer;
import com.anchor.anchor_service.karldm.Entity.Utilities;
import com.anchor.anchor_service.karldm.Repository.BillingRepository;
import com.anchor.anchor_service.karldm.Repository.UtilitiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilitiesServiceImpl implements  UtilitiesService {

    private final UtilitiesRepository utilitiesRepository;


    public UtilitiesServiceImpl(UtilitiesRepository utilitiesRepository) {
        this.utilitiesRepository = utilitiesRepository;

    }

    public List<Utilities> getUtilities() {
        return utilitiesRepository.findAll();
    }

    public void updateUtilities(List<Utilities> utilities) {
        utilitiesRepository.saveAll(utilities);
    }


    public void updateUtily(Utilities utility) {
        utilitiesRepository.save(utility);
    }

    public List<Utilities> DTOLatestUtilities() {
        return utilitiesRepository.DTOLatestUtilities();
    }


    public void deleteUtilities(int utilities_id) {
        boolean exist = utilitiesRepository.existsById(utilities_id);
        if (!exist) {
            throw new IllegalStateException("Utilities ID " + utilities_id + " does not exist");
        }
        utilitiesRepository.deleteById(utilities_id);
    }


    public Optional<Utilities> updateUtility(int utilities_id, Utilities utilitiesDetails) {
        return utilitiesRepository.findById(utilities_id).map(existingUtility -> {
            existingUtility.setUtilities_id(utilitiesDetails.getUtilities_id());
            existingUtility.setCustomer_id(utilitiesDetails.getCustomer_id());
            existingUtility.setBilling_date(utilitiesDetails.getBilling_date());
            existingUtility.setElectric_rate(utilitiesDetails.getElectric_rate());
            existingUtility.setWater_rate(utilitiesDetails.getWater_rate());
            existingUtility.setRent_rate(utilitiesDetails.getRent_rate());
            existingUtility.setEprev_read(utilitiesDetails.getEprev_read());
            existingUtility.setEcurr_read(utilitiesDetails.getEcurr_read());
            existingUtility.setWprev_read(utilitiesDetails.getWprev_read());
            existingUtility.setWcurr_read(utilitiesDetails.getWcurr_read());


            return utilitiesRepository.save(existingUtility);
        });


    }


}





