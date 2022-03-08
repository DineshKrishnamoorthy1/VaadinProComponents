package com.example.application.views.cookies;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.cookieconsent.CookieConsent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Cookies",layout = MainLayout.class)
public class CookiesExample extends Div {
HorizontalLayout horizontalLayout=new HorizontalLayout();

    public CookiesExample() {

        Button button_top_right = new Button("Top Right", event -> UI.getCurrent().navigate("topright"));
        Button button_top_left = new Button("Top Left", event -> UI.getCurrent().navigate("topleft"));
        Button button_left = new Button("Bottom Left", event -> UI.getCurrent().navigate("Bottomleft"));
        Button button_right = new Button("Right", event -> UI.getCurrent().navigate("button_right"));
        Button button_bottom = new Button("Bottom", event -> UI.getCurrent().navigate("bottom"));
        Button button_Themin = new Button("Theming", event -> UI.getCurrent().navigate("CookieConsentTheming"));



        horizontalLayout.add(button_left);
        horizontalLayout.add(button_top_left);
        horizontalLayout.add(button_top_right);
        horizontalLayout.add(button_right);
        horizontalLayout.add(button_bottom);
        horizontalLayout.add(button_Themin);

        add(horizontalLayout);

    }

}
