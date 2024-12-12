package com.anchor.anchor_service.karldm.Service;

import com.anchor.anchor_service.karldm.Entity.Billing;
import com.anchor.anchor_service.karldm.Entity.Utilities;

import java.util.List;
import java.util.Optional;

public interface BillingService {

    List<Billing> getBilling();
    public void addBillingFromUtil(List<Utilities> utilities);
    public List<String> findlatestElecWaterbill();
    public List<Billing> DTOLatestBilling();
    public void addOneBillingFromUtil(Utilities util);
    public void deleteFromUtil(int billing_id);
    public Optional<Billing> updateBillingFromUtil(int billing_id, Billing billingDetails);
}
