package com.shop;

import com.shop.dto.Catalog;
import com.shop.dto.Category;
import com.shop.dto.Product;

import java.util.HashMap;
import java.util.Map;

public class ShopStorageMemory extends ShopStorage {
    private HashMap<String, Catalog> catalogMap;

    public ShopStorageMemory() {
        catalogMap = new HashMap<>();
    }

    public void addCatalog(String code, String catalogName) {
        catalogMap.put(code, new Catalog(code, catalogName));
    }
    public void addCategoryInCatalog(String catalogCode, String categoryCode, String categoryName) {
        Catalog catalog = catalogMap.get(catalogCode);
        catalog.addCategory(new Category(categoryCode, categoryName));
    }
    public void addProductInCategory(String catalogCode, String categoryCode, String productArticle, String productName, Double productPrice) {
        Category category = catalogMap.get(catalogCode).getCategory(categoryCode);
        category.addProduct(new Product(productArticle, productName, productPrice));
    }
    public Catalog getCatalog(String catalogCode) {
        return catalogMap.get(catalogCode);
    }

    private String shopStorageInfoToString(boolean fullInfoFl) {
        if (catalogMap == null || catalogMap.isEmpty()) {
            return "Catalog list is empty";
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("Catalog list:");
            Catalog catalog;
            for (Map.Entry<String, Catalog> entry : catalogMap.entrySet()) {
                catalog = entry.getValue();
                if (fullInfoFl) {
                    sb.append("\n").append(catalog.toString());
                } else {
                    sb.append("\n").append(catalog.getCode()).append(" ").append(catalog.getName());
                }
            }
            return sb.toString();
        }
    }

    public String toStringShort() {
        return shopStorageInfoToString(false);
    }

    @Override
    public String toString() {
        return shopStorageInfoToString(true);
    }
}

