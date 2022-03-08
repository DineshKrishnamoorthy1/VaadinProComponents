package com.example.application.views.chartexamples;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Chart-exp",layout = MainLayout.class)
public class Chart_Examples extends Div {

    public Chart_Examples()
    {
        Button CHART_Column = new Button("CHART-Column", event -> UI.getCurrent().navigate("Chart_C"));
        Button CHART_PIE = new Button("CHART-Pie", event -> UI.getCurrent().navigate("Chart_P"));
        Button Chartbubble = new Button("CHART-Bubble", event -> UI.getCurrent().navigate("Chartbubble"));



        VerticalLayout HRZ=new VerticalLayout(CHART_Column,CHART_PIE,Chartbubble);
        HRZ.setAlignItems(FlexComponent.Alignment.CENTER);


        add(HRZ);
    }

}
