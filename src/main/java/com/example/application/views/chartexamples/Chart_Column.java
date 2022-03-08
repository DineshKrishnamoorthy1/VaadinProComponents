package com.example.application.views.chartexamples;

import com.example.application.views.chart.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("Chart_C")
public class Chart_Column extends Div {

    public Chart_Column(){
        H1 h1=new H1("Column Chart");

        com.vaadin.flow.component.charts.Chart chart = new com.vaadin.flow.component.charts.Chart(ChartType.COLUMN);
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Reindeer Kills by Predators");
        conf.setSubTitle("Kills Grouped by Counties");
    }



}
