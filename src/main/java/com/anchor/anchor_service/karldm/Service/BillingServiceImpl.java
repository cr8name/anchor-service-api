package com.anchor.anchor_service.karldm.Service;

import com.anchor.anchor_service.karldm.Entity.Billing;
import com.anchor.anchor_service.karldm.Entity.Utilities;
import com.anchor.anchor_service.karldm.Repository.BillingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BillingServiceImpl implements BillingService{

    private final BillingRepository billingRepository;

    public BillingServiceImpl(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    //display all billing
   public List<Billing> getBilling(){
        return billingRepository.findAll();
   }

   public List<String> findlatestElecWaterbill(){

       return billingRepository.findLatestElecWaterReadOnly();
   }

    public List<Billing> DTOLatestBilling(){
        return billingRepository.DTOLatestBilling();
    }

    public void deleteFromUtil(int billing_id){
        boolean exist = billingRepository.existsById(billing_id);
        if(!exist){
            throw new IllegalStateException("Billing ID " + billing_id +"does not exist");
        }
        billingRepository.deleteById(billing_id);
    }

    public void addBillingFromUtil(List<Utilities> utilities){
        for(Utilities util:utilities){
            Billing billing = new Billing(
                    util.getUtilities_id(),
                    util.getUtilities_id(),
                    util.getCustomer_id(),
                    util.getTotal_amount(),
                    util.getRent_rate(),
                    util.getElectric_bill(),
                    util.getWater_bill(),
                    util.getBilling_date()
            );
            billingRepository.save(billing);
        }

    }

    //Adding only one billing inside angular
    public void addOneBillingFromUtil(Utilities util){

            Billing billing = new Billing(
                    util.getUtilities_id(),
                    util.getUtilities_id(),
                    util.getCustomer_id(),
                    util.getTotal_amount(),
                    util.getRent_rate(),
                    util.getElectric_bill(),
                    util.getWater_bill(),
                    LocalDate.now()
            );
            billingRepository.save(billing);
        }


    public Optional<Billing> updateBillingFromUtil(int billing_id, Billing billingDetails) {
        return billingRepository.findById(billing_id).map(existingBilling -> {
            existingBilling.setElectric_bill(billingDetails.getElectric_bill());
            existingBilling.setWater_bill(billingDetails.getWater_bill());
            existingBilling.setTotal_amount(billingDetails.getTotal_amount());
            existingBilling.setRent_amount(billingDetails.getRent_amount());
            return billingRepository.save(existingBilling);
        });

    }



}
