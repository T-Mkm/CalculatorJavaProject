package com.example.calculatorjava;


import java.util.List;

public class Model {
    private MainActivity viewer;
    private ExpressionParser parser;
    private Ideone ideone;
    private Boolean action;
    private String temp;
    private String expression;
    private String log;

    private String numbers = "0123456789";
    private String operators = "+-*/";

    public Model(MainActivity viewer) {
        this.viewer = viewer;
        this.parser = new ExpressionParser();
        this.ideone = new Ideone();
        expression = "";
        temp = "";
        log  = "";
        action = false;
    }

    public void doAction(String value) {

        if (numbers.contains(value)) {
            if (expression.length() > 0 && !operators.contains(expression.substring(expression.length() - 1))) {
                expression = "";
            }

            if (value.equals("0")) {
                if (temp.equals("") || temp.equals("0")){
                    temp = "0";
                } else {
                    temp = temp + value;
                }
            } else {
                if (temp.equals("0")){
                    temp = value;
                } else {
                    temp = temp + value;
                }
            }
            action = true;
        } else if (operators.contains(value)) {
            if (action){
                if (expression.equals("")){
                    expression = temp+" "+value;
                } else {
                    expression = expression+" "+temp+" "+value;
                }

                System.out.println(expression);
                temp = "";
                action = false;
            } else {
                String operator = expression.substring(expression.length() - 1);
                if (operators.contains(operator)){
                    expression = expression.substring(0, expression.length() - 1) + value;
                }
            }
        } else if (value.equals("=")) {
            String fullExpression = expression + " " + temp;
            if (expression.length() > 0 && temp.length() > 0) {
                List<String> parsedExpression = parser.parse(fullExpression);

                if (parser.getFlag()) {
                    log = log + ((log.length() > 0) ? "\n\n\r" : "") + fullExpression + " = ";
                    for (String x : parsedExpression) System.out.print(x + " ");
                    temp = ideone.calc(parsedExpression);

                    if (temp.equals("Infinity") || temp.equals("NaN")) {
                        temp = "0";
                        log = log + " Нельзя делить на 0";
                    } else {
                        log = log + " " + temp;
                        expression = temp;
                        temp = "";
                    }
                } else {
                    return;
                }
            } else {
                return;
            }

        } else if (value.equals("C")) {
            log = log + "\n\r";
            temp = "0";
            expression = "";
        } else if (value.equals("AC")){
            log  = "";
            temp = "0";
            expression = "";
        } else if (value.equals("Del")) {
            if (temp.length() > 0) {
                if (temp.length() == 1 || (temp.length() == 2 && temp.charAt(0) == '-')) {
                    action = false;
                    temp = "";
                } else {
                    temp = temp.substring(0, temp.length() - 1);
                }
            } else if (expression.length() > 0) {
                if (operators.contains(expression.substring(expression.length() - 1))) {
                    expression = expression.substring(0, expression.lastIndexOf(" "));
                    if (expression.contains(" ")) {
                        temp = expression.substring(expression.lastIndexOf(" ") + 1);
                        expression = expression.substring(0, expression.lastIndexOf(" "));
                        action = true;
                    } else {
                        temp = expression;
                        expression = "";
                    }
                }
            }
        } else if (value.equals(",")) {
            if (!temp.contains(".")) {
                action = true;
                if (temp.length() < 1) {
                    temp = "0.";
                } else {
                    temp = temp + ".";
                }
            }
        } else if (value.equals("+/-")) {
            if (temp.charAt(0) == '-') {
                temp = temp.substring(1);
            } else {
                temp = '-' + temp;
            }
        }

        viewer.update(expression + " " + temp, log);
    }

}