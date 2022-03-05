package com.example.application.views.crud;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route(value = "Crud",layout = MainLayout.class)
public class Display extends Div {
    private CustomerService service = CustomerService.getInstance();
    private Grid<Customer> grid = new Grid<>(Customer.class);
    private TextField filterText = new TextField();
    CustomerForm form = new CustomerForm();



    public Display() {
        grid.setColumns("firstName", "lastName", "status");
        add(grid);
        setSizeFull();
        updateList();
        filterbyname();
        add(filterText, grid);

        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(filterText, mainContent);

    }
    public void updateList() {
        grid.setItems(service.findAll());
        grid.setItems(service.findAll(filterText.getValue()));
    }
    public void filterbyname()
    {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);

        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> updateList());

    }

}
