package com.example.application.views.gridview;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.gridpro.GridPro;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "GridView",layout = MainLayout.class)

public class GridView extends Div {

    /*private ListDataProvider<Person> dataProvider;
    private Grid.Column<Person> firstnamecolumn;
    private Grid.Column<Person> lastnamecolumn;
*/
    public GridView() {
/*

        GridPro<Person> grid = new GridPro<>(Person.class);
        grid.setItems(
                new Person("Dinesh", "Krishnamoorthy"),
                new Person("Ajith Kumar", "Anbalagan"),
                new Person("Anandh", "Andrews"),
                new Person("Abdul", "Rahman"));
                add(grid);

*/
        GridPro<Person> grid = new GridPro<>(Person.class);

        grid.addEditColumn(Person::getFirstName)
                .text(Person::setFirstName)
                .setHeader("First name");

        grid.addEditColumn(Person::getLastName)
                .text(Person::setLastName)
                .setHeader("Last name");
        grid.setItems(
                new Person("Dinesh", "Krishnamoorthy"),
                new Person("Ajith Kumar", "Anbalagan"),
                new Person("Anandh", "Andrews"),
                new Person("Abdul", "Rahman"));
        add(grid);

    }
}
