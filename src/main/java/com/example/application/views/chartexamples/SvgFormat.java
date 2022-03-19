package com.example.application.views.chartexamples;


import com.vaadin.flow.component.charts.export.SVGGenerator;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import java.io.IOException;

@Route("SVGColomn")
public class SvgFormat extends Div {

    public SvgFormat(){
        Div div = new Div();
        Configuration configuration = new Configuration();
// ...
        try (
                SVGGenerator generator = new SVGGenerator()) {
            String svg = generator.generate(configuration);
            div.getElement().setProperty("innerHTML", svg);
        } catch (IOException | InterruptedException ex) {
            // handle exceptions accordingly
        }
        add(div);
    }



}
