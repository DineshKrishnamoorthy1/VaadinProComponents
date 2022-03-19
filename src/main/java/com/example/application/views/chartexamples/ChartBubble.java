package com.example.application.views.chartexamples;

import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;


@Route("Chartbubble")
public class ChartBubble extends Div {

    public ChartBubble(){
        com.vaadin.flow.component.charts.Chart chart = new com.vaadin.flow.component.charts.Chart(ChartType.BUBBLE);


        // Create a bubble chart

// Modify the default configuration a bit
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Sugar and fat intake per country");
        conf.setSubTitle("Source: <a href=\"http://www.euromonitor.com/\">Euromonitor</a> and <a href=\"https://data.oecd.org/\">OECD</a>");
        conf.getLegend().setEnabled(false); // Disable legend
        conf.getTooltip().setHeaderFormat("{point.country}");
        conf.getTooltip().setPointFormat("Obesity (adults): {point.z}%");

        PlotOptionsBubble plotOptions = new PlotOptionsBubble();
        DataLabels chartLabels = new DataLabels();
        chartLabels.setEnabled(true);
        chartLabels.setFormat("{point.name}");
        plotOptions.setDataLabels(chartLabels);
        conf.setPlotOptions(plotOptions);

        add(chart);

        class MyDataSeriesItem extends DataSeriesItem3d {
            private String country;

            public MyDataSeriesItem(Number x, Number y, Number z, String name, String country) {
                super(x, y, z);
                setName(name);
                this.country = country;
            }

            public String getCountry() {
                return country;
            }
        }

        DataSeries series = new DataSeries("Countries");
        series.add(new MyDataSeriesItem(95.0, 95.0, 13.8, "BE", "Belgium"));
        series.add(new MyDataSeriesItem(86.5, 102.9, 14.7, "DE", "Germany"));
        series.add(new MyDataSeriesItem(80.8, 91.5, 15.8, "FI", "Finland"));

        conf.addSeries(series);

// Set the category labels on the axis correspondingly
        XAxis xaxis = new XAxis();
        xaxis.setTitle("Daily fat intake");
        xaxis.getLabels().setFormat("{value} gr");
        PlotLine xPlotLine = new PlotLine();
        xPlotLine.setValue(65);
        Label xLabel = new Label("Safe fat intake 65g/day");
        xLabel.setRotation(0);
        xLabel.setY(15);
        xPlotLine.setLabel(xLabel);
        xaxis.setPlotLines(xPlotLine);
        conf.addxAxis(xaxis);

// Set the Y axis title
        YAxis yaxis = new YAxis();
        yaxis.setMax(160);
        yaxis.setTitle("Daily sugar intake");
        yaxis.getLabels().setFormat("{value} gr");
        yaxis.setStartOnTick(false);
        yaxis.setEndOnTick(false);
        PlotLine yPlotLine = new PlotLine();
        yPlotLine.setValue(50);
        Label yLabel = new Label("Safe sugar intake 50g/day");
        yLabel.setX(-10);
        yLabel.setAlign(HorizontalAlign.RIGHT);
        yPlotLine.setLabel(yLabel);
        yaxis.setPlotLines(yPlotLine);
        conf.addyAxis(yaxis);

        Configuration configuration = chart.getConfiguration();

        configuration.getxAxis().setType(AxisType.CATEGORY);

        Navigator navigator = configuration.getNavigator();
        navigator.setEnabled(true);
        navigator.setMargin(75);

        RangeSelector rangeSelector = new RangeSelector();
        rangeSelector.setInputDateFormat("%YYYY-%MM-%DD:%H:%M");
        rangeSelector.setInputEditDateFormat("%YYYY-%MM-%DD:%H:%M");
        rangeSelector.setInputDateParser(
                "function(value) {" +
                        "value = value.split(/[:\\-]/);\n" +
                        "return Date.UTC(\n" +
                        "   parseInt(value[0], 10),\n" +
                        "   parseInt(value[1], 10),\n" +
                        "   parseInt(value[2], 10),\n" +
                        "   parseInt(value[3], 10),\n" +
                        "   parseInt(value[4], 10),\n" +
                        ");}");
        configuration.setRangeSelector(rangeSelector);
        configuration.setRangeSelector(rangeSelector);




    }



}
