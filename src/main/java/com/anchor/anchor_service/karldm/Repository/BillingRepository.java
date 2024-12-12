package com.anchor.anchor_service.karldm.Repository;

import com.anchor.anchor_service.karldm.Entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billing,Integer> {


    @Query(value = "SELECT * FROM anchor.billing ORDER BY billing_cycle_date DESC LIMIT 3",nativeQuery = true)
    List<String> findLatestElecWaterReadOnly();

    @Query(value = "SELECT * FROM anchor.billing ORDER BY billing_id DESC LIMIT 3",nativeQuery = true)
    List<Billing> DTOLatestBilling();
}
