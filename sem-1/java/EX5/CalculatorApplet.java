import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApplet extends Applet implements ActionListener {
    TextField tf1, tf2, tfResult;
    Button add, sub, mul, div;

    public void init() {
        Label l1 = new Label("Number 1:");
        Label l2 = new Label("Number 2:");
        Label l3 = new Label("Result:");

        tf1 = new TextField(10);
        tf2 = new TextField(10);
        tfResult = new TextField(10);
        tfResult.setEditable(false);

        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");

        add(l1); add(tf1);
        add(l2); add(tf2);
        add(l3); add(tfResult);

        add(add); add(sub); add(mul); add(div);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(tf1.getText());
            double num2 = Double.parseDouble(tf2.getText());
            double result = 0;

            if (e.getSource() == add) {
                result = num1 + num2;
            } else if (e.getSource() == sub) {
                result = num1 - num2;
            } else if (e.getSource() == mul) {
                result = num1 * num2;
            } else if (e.getSource() == div) {
                if (num2 != 0)
                    result = num1 / num2;
                else
                    tfResult.setText("Divide by 0!");
                return;
            }
            tfResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            tfResult.setText("Invalid Input");
        }
    }
}
