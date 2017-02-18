package com.student.userinterface.menus;

import com.student.service.StudentServiceInterface;
import com.student.userinterface.Forms.LoginUserInterface;
import com.student.userinterface.Forms.RegistrationUserInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class MainMenuInterface extends AbstractMenuInterface implements BiConsumer<Scanner, StudentServiceInterface>{

    @Override
    public void accept(Scanner scanner, StudentServiceInterface studentServiceInterface) {
        mainMenu(scanner, studentServiceInterface);
    }

    private void mainMenu(Scanner scanner, StudentServiceInterface studentServiceInterface) {

        String menuName = "Main Menu";
        Map<String, String> menuItems = new HashMap<>();
        menuItems.put("1", "Registration");
        menuItems.put("2", "Login");
        menuItems.put("0", "Exit");

        String exitKey = "0";

        Map<String, BiConsumer<Scanner, StudentServiceInterface>> menuOptions = new HashMap<>();
        menuOptions.put("1", new RegistrationUserInterface());
        menuOptions.put("2", new LoginUserInterface());


        doMenu(scanner, studentServiceInterface, menuName, menuItems, exitKey, menuOptions);
    }
}
