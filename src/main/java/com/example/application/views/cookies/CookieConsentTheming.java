package com.example.application.views.cookies;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.cookieconsent.CookieConsent;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("CookieConsentTheming")
@CssImport(value = "./styles/cookie-consent-theming.css")
public class CookieConsentTheming extends Div {

    public CookieConsentTheming() {
      UI.getCurrent().getElement().getClassList().add("cookie-consent-theming");


        CookieConsent cookieConsent = new CookieConsent();

        add(cookieConsent);
    }
}
