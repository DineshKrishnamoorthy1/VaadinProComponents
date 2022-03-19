package com.example.application.views.chartexamples;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("ChartsSpiderWeb")
public class ChartSpiderWeb extends Div {

    public ChartSpiderWeb(){
        H1 h1=new H1("Charts SpiderWeb");

        add(h1);

        Chart chart = new Chart(ChartType.LINE);

// Modify the default configuration a bit
        Configuration conf = chart.getConfiguration();
        conf.getChart().setPolar(true);

// Create the range series
// Source: http://ilmatieteenlaitos.fi/lampotilaennatyksia
        ListSeries series = new ListSeries("Temperature Extremes",
                10.9, 11.8, 17.5, 25.5, 31.0, 33.8,
                37.2, 33.8, 28.8, 19.4, 14.1, 10.8);
        conf.addSeries(series);

// Set the category labels on the X axis correspondingly
        XAxis xaxis = new XAxis();
        xaxis.setCategories("Jan", "Feb", "Mar",
                "Apr", "May", "Jun", "Jul", "Aug", "Sep",
                "Oct", "Nov", "Dec");
        xaxis.setTickmarkPlacement(TickmarkPlacement.ON);
        xaxis.setLineWidth(0);
        conf.addxAxis(xaxis);

// Configure the Y axis
        YAxis yaxis = new YAxis();
        yaxis.setGridLineInterpolation("polygon"); // Webby look
        yaxis.setMin(0);
        yaxis.setTickInterval(10);
        yaxis.getLabels().setStep(1);
        conf.addyAxis(yaxis);

        add(chart);
    }
}
