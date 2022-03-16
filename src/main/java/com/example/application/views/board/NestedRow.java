package com.example.application.views.board;

import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.board.Row;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("nest")
public class NestedRow extends Div {

    public NestedRow() {
        nestedRowsWrapAccordingToParentSize();

    }


        private void nestedRowsWrapAccordingToParentSize() {

            Board board = new Board();
            H1 h1=new H1("Nested Row");
            add(h1);
            Div child1 = createComponent("This could be chart 1");
            Div child2 = createComponent("This could be chart 2");
            Div child3 = createComponent("This could be chart 3");

            Div child4a = createComponent("This could be chart 4A");
            Div child4b = createComponent("This could be chart 4B");

            Row nested = new Row(child4a, child4b);
            board.addRow(child1, child2,child3,nested);


            add(board);
        }
        private Div createComponent(String text) {
            Div div = new Div();

            div.setText(text);
            return div;
        }

    }

