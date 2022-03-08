package com.example.application.views.chartexamples;

import com.example.application.views.chart.Chart;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("Chart_P")
public class Chart_P extends Div {

    public Chart_P(){
        add(piecharts());

    }
    private Component piecharts()
    {
        H1 h1=new H1("Pie Chart");
        add(h1);
        HorizontalLayout horizontalLayout=new HorizontalLayout();
        com.vaadin.flow.component.charts.Chart chart = new com.vaadin.flow.component.charts.Chart(ChartType.PIE);
        Configuration conf = chart.getConfiguration();
        PlotOptionsPie options = new PlotOptionsPie();
        options.setInnerSize("0");
        options.setSize("75%");  // Default
        options.setCenter("50%", "50%"); // Default
        DataSeries series = new DataSeries();
        series.add(new DataSeriesItem("Mercury", 4900));
        series.add(new DataSeriesItem("Venus", 12100));
        conf.addSeries(series);
        conf.setPlotOptions(options);
        horizontalLayout.add(chart);
        return horizontalLayout;
    }
}
