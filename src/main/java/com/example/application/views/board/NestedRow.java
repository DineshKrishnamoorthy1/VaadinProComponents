package com.example.application.views.board;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.board.Row;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("nest")
public class NestedRow extends Div {

    public NestedRow() {
        Row rootRow = new Row();
        rootRow.add(new H1("First Root"));


        Row nestedRow = new Row(
                new ExampleIndicator("Current users", "745", "+33.7"),
                new ExampleIndicator("Conversion rate", "18%", "+3.9")
        );
        rootRow.addNestedRow(nestedRow);

        Board board = new Board();
        board.add(rootRow);

        add(board);
        this.setClassName("board-nested");

    }
  /*  private void ExampleIndicator(String title, String value, Double percentage)
    {

    }*/

    private class ExampleIndicator extends Component {
        public ExampleIndicator(String title, String value, String percentage) {
            H2 h2 = new H2(title);
            Span span = new Span(value);
            Span badge = new Span(new Span(percentage.toString()));
            VerticalLayout layout = new VerticalLayout(h2, span, badge);
            layout.addClassName("p-l");
            layout.setPadding(false);
            layout.setSpacing(false);
            add(layout);
        }
    }
}
