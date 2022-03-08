package com.example.application.views.gridview;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.gridpro.GridPro;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;

@Route("testing")

public class Gridviewtesting extends Div {

    private ListDataProvider<Person> dataProvider;
    private Grid.Column<Person> firstnamecolumn;
    private Grid.Column<Person> lastnamecolumn;
    public Gridviewtesting() {
        GridPro<Person> grid = new GridPro<>(Person.class);
        grid.setEditOnClick(true);
        grid.setSingleCellEdit(true);

        grid.setItems(
                new Person("Dinesh", "Krishnamoorthy"),
                new Person("Ajith Kumar", "Anbalagan"),
                new Person("Anandh", "Andrews"),
                new Person("Abdul", "Rahman"));
        add(grid);

    }
}
