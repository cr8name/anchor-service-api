package com.anchor.anchor_service.karldm.Controller;

import com.anchor.anchor_service.karldm.Entity.Customer;
import com.anchor.anchor_service.karldm.Service.CutomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(maxAge = 3360,origins = "http://localhost:4200")
public class CustomerController {

    private final CutomerService cutomerService;

    @Autowired
    public CustomerController(CutomerService cutomerService) {
        this.cutomerService = cutomerService;
    }

    @GetMapping("api/customer")
    public List<Customer> getCustomer(){
        return cutomerService.getCustomer();
    }

    @PostMapping("api/addcustomer")
    public void addNewCustomer(@RequestBody Customer customer){
        cutomerService.addCustomer(customer);
    }

    @DeleteMapping(path = "api/deletecustomer/{customer_id}")
    public void deleteCustomer(@PathVariable("customer_id")int customer_id){
        cutomerService.deleteCustomer(customer_id);
    }

    @PutMapping(path ="api/updatecustomer/{customer_id}")
    public ResponseEntity<String> updateCustomer(@PathVariable("customer_id") int customer_id, @RequestBody Customer customer_details){
        return cutomerService.updateCustomer(customer_id,customer_details)
                .map(updateCustomer -> ResponseEntity.ok("Customer updated successfully."))
                .orElse(ResponseEntity.notFound().build());
    }
}
