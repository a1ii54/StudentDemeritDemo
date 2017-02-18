package com.student.userinterface.menus;

import com.student.service.StudentServiceInterface;

import java.util.Scanner;
import java.util.function.BiConsumer;

public class RegistrationUserInterface extends AbstractMenuInterface implements BiConsumer<Scanner, StudentServiceInterface> {

    @Override
    public void accept(Scanner scanner, StudentServiceInterface studentServiceInterface) {
        regisatrationMenu(scanner, studentServiceInterface);
    }



    private void regisatrationMenu(Scanner scanner, StudentServiceInterface studentServiceInterface) {

        System.out.println("Big Whhooooop -> Registration");
    }

}
