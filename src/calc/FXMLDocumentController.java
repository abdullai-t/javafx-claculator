package calc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author tachyon
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label op1Label;
    @FXML
    private Label op2Label;
    @FXML
    private Label operatorLabel;
    @FXML
    private Label resultLabel;

    private String val2 = "";
    private String val1 = "";

    private double num1;
    private double num2;
    private double Ans;

    // handles reset of  label textrProperty
    @FXML
    private void reset(ActionEvent e) {
        op1Label.setText("");
        op2Label.setText("");
        operatorLabel.setText("");
        Ans = 0;
        num1 = 0;
        num2 = 0;
        resultLabel.setText(Ans + "");

    }

    // handles all decimal checkings
    @FXML
    private void Decimal(ActionEvent e) {
        if (!op1Label.getText().contains(".") && "".equals(op2Label.getText())) {
            Button btn = (Button) e.getSource();
            String decimal = btn.getText();
            String oldT1 = op1Label.getText();
            op1Label.setText(oldT1 + decimal);
        }
        if (!op2Label.getText().contains(".") && !op2Label.getText().isEmpty()) {
            Button btn = (Button) e.getSource();
            String decimal = btn.getText();
            String oldT2 = op2Label.getText();
            op2Label.setText(oldT2 + decimal);
        }

    }
// handding all  the calculations

    @FXML
    private void Calculation(ActionEvent e) {
        switch (operatorLabel.getText()) {
            case "+":
                Ans = num1 + num2;
                resultLabel.setText(Ans + "");
                break;
            case "-":
                Ans = num1 - num2;
                resultLabel.setText(Ans + "");
                break;

            case "*":
                Ans = num1 * num2;
                resultLabel.setText(Ans + "");
                break;

            case "/":
                Ans = num1 / num2;
                resultLabel.setText(Ans + "");
                break;
        }

    }

    // handles the assignment of all inputs to various labels
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String op = btn.getText();
        if ("".equals(operatorLabel.getText())) {
            if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                operatorLabel.setText(op);
            } else {
                String oldText = op1Label.getText();
                val1 = btn.getText();
                op1Label.setText(oldText + val1);

                num1 = Double.parseDouble(op1Label.getText());

            }
        } else {
            if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
            } else {
                String oldText2 = op2Label.getText();
                val2 = btn.getText();
                op2Label.setText(oldText2 + val2);
                num2 = Double.parseDouble(op2Label.getText());
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        op1Label.setText("");
        op2Label.setText("");
        operatorLabel.setText("");
        resultLabel.setText(0 + "");
    }
}
