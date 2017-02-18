package com.student.userinterface.Forms;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class AbstractFormInterface {

    protected void doForm(Scanner scanner, String formName, ArrayList<String> fields, Map<String, String> answers) {
        System.out.println(formName);
        System.out.println("==================================");
        System.out.println("Please enter the requested fields:");

        fields.forEach((field) -> {

            boolean isInputInvalid = true;
            do{
                System.out.println(field + ": ");
                String input = scanner.nextLine();
                isInputInvalid = isInputInvalid(input);
                if(isInputInvalid){
                    System.out.println("Input Invalid!");
                } else {
                    answers.put(field, input);
                }
            } while(isInputInvalid);
        });
    }

    private boolean isInputInvalid(String input) {
        return input == null || input.length() < 1;
    }
}
