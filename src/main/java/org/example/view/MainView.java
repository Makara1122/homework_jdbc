package org.example.view;

import org.example.model.Utilities;

import java.util.ArrayList;
import java.util.List;

public class MainView {
    public static List<String> menu(){
        List<String> menus = new ArrayList<>(List.of("1. Show Records",
                "2. Insert Records","3. Exit"));
        Utilities.renderMenu(menus,"Welcome to my applications");
        return menus;
    }
}
