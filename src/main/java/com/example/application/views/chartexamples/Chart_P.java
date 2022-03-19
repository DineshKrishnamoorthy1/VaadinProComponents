package com.example.application.views.chartexamples;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;

import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("Chart_P")
public class Chart_P extends Div {
    public Chart_P(){
        H1 h1=new H1("Pie chart");
        Chart chart = new Chart(ChartType.PIE);
        Configuration conf = chart.getConfiguration();

        conf.setTitle("Browser market shares in January, 2018");

        PlotOptionsPie plotOptions = new PlotOptionsPie();
        plotOptions.setAllowPointSelect(true);
        plotOptions.setCursor(Cursor.POINTER);
        plotOptions.setShowInLegend(true);
        conf.setPlotOptions(plotOptions);

        DataSeries series = new DataSeries();
        series.add(new DataSeriesItem("Internet Explorer", 11.84));
        series.add(new DataSeriesItem("Firefox", 10.85));
        series.add(new DataSeriesItem("Edge", 4.67));
        series.add(new DataSeriesItem("Safari", 4.18));
        series.add(new DataSeriesItem("Sogou Explorer", 1.64));
        series.add(new DataSeriesItem("Opera", 6.2));
        conf.addSeries(series);


        add(h1,chart);



    }

}
