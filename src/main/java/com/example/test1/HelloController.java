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
    private Button num1;

    String linea ="";
    public void onClick(MouseEvent actionEvent) {
        String leernum=((Button)actionEvent.getSource()).getText();
        linea = linea +leernum;
        resultado.setText(linea);
    }

    public void Operation(MouseEvent mouseEvent) {
        String fin;
        String leernum=((Button)mouseEvent.getSource()).getText();
        switch (leernum){
            case "%":
                int result=Integer.parseInt(resultado.getText());
                Double porcentaje=(Double.parseDouble(String.valueOf(result)))/100;
                linea= String.valueOf(porcentaje);
                resultado.setText(linea);
                break;
            case "C":
                linea="";
                resultado.setText("0");
                break;
            case "-":
            case "/":
            case "+":
            case "x":
                linea=linea+leernum;
                resultado.setText(linea);
                break;
            case "=":
                linea=linea.replace("x","*");
                Expression expression=new Expression(linea);
                fin= String.valueOf(expression.calculate());
                linea=fin;
                resultado.setText(fin);
                break;
        }
    }

    public void borrarUltimo(MouseEvent mouseEvent) {
        linea=linea.substring(0,linea.length()-1);
        System.out.println(linea);
        resultado.setText(linea);
    }
//    public void añadir(MouseEvent mouseEvent) {
//        Pattern comprobarOperadores = Pattern.compile("[+*/-]");
//        Pattern comprobarOperandos = Pattern.compile("[0-9]");
//        Button botonPulsado = (Button) mouseEvent.getSource();
//
//
//        //Escribe operadores
//        if (comprobarOperandos.matcher(botonPulsado.getText()).find()) {
//            limit = 0;
//            primerUso = 1;
//            operacionTexto = operacionTexto.concat(botonPulsado.getText());
//            textoResultado.setText(operacionTexto);
//        }
//
//        if (comprobarOperadores.matcher(botonPulsado.getText()).find() && limit == 0 && primerUso != 0) {
//            limit = 1;
//            limitePunto = 0;
//            operacionTexto = operacionTexto.concat(botonPulsado.getText());
//            textoResultado.setText(operacionTexto);
//        }
//        //Escribe operandos que resetea
//
//        if (botonPulsado.getText().equals(".") && limitePunto == 0) {
//            limitePunto = 1;
//            operacionTexto = operacionTexto.concat(botonPulsado.getText());
//            textoResultado.setText(operacionTexto);
//        }
//    }
}