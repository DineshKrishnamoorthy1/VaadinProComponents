package com.example.application.views.board;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Board")
@Route(value = "board",layout = MainLayout.class)

public class BoardView extends Div {

    public BoardView() {
        Board board = new Board();
        add(createViewEvents());


        board.addRow(
                createCell("Current users"),
                createCell("View events"),
                createCell("Conversion rate"),
                createCell("Custom metric")
        );

        SplitLayout splitLayout = new SplitLayout(board, new Div());

        add(splitLayout);




        Board board1 = new Board();
        board1.addRow(createHighlight("Current users", "745", 33.7),
                createHighlight("View events", "54.6k", -112.45),
                createHighlight("Conversion rate", "18%", 3.9),
                createHighlight("Custom metric", "-123.45", 0.0));

        add(board1);
    }

    private Component createHighlight(String title, String value, Double percentage) {
        VaadinIcon icon = VaadinIcon.ARROW_UP;
        String prefix = "";
        String theme = "badge";

        if (percentage == 0) {
            prefix = "±";
        } else if (percentage > 0) {
            prefix = "+";
            theme += " success";
        } else if (percentage < 0) {
            icon = VaadinIcon.ARROW_DOWN;
            theme += " error";
        }

        H2 h2 = new H2(title);
        h2.addClassNames("font-normal", "m-0", "text-secondary", "text-xs");

        Span span = new Span(value);
        span.addClassNames("font-semibold", "text-3xl");

        Icon i = icon.create();
        i.addClassNames("box-border", "p-xs");

        Span badge = new Span(i, new Span(prefix + percentage.toString()));
        badge.getElement().getThemeList().add(theme);

        VerticalLayout layout = new VerticalLayout(h2, span, badge);
        layout.addClassName("p-l");
        layout.setPadding(false);
        layout.setSpacing(false);
        return layout;
    }

    private Div createCell(String text) {
        Div div = new Div();
        div.setText(text);
        return div;
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





    


}

