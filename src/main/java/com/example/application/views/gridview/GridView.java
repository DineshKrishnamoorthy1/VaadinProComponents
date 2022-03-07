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

    private ListDataProvider<Person> dataProvider;

    private Grid.Column<Person> firstnamecolumn;
    private Grid.Column<Person> lastnamecolumn;

    public GridView() {

        // Create a listing component for a bean type
        GridPro<Person> grid = new GridPro<>(Person.class);

// Sets items using vararg beans
        grid.setItems(
                new Person("Dinesh", "Krishnamoorthy"),
                new Person("Ajith Kumar", "Anbalagan"),
                new Person("Anandh", "Andrews"),
                new Person("Abdul", "Rahman")
        );
add(grid);


// or you can do it alternatively this way

    }
}
