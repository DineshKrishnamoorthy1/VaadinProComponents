package com.example.application.views.cookies;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.cookieconsent.CookieConsent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "Cookies",layout = MainLayout.class)
public class CookiesExample extends Div {


    public CookiesExample() {
        CookieConsent cookieConsent = new CookieConsent();
        cookieConsent.setMessage("This Site May contain some cookies");
        cookieConsent.setDismissLabel("Dismiss");
        cookieConsent.setLearnMoreLabel("More Lable");
        cookieConsent.setLearnMoreLink("https://vaadin.com/terms-of-service");
        add(cookieConsent);
    }
}
