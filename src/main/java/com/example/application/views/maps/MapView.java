package com.example.application.views.maps;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.router.Route;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Route(value = "Maps",layout = MainLayout.class)
public class MapView extends Div {

    public MapView() {
    }



   /* private Component addmap()
    {
        HorizontalLayout h1=new HorizontalLayout();
        Map map=new Map() {
            @Override
            public int size() {
                return 0;
            }
        }
        return h1;
    }*/
}
