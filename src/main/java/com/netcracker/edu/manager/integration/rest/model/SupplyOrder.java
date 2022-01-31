package com.netcracker.edu.manager.integration.rest.model;


import com.netcracker.edu.manager.integration.rest.client.model.Product;

import java.io.Serializable;
import java.util.List;

public class SupplyOrder implements Serializable {

    private List<Product> products;

    private String name;

    public SupplyOrder() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
