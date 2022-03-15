package com.example.application.views.spreadsheet;

import com.vaadin.addon.spreadsheet.Spreadsheet;
import com.example.application.views.MainLayout;
import com.vaadin.addon.spreadsheet.Spreadsheet;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "sheet")
public class Sheet extends Spreadsheet {
    public Sheet() {
        Spreadsheet spreadsheet = new Spreadsheet();
        VerticalLayout layout = new VerticalLayout();

        layout.add(String.valueOf(spreadsheet));
    }

}
