package com.example.test1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.mariuszgromada.math.mxparser.Expression;

public class HelloController {
    @FXML
    private Label resultado;

    String linea ="";
    public void onClick(MouseEvent actionEvent) {
        String leernum=((Button)actionEvent.getSource()).getText();
        if (!linea.isEmpty() && leernum.equals(".")){
            if (linea.charAt(linea.length()-1)=='.'){
            }else{
                linea = linea +leernum;
            }
        }else{
            linea = linea +leernum;
        }
        resultado.setText(linea);
    }

    public void Operation(MouseEvent mouseEvent) {

        String leernum=((Button)mouseEvent.getSource()).getText();
                linea=linea+leernum;
                resultado.setText(linea);
    }


    public void borrarUltimo(MouseEvent mouseEvent) {
        linea=linea.substring(0,linea.length()-1);
        System.out.println(linea);
        resultado.setText(linea);
    }

    public void porcentaje(MouseEvent mouseEvent) {
        int result=Integer.parseInt(resultado.getText());
        Double porcentaje=(Double.parseDouble(String.valueOf(result)))/100;
        linea= String.valueOf(porcentaje);
        resultado.setText(linea);
    }

    public void borrarTodo(MouseEvent mouseEvent) {
        linea="";
        resultado.setText("0");
    }

    public void calcular(MouseEvent mouseEvent) {
        String fin;
        linea=linea.replace("x","*");
        Expression expression=new Expression(linea);
        fin= String.valueOf(expression.calculate());
        linea=fin;
        resultado.setText(fin);
    }
}