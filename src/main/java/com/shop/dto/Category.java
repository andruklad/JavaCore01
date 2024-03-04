package com.shop.dto;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private String code;
    private String name;
    private Map<String, Product> productMap;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(String code, String name) {
        this.code = code;
        this.name = name;
        productMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        productMap.put(product.getArticle(), product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Category: ").append(code).append(" ").append(name);
        if (productMap == null || productMap.isEmpty()) {
            sb.append(". Product list is empty");
        }
        else {
            sb.append(". Product list:");
            Product product;
            for (Map.Entry<String, Product> entry : productMap.entrySet()) {
                product = entry.getValue();
                sb.append("\n").append(product.toString());
            }
        }
        return sb.toString();
    }
}
