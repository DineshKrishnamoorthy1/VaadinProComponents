package com.example.application.views.spreadsheet;

import com.vaadin.addon.spreadsheet.Spreadsheet;
import com.vaadin.flow.router.Route;

@Route(value = "sheet")
public class Sheet extends Spreadsheet {
    public Spreadsheet Sheet() {
        Spreadsheet spreadsheet = new Spreadsheet();
        return spreadsheet;
    }

}
