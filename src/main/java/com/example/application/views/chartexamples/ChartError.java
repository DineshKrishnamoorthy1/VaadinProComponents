package com.example.application.views.chartexamples;

import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("ChartError")
public class ChartError extends Div {

    public ChartError(){
        // Create a chart of some primary type
        H1 h1=new H1("Chart Error");
        com.vaadin.flow.component.charts.Chart chart = new com.vaadin.flow.component.charts.Chart(ChartType.ERRORBAR);

// Modify the default configuration a bit
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Average Temperatures in Turku");
        conf.getLegend().setEnabled(false);

// The primary data series
        ListSeries averages = new ListSeries(
                -6, -6.5, -4, 3, 9, 14, 17, 16, 11, 6, 2, -2.5);

// Error bar data series with low and high values
        DataSeries errors = new DataSeries();
        errors.add(new DataSeriesItem(0,  -9, -3));
        errors.add(new DataSeriesItem(1, -10, -3));
        errors.add(new DataSeriesItem(2,  -8,  1));

// Need to be used for series to be recognized as error bar
        PlotOptionsErrorbar barOptions = new PlotOptionsErrorbar();
        errors.setPlotOptions(barOptions);

// The errors should be drawn lower
        conf.addSeries(errors);
        conf.addSeries(averages);

        add(h1,chart);


    }
}
