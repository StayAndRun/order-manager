package com.netcracker.edu.manager.service;

import com.netcracker.edu.manager.integration.rest.client.InventoryClient;
import com.netcracker.edu.manager.integration.rest.model.SellOrder;
import com.netcracker.edu.manager.integration.rest.model.SupplyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class OrderService implements Serializable {

    private InventoryClient inventoryClient;

    @Autowired
    public OrderService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    public void sell(SellOrder sellOrder) {
        sellOrder.getProducts().forEach(product -> inventoryClient.removeProduct(product.getId()));
    }

    public void supply(SupplyOrder supplyOrder) {
        supplyOrder.getProducts().forEach(product -> inventoryClient.addProduct(product));
    }

}
