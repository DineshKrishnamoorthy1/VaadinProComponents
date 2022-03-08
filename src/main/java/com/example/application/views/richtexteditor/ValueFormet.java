package com.example.application.views.richtexteditor;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.component.richtexteditor.RichTextEditorVariant;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("ValueFormet")
public class ValueFormet extends Div {
    public ValueFormet() {
        TextArea textArea = new TextArea("Html Value", "Type html string here to set it as value to the Rich Text Editor above...");
        textArea.setWidthFull();

        RichTextEditor rte = new RichTextEditor();
        rte.getStyle().set("max-height", "400px");
        rte.addThemeVariants(RichTextEditorVariant.LUMO_COMPACT);


        rte.asHtml().addValueChangeListener(e -> textArea.setValue(e.getValue()));
        textArea.addValueChangeListener(e -> {
            if (!rte.asHtml().getValue().equals(e.getValue())) {
                rte.asHtml().setValue(e.getValue());
            }
        });
        add(rte, textArea);
    }
}
