package com.example.application.views.chartexamples;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("CHARTFLAGS")
public class ChartFlags extends Div {

    public ChartFlags(){

        H1 h1=new H1("Chart Flags");

        add(h1);
        Chart chart = new Chart(ChartType.SPLINE);


        Configuration configuration = chart.getConfiguration();
        configuration.getTitle().setText("USD to EUR exchange rate");
        configuration.getxAxis().setType(AxisType.DATETIME);

// A data series to annotate with flags
        DataSeries dataSeries = new DataSeries();
        dataSeries.setId("dataseries");
        dataSeries.addData(new Number[][] { { 1434499200000L, 0.8821 },
                { 1434585600000L, 0.8802 }, { 1434672000000L, 0.8808 },
                { 1434844800000L, 0.8794 }, { 1434931200000L, 0.8818 },
                { 1435017600000L, 0.8952 }, { 1435104000000L, 0.8924 },
                { 1435190400000L, 0.8925 }, { 1435276800000L, 0.8955 } });

// Flags on the data series
        DataSeries flagsOnSeries = new DataSeries();
        flagsOnSeries.setName("Flags on series");
        PlotOptionsFlags plotOptionsFlags = new PlotOptionsFlags();
        plotOptionsFlags.setShape(FlagShape.SQUAREPIN);
        plotOptionsFlags.setOnSeries("dataseries");
        flagsOnSeries.setPlotOptions(plotOptionsFlags);
        flagsOnSeries.add(new FlagItem(1434585600000L, "First Series Flag",
                "First Series Flag Tooltip Text"));
        flagsOnSeries.add(new FlagItem(1435017600000L, "Second Series Flag"));

// Flags on the X axis
        DataSeries flagsOnAxis = new DataSeries();
        flagsOnAxis.setPlotOptions(new PlotOptionsFlags());
        flagsOnAxis.setName("Flags on axis");
        flagsOnAxis.add(new FlagItem(1434844800000L, "First Axis Flag",
                "First Axis Flag Tooltip Text"));
        flagsOnAxis.add(new FlagItem(1435190400000L, "Second Axis Flag"));

        configuration.setSeries(dataSeries, flagsOnSeries, flagsOnAxis);
        add(chart);
    }
}
