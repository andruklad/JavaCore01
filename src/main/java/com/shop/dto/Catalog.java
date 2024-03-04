package com.shop.dto;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private String code;
    private String name;
    private Map<String, Category> categoryMap;

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

    public Catalog(String code, String name) {
        this.code = code;
        this.name = name;
        categoryMap = new HashMap<>();
    }

    public void addCategory(Category category) {
        categoryMap.put(category.getCode(), category);
    }

    public Category getCategory(String categoryCode) {
        return categoryMap.get(categoryCode);
    }

    public String catalogInfoToString(boolean fullInfoFl) {
        StringBuilder sb = new StringBuilder();
        sb.append("Catalog: ").append(code).append(" ").append(name);
        if (categoryMap == null || categoryMap.isEmpty()) {
            sb.append(". Category list is empty");
        }
        else {
            sb.append(". Category list:");
            Category category;
            for (Map.Entry<String, Category> entry : categoryMap.entrySet()) {
                category = entry.getValue();
                if (fullInfoFl) {
                    sb.append("\n").append(category.toString());
                } else {
                    sb.append("\n").append(category.getCode()).append(" ").append(category.getName());
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return catalogInfoToString(true);
    }
}
