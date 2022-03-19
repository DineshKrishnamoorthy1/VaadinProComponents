package com.example.application.views.spreadsheet;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.spreadsheet.Spreadsheet;
import com.vaadin.flow.router.Route;

import java.io.IOException;

@Route(value = "example")
public class SPreadsheetExample extends Div {
    public SPreadsheetExample() throws IOException {
        setSizeFull();
        add(new Spreadsheet(SPreadsheetExample.class.getResourceAsStream("/testsheets/" + "Grouping.xlsx")));
    }
}
