package com.cleman.inventoryserviceapplication.service;


import com.cleman.inventoryserviceapplication.model.AvailableFuel;
import com.cleman.inventoryserviceapplication.model.ReservedFuel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {

    AvailableFuel addFuel(AvailableFuel availableFuel);

    List<AvailableFuel> getFuel();

    List<ReservedFuel> viewAllStatus();
}

