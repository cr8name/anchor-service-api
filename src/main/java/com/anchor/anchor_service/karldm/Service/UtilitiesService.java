package com.anchor.anchor_service.karldm.Service;

import com.anchor.anchor_service.karldm.Entity.Billing;
import com.anchor.anchor_service.karldm.Entity.Utilities;

import java.util.List;
import java.util.Optional;

public interface UtilitiesService {

    public List<Utilities> getUtilities();

    public void updateUtilities(List<Utilities> utilities);

    public void updateUtily(Utilities utility);

    public List<Utilities> DTOLatestUtilities();

    public void deleteUtilities(int utilities_id);

    public Optional<Utilities> updateUtility(int utilities_id, Utilities utilitiesDetails);




}