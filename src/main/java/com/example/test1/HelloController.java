package com.example.test1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private Label resultado;
    @FXML
    private Button num1;

    String num="";
    String operador="";
    public void onClick(MouseEvent actionEvent) {
        String leernum=((Button)actionEvent.getSource()).getText();
        num=num+leernum;
        resultado.setText(num);
    }

    public void Operation(MouseEvent mouseEvent) {
        String leernum=((Button)mouseEvent.getSource()).getText();
        int result=Integer.parseInt(resultado.getText());
        switch (leernum){
            case "%":
                Double porcentaje=(Double.parseDouble(String.valueOf(result)))/100;
                resultado.setText(String.valueOf(porcentaje));
                break;
            case "-":
                break;
            case "/":
                break;
            case "+":
                break;
            case "x":
                break;
        }
    }
}