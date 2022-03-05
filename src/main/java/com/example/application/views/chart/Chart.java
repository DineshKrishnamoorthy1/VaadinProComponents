package com.example.application.views.chart;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Route;

@Route(value = "chart",layout = MainLayout.class)
public class Chart extends Div {


    public Chart() {
        add(createViewEvents());
        add(area());

    }

    private Component createViewEvents() {
        // Chart
        com.vaadin.flow.component.charts.Chart chart = new com.vaadin.flow.component.charts.Chart(ChartType.AREA);
        Configuration conf = chart.getConfiguration();

        XAxis xAxis = new XAxis();
        xAxis.setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        conf.addxAxis(xAxis);

        conf.getyAxis().setTitle("Values");

        PlotOptionsArea plotOptions = new PlotOptionsArea();
        plotOptions.setPointPlacement(PointPlacement.ON);
        conf.addPlotOptions(plotOptions);

        conf.addSeries(new ListSeries("Berlin", 189, 191, 191, 196, 201, 203, 209, 212, 229, 242, 244, 247));
        conf.addSeries(new ListSeries("London", 138, 146, 148, 148, 152, 153, 163, 173, 178, 179, 185, 187));
        conf.addSeries(new ListSeries("New York", 65, 65, 66, 71, 93, 102, 108, 117, 127, 129, 135, 136));
        conf.addSeries(new ListSeries("Tokyo", 0, 11, 17, 23, 30, 42, 48, 49, 52, 54, 58, 62));

        // Add it all together
        VerticalLayout viewEvents = new VerticalLayout(chart);
        viewEvents.setPadding(false);
        viewEvents.setSpacing(false);
        viewEvents.getElement().getThemeList().add("spacing-l");
        return viewEvents;
    }

    private Component area()
    {

        com.vaadin.flow.component.charts.Chart chart = new com.vaadin.flow.component.charts.Chart(ChartType.LINE);

        Configuration config=new Configuration();

        config.setTitle("Average Temperatures in Turku");
        config.getLegend().setEnabled(false);

        VerticalLayout arealayout = new VerticalLayout(chart);
        arealayout.setPadding(false);
        arealayout.setSpacing(false);
        arealayout.getElement().getThemeList().add("spacing-l");
        return arealayout;

    }


}
