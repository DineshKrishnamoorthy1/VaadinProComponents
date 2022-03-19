package com.example.application.views.spreadsheet;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.spreadsheet.Spreadsheet;
import com.vaadin.flow.router.Route;

import java.io.IOException;

@Route(value = "plain")
public class Plain extends Div {
    public Plain() throws IOException {
        setSizeFull();
        add(new Spreadsheet(Plain.class.getResourceAsStream("/testsheets/"+"Plain.xlsx")));
    }
}
