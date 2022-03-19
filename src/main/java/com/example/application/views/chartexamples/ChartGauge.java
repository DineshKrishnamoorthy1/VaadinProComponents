package com.example.application.views.chartexamples;

import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("Chartgauge")
public class ChartGauge extends Div {

public ChartGauge(){

    H1 h1=new H1("Chart Gauge");
    add(h1);

    com.vaadin.flow.component.charts.Chart chart = new com.vaadin.flow.component.charts.Chart(ChartType.GAUGE);

    Configuration conf = chart.getConfiguration();
    conf.setTitle("Speedometer");
    conf.getPane().setStartAngle(-135);
    conf.getPane().setEndAngle(135);

    ListSeries series = new ListSeries("Speed", 80);
    conf.addSeries(series);

    YAxis yaxis = new YAxis();
    yaxis.setTitle("km/h");

    yaxis.setMin(0);
    yaxis.setMax(100);

    yaxis.getLabels().setStep(1);
    yaxis.setTickInterval(10);
    yaxis.setTickLength(10);
    yaxis.setTickWidth(1);
    yaxis.setMinorTickInterval("1");
    yaxis.setMinorTickLength(5);
    yaxis.setMinorTickWidth(1);

    PlotBand green = new PlotBand(0, 60, null);
    green.setClassName("green");

    PlotBand yellow = new PlotBand(60, 80, null);
    yellow.setClassName("yellow");

    PlotBand red = new PlotBand(80, 100, null);
    red.setClassName("red");

    yaxis.setPlotBands(green, yellow, red);

    conf.addyAxis(yaxis);

    add(chart);

}
}
