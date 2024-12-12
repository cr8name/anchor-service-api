package com.anchor.anchor_service.karldm.Controller;


import com.anchor.anchor_service.karldm.Entity.Billing;

import com.anchor.anchor_service.karldm.Entity.Utilities;
import com.anchor.anchor_service.karldm.Service.BillingService;
import com.anchor.anchor_service.karldm.Service.UtilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping
@CrossOrigin(maxAge = 3360,origins = "http://localhost:4200")
public class BillingController {

    @Autowired
    private final BillingService billingService;
    private final UtilitiesService utilitiesService;


    public BillingController(BillingService billingService, UtilitiesService utilitiesService) {
        this.billingService = billingService;
        this.utilitiesService = utilitiesService;
    }
    //ForAngularBillingPage
    @GetMapping("api/billing")
    public List<Billing> getBilling(){
        return billingService.getBilling();
    }

    //forAngularHomePageBilling
    @GetMapping("api/dtolatestbill")
    public List<Billing> dtobill(){
        return billingService.DTOLatestBilling();
    }

    //ForAngularHomePage
    @GetMapping("api/lbill")
    public List<String> getlbill(){
        return billingService.findlatestElecWaterbill();
    }

    @DeleteMapping(path="/api/deletebilling/{billing_id}")
    public void deleteFromUtil(@PathVariable("billing_id")int billing_id){
        billingService.deleteFromUtil(billing_id);
        utilitiesService.deleteUtilities(billing_id);
    }

    @PutMapping(path ="api/updatebillingfromutil/{billing_id}")
    public ResponseEntity<String> updateBillingFromUtil(@PathVariable("billing_id") int billing_id, @RequestBody Billing billing_details){
        return billingService.updateBillingFromUtil(billing_id,billing_details).map(updateBilling -> ResponseEntity.ok("Billing updated successfully."))
                .orElse(ResponseEntity.notFound().build());

    }


}
