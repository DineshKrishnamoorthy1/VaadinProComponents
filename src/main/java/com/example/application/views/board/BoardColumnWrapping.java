package com.example.application.views.board;

import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.Route;

@Route("columnwarping")
@CssImport(value = "./styles/board.css")
public class BoardColumnWrapping extends Div {
    public BoardColumnWrapping() {

        Board board = new Board();
        board.addRow(
                createCell("Cell 1"),
                createCell("Cell 2")
        );

        SplitLayout splitLayout = new SplitLayout(board, new Div());
        addClassName("board-column-wrapping");
        add(splitLayout);
    }

    private static Div createCell(String text) {
        Div div = new Div();
        div.setText(text);
        div.addClassNames("cell", "color");

        return div;
    }

}
