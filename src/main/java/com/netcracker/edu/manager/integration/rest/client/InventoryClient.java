package com.netcracker.edu.manager.integration.rest.client;

import com.netcracker.edu.manager.integration.rest.client.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class InventoryClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${integration.inventory.url}")
    private String inventoryUrl;

    public void addProduct(Product product) {
        URI createEndpoint = URI.create(inventoryUrl + "/api/v1/products");
        ResponseEntity<Product> productResponseEntity = restTemplate.postForEntity(createEndpoint, product, Product.class);
        productResponseEntity.getStatusCode();
    }

    public void removeProduct(String productId) {
        URI createEndpoint = URI.create(inventoryUrl + "/api/v1/products/" + productId);
        restTemplate.delete(createEndpoint);
    }
}
