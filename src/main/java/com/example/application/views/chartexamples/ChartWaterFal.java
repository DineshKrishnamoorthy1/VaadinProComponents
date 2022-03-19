package com.example.application.views.chartexamples;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("ChartWaterfall")
@CssImport(value="./styles/charts.css", themeFor = "vaadin-chart", include = "vaadin-chart-default-theme")
public class ChartWaterFal extends Div {

    public ChartWaterFal(){

        H1 h1=new H1("Waterfall Chart");
        Chart chart = new Chart(ChartType.WATERFALL);

        DataSeries dataSeries = new DataSeries();
        chart.addClassName("ChartWaterFal");
        dataSeries.add(new DataSeriesItem("Start", 120000));
        dataSeries.add(new DataSeriesItem("Product Revenue", 569000));
        dataSeries.add(new DataSeriesItem("Service Revenue", 231000));
        WaterFallSum positiveBalance = new WaterFallSum("Positive Balance");
        positiveBalance.setIntermediate(true);
        dataSeries.add(positiveBalance);

        dataSeries.add(new DataSeriesItem("Fixed Costs", -342000));
        dataSeries.add(new DataSeriesItem("Variable Costs", -233000));
        WaterFallSum balance = new WaterFallSum("Balance");
        dataSeries.add(balance);

        PlotOptionsWaterfall opts = new PlotOptionsWaterfall();
        DataLabels dataLabels = new DataLabels(true);
        dataLabels.setVerticalAlign(VerticalAlign.TOP);
        dataLabels.setY(-30);
        dataLabels.setFormatter("function() { return this.y / 1000 + 'k'; }");
        opts.setDataLabels(dataLabels);

        dataSeries.setPlotOptions(opts);

        Configuration configuration = chart.getConfiguration();
        configuration.addSeries(dataSeries);
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

        PlotOptionsSeries plotOptions = new PlotOptionsSeries();
        plotOptions.setCompare(Compare.PERCENT);
        configuration.setPlotOptions(plotOptions);

        add(h1,chart);

    }
}
