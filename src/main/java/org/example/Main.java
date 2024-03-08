package org.example;

import org.example.controller.DatabaseControl;
import org.example.controller.MyEntity;
import org.example.model.Utilities;
import org.example.view.MainView;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        DatabaseControl databaseControl = new DatabaseControl();

        MainView.menu();

        databaseControl.insertNewRecord();

        var person = databaseControl.FetchDatabase();

        Utilities.renderObjectToTable(person.stream()
                .collect(Collectors.toList()));
        databaseControl.closeConnection();
    }
}