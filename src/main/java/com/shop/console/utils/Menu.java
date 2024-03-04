package com.shop.console.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Menu {
    private String name;
    private LinkedHashMap<String, Runnable> actionsMap = new LinkedHashMap<>();

    public Menu(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void putAction(String name, Runnable action) {
        actionsMap.put(name, action);
    }

    public String generateText() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ");
        List<String> actionNames = new ArrayList<>(actionsMap.keySet());
        for (int i = 0; i < actionNames.size(); i++) {
            sb.append(String.format("%n %d: %s", i + 1, actionNames.get(i)));
        }
        return sb.toString();
    }

    public void executeAction(int actionNumber) {
        int effectiveActionNumber = actionNumber - 1;
        if (effectiveActionNumber < 0 || effectiveActionNumber >= actionsMap.size()) {
            System.out.println("Ignoring menu choice: " + actionNumber);
        } else {
            List<Runnable> actions = new ArrayList<>(actionsMap.values());
            actions.get(effectiveActionNumber).run();
        }
    }
}