package com.example.test1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.mariuszgromada.math.mxparser.Expression;
import java.util.regex.Pattern;

public class HelloController {
    @FXML
    private Label resultado;
    @FXML
    private Button igual;
    @FXML
    private Button resta;
    @FXML
    private Button division;
    @FXML
    private Button suma;
    @FXML
    private Button multiplicacion;

    String linea ="";
    public void onClick(MouseEvent actionEvent) {
        igual.setDisable(false);
        String leernum=((Button)actionEvent.getSource()).getText();
        if (!linea.isEmpty() && leernum.equals(".")){
            if (!(linea.charAt(linea.length()-1)=='.')){
                if ((Pattern.compile("[x+/-]$").matcher(linea).find())) {
                    linea = linea + "0" + leernum;
                }else linea = linea +leernum;
            }
        }else{
            linea = linea +leernum;
        }
        if (linea.charAt(linea.length()-1)=='.'){
            igual.setDisable(true);
            resta.setDisable(true);
            multiplicacion.setDisable(true);
            suma.setDisable(true);
            division.setDisable(true);
        }else{
            igual.setDisable(false);
            resta.setDisable(false);
            multiplicacion.setDisable(false);
            suma.setDisable(false);
            division.setDisable(false);
        }
        resultado.setText(linea);
    }

    public void Operation(MouseEvent mouseEvent) {
        String leernum=((Button)mouseEvent.getSource()).getText();
        if ((Pattern.compile("[x+/-]$").matcher(linea).find())){
            igual.setDisable(true);
        }else{
            linea=linea+leernum;
            igual.setDisable(true);
            resultado.setText(linea);
        }
    }

    public void borrarUltimo(MouseEvent mouseEvent) {
        if (!(linea.length()==0))linea=linea.substring(0,linea.length()-1);
        resultado.setText(linea);
    }

    public void porcentaje(MouseEvent mouseEvent) {
        if ((Pattern.compile("[x+/-]$").matcher(linea).find())){
            borrarUltimo(mouseEvent);
        }
        calcular(mouseEvent);
        double result=Double.parseDouble(resultado.getText());
        Double porcentaje=result/100;
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
        if(fin.equals("NaN")){
            linea=fin;
            resultado.setText(fin);
            linea="";
        }else{
            linea=fin;
            resultado.setText(fin);
        }
    }
}