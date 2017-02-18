package com.student.userinterface.menus;

import com.student.service.StudentServiceInterface;

import java.util.Scanner;
import java.util.function.BiConsumer;

public class LoginUserInterface extends AbstractMenuInterface implements BiConsumer<Scanner, StudentServiceInterface> {

    @Override
    public void accept(Scanner scanner, StudentServiceInterface studentServiceInterface) {
        loginMenu(scanner, studentServiceInterface);
    }

    private void loginMenu(Scanner scanner, StudentServiceInterface studentServiceInterface) {

        System.out.println("Big Whhooooop -> Login");

    }

}
