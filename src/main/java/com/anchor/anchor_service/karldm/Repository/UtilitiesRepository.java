package com.anchor.anchor_service.karldm.Repository;

import com.anchor.anchor_service.karldm.Entity.Billing;
import com.anchor.anchor_service.karldm.Entity.Utilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilitiesRepository extends JpaRepository<Utilities,Integer> {

    @Query(value = "SELECT * FROM anchor.utilities ORDER BY utilities_id DESC Limit 3;",nativeQuery = true)
    List<Utilities> DTOLatestUtilities();


}
