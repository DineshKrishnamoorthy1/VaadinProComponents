package com.example.application.views.spreadsheet;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.spreadsheet.Spreadsheet;
import com.vaadin.flow.router.Route;

import java.io.IOException;

@Route(value = "sheet", layout = MainLayout.class)
public class Sheet extends Div {

    public Sheet() throws IOException {
        setSizeFull();
        add(new Spreadsheet(Sheet.class.getResourceAsStream("/testsheets/" + "Simple Invoice.xlsx")));
    }



}
