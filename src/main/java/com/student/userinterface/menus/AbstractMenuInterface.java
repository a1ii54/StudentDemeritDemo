package com.student.userinterface.menus;

import com.student.service.StudentServiceInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiConsumer;

public class AbstractMenuInterface {

    protected void doMenu(Scanner scanner, StudentServiceInterface studentServiceInterface, String menuName, Map<String, String> menuItems, String exitKey, Map<String, BiConsumer<Scanner, StudentServiceInterface>> menuOptions) {
        boolean isValidInput = false;
        boolean shouldExit = false;
        do{
            System.out.println(menuName);
            System.out.println("==============================================");
            System.out.println("Please select an options from the list below:");
            for(String key : menuItems.keySet()){
                System.out.println(key + ". " + menuItems.get(key));
            }

            String input = scanner.nextLine();
            isValidInput = isValidInput(input, menuItems.keySet());

            if(isValidInput){
                shouldExit = shouldExit(input, exitKey);
                if(!shouldExit){
                    menuOptions.get(input).accept(scanner, studentServiceInterface);
                }
            }

        } while(isValidInput && !shouldExit);
    }

    private boolean shouldExit(String input, String exitKey) {
        if(exitKey == null){
            return false;
        }

        return exitKey.equals(input);

    }

    private boolean isValidInput(String input, Set<String> validInput) {
        return validInput.contains(input);
    }
}
