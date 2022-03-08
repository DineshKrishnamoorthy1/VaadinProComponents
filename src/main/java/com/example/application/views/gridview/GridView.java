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


    public GridView() {
        GridPro<Person> grid = new GridPro<>();
        grid.setEditOnClick(true);
        grid.setEnterNextRow(true);


        grid.addColumn(Person::getFirstName)
                .setHeader("First name(Read Only)");

        grid.addEditColumn(Person::getLastName)
                .text(Person::setLastName)
                .setHeader("Last name(Editable)");
        grid.setItems(
                new Person("Dinesh", "Krishnamoorthy"),
                new Person("Ajith Kumar", "Anbalagan"),
                new Person("Anandh", "Andrews"),
                new Person("Abdul", "Rahman"));
        add(grid);

    }
}
