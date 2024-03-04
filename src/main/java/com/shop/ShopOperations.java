package com.shop;

import com.shop.dto.Catalog;

public interface ShopOperations {
    void addCatalog(String code, String catalogName);
    void addCategoryInCatalog(String catalogCode, String categoryCode, String categoryName);
    void addProductInCategory(String catalogCode, String categoryCode, String productArticle, String productName, Double productPrice);
    Catalog getCatalog(String catalogCode);
    String toStringShort();
}
