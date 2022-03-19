package com.example.application.views.chartexamples;

import com.example.application.views.MainLayout;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.context.annotation.Import;

@Route(value = "Chart-exp",layout = MainLayout.class)
@CssImport(value = "./styles/charts.css", themeFor = "vaadin-chart")

public class Chart_Examples extends Div {

    public Chart_Examples()
    {

        Div Div1=new Div();
        Div1.addClassName("Division");

        Button CHART_Column = new Button("CHART-Column", event -> UI.getCurrent().navigate("Chart_C"));
        Button CHART_PIE = new Button("CHART-Pie", event -> UI.getCurrent().navigate("Chart_P"));
        Button Chartbubble = new Button("CHART-Bubble", event -> UI.getCurrent().navigate("Chartbubble"));
        Button ChartError = new Button("CHART-Error", event -> UI.getCurrent().navigate("ChartError"));
        Button CHARTFLAGS = new Button("CHART-FLAGS", event -> UI.getCurrent().navigate("CHARTFLAGS"));
        Button Chartgauge = new Button("CHART-Gauge", event -> UI.getCurrent().navigate("Chartgauge"));
        Button ChartOrganisation = new Button("CHART-Organisation", event -> UI.getCurrent().navigate("ChartOrganisation"));
        Button chartsPie3d = new Button("CHART-Pie-3D", event -> UI.getCurrent().navigate("chartsPie3D"));
        Button ChartsSpiderWeb = new Button("CHART-SpiderWeb", event -> UI.getCurrent().navigate("ChartsSpiderWeb"));
        Button CHartsTimeline = new Button("CHART-Timeline", event -> UI.getCurrent().navigate("CHartsTimeline"));
        Button ChartWaterfall = new Button("CHART-Waterfall", event -> UI.getCurrent().navigate("ChartWaterfall"));



        VerticalLayout HRZ=new VerticalLayout(CHART_Column,CHART_PIE,Chartbubble,
                ChartError,CHARTFLAGS,Chartgauge,ChartOrganisation,ChartsSpiderWeb,CHartsTimeline,
                ChartWaterfall,chartsPie3d);

        HRZ.setAlignItems(FlexComponent.Alignment.CENTER);
        Div1.add(HRZ);

        add(Div1);
    }

}
