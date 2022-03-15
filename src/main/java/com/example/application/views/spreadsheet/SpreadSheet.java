package com.example.application.views.spreadsheet;

import com.example.application.views.MainLayout;
import com.vaadin.addon.spreadsheet.Spreadsheet;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

public class SpreadSheet extends Spreadsheet {


    public SpreadSheet() {
         Spreadsheet spreadsheet = new Spreadsheet();
         VerticalLayout layout = new VerticalLayout();
         addComponentAsFirst(spreadsheet);


    }

    private Spreadsheet addComponentAsFirst(Spreadsheet spreadsheet) {
        return spreadsheet;
    }
}


