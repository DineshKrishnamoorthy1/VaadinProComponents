package com.example.application.views.cookies;

import com.vaadin.flow.component.cookieconsent.CookieConsent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("topleft")
public class Topleft extends Div {
    public Topleft() {
        CookieConsent cookieConsent = new CookieConsent();
        cookieConsent.setMessage("This website uses cookies to ensure you get the best experience");
        cookieConsent.setDismissLabel("Dismiss");
        cookieConsent.setLearnMoreLabel("More");
        cookieConsent.setLearnMoreLink("https://vaadin.com/terms-of-service");
        cookieConsent.setPosition(CookieConsent.Position.TOP_LEFT);
        add(cookieConsent);
    }
}
