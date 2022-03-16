package com.example.application.views.spreadsheet;

import com.example.application.views.MainLayout;
import com.vaadin.addon.spreadsheet.Spreadsheet;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

public class SpreadSheet extends Spreadsheet {


    public SpreadSheet() {
         Spreadsheet she = new Spreadsheet();
         VerticalLayout layout = new VerticalLayout();
        Button btn=new Button("Example");
        layout.add(btn);
        layout.add(String.valueOf(she));

    }


}


