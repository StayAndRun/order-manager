package com.netcracker.edu.manager.integration.rest.model;

import com.netcracker.edu.manager.integration.rest.client.model.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SellOrder implements Serializable {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
