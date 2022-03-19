package com.example.application.views.GridProStyling;


import com.example.application.views.crudexample.DataService;
import com.example.application.views.gridview.Person;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.gridpro.GridPro;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;


@Route("vaadin-grid-pro-editable-cells")
//@CssImport(value = "./styles/vaadin-grid-pro-editable-cells.css",themeFor = "vaadin-grid")
//@CssImport(value = "./styles/vaadin-grid-pro-editable-cells.css");
// @import url(https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600&family=Poppins:wght@600;700&display=swap);
// @import url(https://cdn.vaadin.com/website/antlers/v2/assets/icons/css/line-awesome.min.css);
// @import url(https://cdn.vaadin.com/website/hubspot-theme/v2/haas/css/haas.css);

@CssImport(value = "./styles/vaadin-grid-pro.css",themeFor = "vaadin-grid")

public class GridProStylingEditableCells extends Div {

    public GridProStylingEditableCells() {
        GridPro<Person> grid = new GridPro<>();
        grid.addClassNames("editable-custom-effect");
        UI.getCurrent().getElement().getClassList().add("editable-custom-effect");

        grid.addColumn(Person::getFirstName).setHeader("First name");
        grid.addColumn(Person::getLastName).setHeader("Last name");

        grid.addEditColumn(Person::getEmail)
                .text(Person::setEmail)
                .setHeader("Email (Editable)");

        grid.setItems(
                new Person("Dinesh", "Krishnamoorthy","dineshk12102000@gmail.com"),
                new Person("Ajith Kumar", "Anbalagan","dineshk12102000@gmail.com"),
                new Person("Anandh", "Andrews","dineshk12102000@gmail.com"),
                new Person("Abdul", "Rahman","dineshk12102000@gmail.com"));


        add(grid);
    }

}




