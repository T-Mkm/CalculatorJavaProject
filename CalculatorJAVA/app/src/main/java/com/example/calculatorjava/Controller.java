package com.example.calculatorjava;


import android.annotation.SuppressLint;
import android.view.View;

public class Controller implements View.OnClickListener {

    private Model model;
    private String command;

    public Controller(MainActivity viewer) {
        model = new Model(viewer);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.buttonOne:
                command = "1";
                break;
            case R.id.buttonTwo:
                command = "2";
                break;
            case R.id.buttonThree:
                command = "3";
                break;
            case R.id.buttonFour:
                command = "4";
                break;
            case R.id.buttonFive:
                command = "5";
                break;
            case R.id.buttonSix:
                command = "6";
                break;
            case R.id.buttonSeven:
                command = "7";
                break;
            case R.id.buttonEight:
                command = "8";
                break;
            case R.id.buttonNine:
                command = "9";
                break;
            case R.id.buttonZero:
                command = "0";
                break;
            case R.id.buttonAllClear:
                command = "AC";
                break;
            case R.id.buttonClear:
                command = "C";
                break;
            case R.id.buttonDelete:
                command = "Del";
                break;
            case R.id.buttonDivide:
                command = "/";
                break;
            case R.id.buttonMultiply:
                command = "*";
                break;
            case R.id.buttonPlus:
                command = "+";
                break;
            case R.id.buttonMinus:
                command = "-";
                break;
            case R.id.buttonEqual:
                command = "=";
                break;
            case R.id.buttonDot:
                command = ",";
                break;
            case R.id.buttonPlusMinus:
                command = "+/-";
                break;
            default:
                break;
        }

        model.doAction(command);
    }
}