package com.example.application.views.spreadsheet;

import com.example.application.views.MainLayout;
import com.vaadin.addon.spreadsheet.Spreadsheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "sheet",layout = MainLayout.class)
public class Sheet extends Div {
    public Spreadsheet Sheet() {
        Spreadsheet spreadsheet = new Spreadsheet();
        return spreadsheet;
    }

}
