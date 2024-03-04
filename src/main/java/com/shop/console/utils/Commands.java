package com.shop.console.utils;

import com.shop.ShopStorage;

import static com.shop.console.utils.Input.getDoubleFromKeyboard;
import static com.shop.console.utils.Input.getStringFromKeyboard;

public class Commands {

    public static void addCatalog(ShopStorage shopStorage) {
        String catalogCode = getStringFromKeyboard("Enter catalog code:");
        String catalogName = getStringFromKeyboard("Enter catalog name:");
        shopStorage.addCatalog(catalogCode, catalogName);
        System.out.println("Catalog successfully added");
    }

    public static void viewAllCatalogs(ShopStorage shopStorage) {
        System.out.println(shopStorage.toStringShort());
    }

    public static void addCategoryInCatalog(ShopStorage shopStorage, String catalogCode) {
        String categoryCode = getStringFromKeyboard("Enter category code:");
        String categoryName = getStringFromKeyboard("Enter category name:");
        shopStorage.addCategoryInCatalog(catalogCode, categoryCode, categoryName);
        System.out.println("Category successfully added");
    }

    public static void viewAllCategoriesFromCatalog(ShopStorage shopStorage, String catalogCode) {
        System.out.println(shopStorage.getCatalog(catalogCode).catalogInfoToString(false));
    }

    public static void addProductInCategory(ShopStorage shopStorage, String catalogCode, String categoryCode) {
        String productArticle = getStringFromKeyboard("Enter product article:");
        String productName = getStringFromKeyboard("Enter product name:");
        Double productPrice = getDoubleFromKeyboard("Enter product price:");
        shopStorage.addProductInCategory(catalogCode, categoryCode, productArticle, productName, productPrice);
        System.out.println("Product successfully added");
    }

    public static void viewAllProductsFromCategory(ShopStorage shopStorage, String catalogCode, String categoryCode) {
        System.out.println(shopStorage.getCatalog(catalogCode).getCategory(categoryCode).toString());
    }

    public static void viewAllContentFromShopStorage(ShopStorage shopStorage) {
        System.out.println(shopStorage.toString());
    }
}
