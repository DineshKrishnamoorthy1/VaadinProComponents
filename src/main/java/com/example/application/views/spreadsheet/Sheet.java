package com.example.application.views.spreadsheet;

import com.example.application.views.MainLayout;
import com.vaadin.addon.spreadsheet.Spreadsheet;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.ui.Component;

@Route(value = "sheet",layout = MainLayout.class)
public class Sheet extends Div  {
HorizontalLayout horizontalLayout=new HorizontalLayout();
private Spreadsheet sheet=null;

    public Sheet() {
        spreadsheetreturn();
    }
    private Component spreadsheetreturn()
    {
        sheet=new Spreadsheet();
       sheet.setVisible(true);
        return sheet;

    }

}
