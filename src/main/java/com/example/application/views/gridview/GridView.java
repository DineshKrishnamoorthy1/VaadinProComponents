package com.example.application.views.gridview;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.gridpro.GridPro;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;

import java.util.regex.Pattern;


//@CssImport(value = "./styles/hello-world.css",themeFor = "vaadin-grid")

@Route(value = "GridView",layout = MainLayout.class)
@CssImport(value = "./styles/vaadin-grid-pro.css",themeFor = "vaadin-grid")


public class GridView extends Div {


    public GridView() {
        GridPro<Person> grid = new GridPro<>();
        grid.setEditOnClick(true);
        grid.setEnterNextRow(true);
        grid.addClassName("editable-custom-effect");




        grid.addColumn(Person::getFirstName)
                .setHeader("First name(Read Only)");

        grid.addEditColumn(Person::getLastName)
                .text(Person::setLastName)
                .setHeader("Last name(Editable)");


        grid.addEditColumn(Person::getEmail)
                .text((person, newValue) -> {
                    if (isValidEmail(newValue)) {
                        person.setEmail(newValue);
                    } else {
                        showErrorNotification("Please enter a valid email address");
                    }
                })
                .setHeader("Email(Editable)");

        grid.setItems(
                new Person("Dinesh", "Krishnamoorthy","dineshk12102000@gmail.com"),
                new Person("Ajith Kumar", "Anbalagan","dineshk12102000@gmail.com"),
                new Person("Anandh", "Andrews","dineshk12102000@gmail.com"),
                new Person("Abdul", "Rahman","dineshk12102000@gmail.com"));
        add(grid);

    }
    private static boolean isValidEmail(String email) {
        if (email == null) return false;

        String regex = "^" + "([a-zA-Z0-9_.\\-+])+" // local
                + "@" + "[a-zA-Z0-9-.]+" // domain
                + "\\." + "[a-zA-Z0-9-]{2,}" // tld
                + "$";

        return Pattern.compile(regex).matcher(email).matches();
    }

    private static void showErrorNotification(String msg) {
        Notification notification = new Notification(msg, 5000,
                Notification.Position.MIDDLE
        );
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.open();
    }
}
