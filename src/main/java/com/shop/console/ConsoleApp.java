package com.shop.console;

import com.shop.ShopStorageMemory;
import com.shop.console.utils.Commands;
import com.shop.console.utils.Menu;
import com.shop.dto.Catalog;
import com.shop.dto.Category;

import static com.shop.console.utils.Input.*;

public class ConsoleApp {
    private Menu menu;
    private ShopStorageMemory shopStorageMemory;
    private String currentCatalogCode;
    private String currentCategoryCode;

    public ConsoleApp() {
        // Shop storage
        shopStorageMemory = new ShopStorageMemory();
        // Menu
        Menu mainMenu = new Menu("Main menu");
        Menu subMenuCatalog = new Menu("Work with catalog");
        Menu subMenuCategory = new Menu ("Work with category");
        // Main menu
        mainMenu.putAction("Quit", () -> System.exit(0));
        mainMenu.putAction("Add catalog", () -> Commands.addCatalog(shopStorageMemory));
        mainMenu.putAction("List all catalogs", () -> Commands.viewAllCatalogs(shopStorageMemory));
        mainMenu.putAction("Work with catalog", () -> {
            currentCatalogCode = getStringFromKeyboard("Enter catalog code:");
            Catalog currentCatalog = shopStorageMemory.getCatalog(currentCatalogCode);
            if (currentCatalog == null) {
                System.out.println("Catalog doesn't exists");
            }
            else {
                subMenuCatalog.setName(String.format("Work with catalog %s %s", currentCatalogCode, currentCatalog.getName()));
                activateMenu(subMenuCatalog);
            }
        });
        mainMenu.putAction("Print allcontent from shop storage", () -> Commands.viewAllContentFromShopStorage(shopStorageMemory));
        // Menu for catalog
        subMenuCatalog.putAction("Quit", () -> System.exit(0));
        subMenuCatalog.putAction("Return to Main menu", () -> activateMenu(mainMenu));
        subMenuCatalog.putAction("Add category", () -> Commands.addCategoryInCatalog(shopStorageMemory, currentCatalogCode));
        subMenuCatalog.putAction("List all categories from catalog", () -> Commands.viewAllCategoriesFromCatalog(shopStorageMemory, currentCatalogCode));
        subMenuCatalog.putAction("Work with category", () -> {
            currentCategoryCode = getStringFromKeyboard("Enter category code:");
            Category currentCategory = shopStorageMemory.getCatalog(currentCatalogCode).getCategory(currentCategoryCode);
            if (currentCategory == null) {
                System.out.println("Category doesn't exists");
            }
            else {
                subMenuCategory.setName(String.format("Work with category %s %s from catalog %s %s",
                        currentCategoryCode, currentCategory.getName(), currentCatalogCode, currentCategory.getName()));
                activateMenu(subMenuCategory);
            }
        });
        // Menu for category
        subMenuCategory.putAction("Quit", () -> System.exit(0));
        subMenuCategory.putAction("Return to Main menu", () -> activateMenu(mainMenu));
        subMenuCategory.putAction("Return to Catalog menu", () -> activateMenu(subMenuCatalog));
        subMenuCategory.putAction("Add product", () -> Commands.addProductInCategory(shopStorageMemory, currentCatalogCode, currentCategoryCode));
        subMenuCategory.putAction("List all products from category", () -> Commands.viewAllProductsFromCategory(shopStorageMemory, currentCatalogCode, currentCategoryCode));

        activateMenu(mainMenu);
    }

    private void activateMenu(Menu newMenu) {
        menu = newMenu;
        System.out.println(newMenu.generateText());
        while (true) {
            int actionNumber = getPosIntFromKeyboard("Enter action number:");
            menu.executeAction(actionNumber);
            System.out.println(newMenu.generateText());
        }
    }

    public static void main(String[] args) {
        new ConsoleApp();
    }
}
