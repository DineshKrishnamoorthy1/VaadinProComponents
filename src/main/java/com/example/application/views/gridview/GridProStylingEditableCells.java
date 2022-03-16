package com.example.application.views.gridview;


import com.example.application.views.crudexample.DataService;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.gridpro.GridPro;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;


@Route("vaadin-grid-pro-editable-cells")
@CssImport(value = "./styles/vaadin-grid-pro-editable-cells.css",themeFor = "vaadin-grid")

public class GridProStylingEditableCells extends Div {

    public GridProStylingEditableCells() {
        // tag::snippet[]
        GridPro<Person> grid = new GridPro<>();
        grid.addClassNames("editable-custom-effect");

        grid.addColumn(Person::getFirstName).setHeader("First name");
        grid.addColumn(Person::getLastName).setHeader("Last name");

        grid.addEditColumn(Person::getEmail)
                .text(Person::setEmail)
                .setHeader("Email (Editable)");
        // end::snippet[]

        grid.setItems(
                new Person("Dinesh", "Krishnamoorthy","dineshk12102000@gmail.com"),
                new Person("Ajith Kumar", "Anbalagan","dineshk12102000@gmail.com"),
                new Person("Anandh", "Andrews","dineshk12102000@gmail.com"),
                new Person("Abdul", "Rahman","dineshk12102000@gmail.com"));

        add(grid);
    }

}




