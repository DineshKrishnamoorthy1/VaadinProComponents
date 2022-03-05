package com.example.application.views.gridpro;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.gridpro.GridPro;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.data.renderer.NumberRenderer;
import com.vaadin.flow.router.Route;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Route(value = "GridPro",layout = MainLayout.class)
public class GridProExample extends Div {
    private com.vaadin.flow.component.gridpro.GridPro<Person> grid;

   //gridListDataView = grid.setItems(clients);




    public GridProExample() {
        add(addingcolums());

    }




    private Component addingcolums()
    {
        GridPro<Person> grid = new GridPro<>();
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_COLUMN_BORDERS);
        grid.setHeight("100%");


       // List<Person> person = getPeople();
        GridListDataView<Person> gridListDataView;

       // gridListDataView = grid.setItems(person);

        grid.addEditColumn(Person::getFirstName)
                .text(Person::setFirstName)
                .setHeader("First name");

        grid.addEditColumn(Person::getLastName)
                .text(Person::setLastName)
                .setHeader("Last name");

        grid.addEditColumn(Person::getEmail)
                .text(Person::setEmail)
                .setHeader("Email");

        grid.addEditColumn(Person::getProfession)
                .text(Person::setProfession)
                .setHeader("Profession");

        add(grid);
        return grid;
        
    }


/*

    private List<Person> getPeople() {
        return Arrays.asList(createClient("Dinesh", "Krishnamoorthy", "dinesh.krishna@zucisystems.com", "SE"));


    }

    private Person createClient(String firstname, String lastname, String email, String profession) {
        Person p=new Person();
        p.setFirstName(firstname);
        p.setLastName(lastname);
        p.setEmail(email);
        p.setProfession(profession);
        return p;
    }
*/


}
