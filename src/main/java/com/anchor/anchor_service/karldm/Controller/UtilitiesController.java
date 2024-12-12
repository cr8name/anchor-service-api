package com.anchor.anchor_service.karldm.Controller;

import com.anchor.anchor_service.karldm.Entity.Billing;
import com.anchor.anchor_service.karldm.Entity.Customer;
import com.anchor.anchor_service.karldm.Entity.Utilities;
import com.anchor.anchor_service.karldm.Repository.UtilitiesRepository;
import com.anchor.anchor_service.karldm.Service.BillingService;
import com.anchor.anchor_service.karldm.Service.UtilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(maxAge = 3360, origins = "http://localhost:4200")
@RestController
@RequestMapping
public class UtilitiesController {
    private final UtilitiesService utilitiesService;
    private final BillingService billingService;
    private final UtilitiesRepository utilitiesRepository;


    @Autowired
    public UtilitiesController(UtilitiesService utilitiesService, BillingService billingService, UtilitiesRepository utilitiesRepository) {
        this.utilitiesService = utilitiesService;
        this.billingService = billingService;
        this.utilitiesRepository = utilitiesRepository;
    }

    //For HTTPIE
    @GetMapping("api/getutilall")
    public List<Utilities> getUtilities(){
        return utilitiesService.getUtilities();
    }

    //ForAngular
    @GetMapping("api/getutil")
    public List<Utilities> DTOLatestUtilities(){
        return utilitiesService.DTOLatestUtilities();
    }

    //For HTTPIE
    @PostMapping("/api/updateutil")
    public void updateUtil(@RequestBody List<Utilities> utilities){
        utilitiesService.updateUtilities(utilities);
        billingService.addBillingFromUtil(utilities);
    }

    //ForAngular
    @PostMapping("/api/updateoneutil")
    public void updateOneUtil(@RequestBody Utilities utilities){
        utilitiesService.updateUtily(utilities);
        billingService.addOneBillingFromUtil(utilities);
    }

    @DeleteMapping(path="/api/deleteutil/{utilities_id}")
    public void deleteFromUtil(@PathVariable("utilities_id")int utilities_id){
        utilitiesService.deleteUtilities(utilities_id);
        billingService.deleteFromUtil(utilities_id);

    }

    @PutMapping(path ="api/updateutility/{utility_id}")
    public ResponseEntity<String> updateUtility(@PathVariable("utility_id") int utility_id, @RequestBody Utilities utilities_details){
         return utilitiesService.updateUtility(utility_id,utilities_details).map(updateUtility -> ResponseEntity.ok("Utility updated successfully."))
                .orElse(ResponseEntity.notFound().build());

    }

}
