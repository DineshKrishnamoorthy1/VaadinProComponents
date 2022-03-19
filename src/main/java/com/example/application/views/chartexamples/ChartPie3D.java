package com.example.application.views.chartexamples;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.charts.model.style.SolidColor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("chartsPie3D")
public class ChartPie3D extends Div {

    public ChartPie3D(){
        H1 h1=new H1("Pie chart 3D");
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

// In 3D!
        Options3d options3d = new Options3d();
        options3d.setEnabled(true);
        options3d.setAlpha(10);
        options3d.setBeta(30);
        options3d.setDepth(45); // Default is 100
        options3d.setViewDistance(100); // Default
        conf.getChart().setOptions3d(options3d);

        Frame frame = new Frame();
        Back back=new Back();
        back.setColor(SolidColor.BEIGE);
        back.setSize(1);
        frame.setBack(back);
        options3d.setFrame(frame);

        add(h1,chart);

    }
}
