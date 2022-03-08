package com.example.application.views.crudexample;


import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.crud.BinderCrudEditor;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.crud.CrudEditor;
import com.vaadin.flow.component.crud.CrudI18n;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.List;

@Route(value = "crud-open-editor",layout = MainLayout.class)
public class CrudOpenEditor extends Div {

    private Crud<Person> crud;
    private PersonDataProvider dataProvider;


    private String FIRST_NAME = "firstName";
    private String LAST_NAME = "lastName";
    private String EMAIL = "email";
    private String PROFESSION = "profession";
    private String EDIT_COLUMN = "vaadin-crud-edit-column";


    public CrudOpenEditor() {
        crud = new Crud<>(Person.class, createEditor());
        crud.addNewListener(event -> {
            Person person = event.getItem();
            person.setEmail("@zucisystems.com");
            person.setProfession("Developer");
            crud.getEditor().setItem(person);
        });

        setupGrid();
        setupDataProvider();
        setupI18n();
        add(crud);
    }

    private Grid<Person> createGrid() {
        Grid<Person> grid = new Grid<>();
        grid.addColumn(Person::getFirstName).setHeader("First name").setSortable(true);
        grid.addColumn(Person::getLastName).setHeader("Last name").setSortable(true);
        grid.addColumn(Person::getEmail).setHeader("Email").setSortable(true);
        grid.addColumn(Person::getProfession).setHeader("Profession").setSortable(true);
        return grid;
    }


    private CrudEditor<Person> createEditor() {
        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");
        EmailField email = new EmailField("Email");
        TextField profession = new TextField("Profession");
        FormLayout form = new FormLayout(firstName, lastName, email, profession);

        Binder<Person> binder = new Binder<>(Person.class);
        binder.forField(firstName).asRequired().bind(Person::getFirstName, Person::setFirstName);
        binder.forField(lastName).asRequired().bind(Person::getLastName, Person::setLastName);
        binder.forField(email).asRequired().bind(Person::getEmail, Person::setEmail);
        binder.forField(profession).asRequired().bind(Person::getProfession, Person::setProfession);

        return new BinderCrudEditor<>(binder, form);
    }

    private void setupGrid() {
        Grid<Person> grid = crud.getGrid();


        grid.addItemDoubleClickListener(event ->
                crud.edit(event.getItem(), Crud.EditMode.EXISTING_ITEM)
        );

        // Only show these columns (all columns shown by default):
        List<String> visibleColumns = Arrays.asList(
                FIRST_NAME,
                LAST_NAME,
                EMAIL,
                PROFESSION,
                EDIT_COLUMN
        );
        grid.getColumns().forEach(column -> {
            String key = column.getKey();
            if (!visibleColumns.contains(key)) {
                grid.removeColumn(column);
            }
        });

        // Reorder the columns (alphabetical by default)
        grid.setColumnOrder(
                grid.getColumnByKey(FIRST_NAME),
                grid.getColumnByKey(LAST_NAME),
                grid.getColumnByKey(EMAIL),
                grid.getColumnByKey(PROFESSION),
                grid.getColumnByKey(EDIT_COLUMN)
        );
    }


    private void setupDataProvider() {
        PersonDataProvider dataProvider = new PersonDataProvider();
        crud.setDataProvider(dataProvider);
        crud.addDeleteListener(deleteEvent ->
                dataProvider.delete(deleteEvent.getItem())
        );
        crud.addSaveListener(saveEvent ->
                dataProvider.persist(saveEvent.getItem())
        );
    }
    private void setupI18n() {
        CrudI18n i18n = CrudI18n.createDefault();

        i18n.setNewItem("Luo uusi");
        i18n.setEditItem("Muuta tietoja");
        i18n.setSaveItem("Tallenna");
        i18n.setCancel("Peruuta");
        i18n.setDeleteItem("Poista...");
        i18n.setEditLabel("Muokkaa");

        CrudI18n.Confirmations.Confirmation delete = i18n.getConfirm().getDelete();
        delete.setTitle("Poista kohde");
        delete.setContent("Haluatko varmasti poistaa tämän kohteen? Poistoa ei voi perua.");
        delete.getButton().setConfirm("Poista");
        delete.getButton().setDismiss("Peruuta");

        CrudI18n.Confirmations.Confirmation cancel = i18n.getConfirm().getCancel();
        cancel.setTitle("Hylkää muutokset");
        cancel.setContent("Kohteessa on tallentamattomia muutoksia.");
        cancel.getButton().setConfirm("Hylkää");
        cancel.getButton().setDismiss("Peruuta");

        crud.setI18n(i18n);
    }


}
