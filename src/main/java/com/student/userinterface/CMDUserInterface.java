package com.student.userinterface;

import com.student.service.StudentServiceInterface;
import com.student.userinterface.menus.MainMenuInterface;

import java.util.*;

public class CMDUserInterface implements Runnable {

    private StudentServiceInterface studentServiceInterface;
    private Scanner scanner;

    public CMDUserInterface(StudentServiceInterface studentServiceInterface) {
        this.studentServiceInterface = studentServiceInterface;
        scanner = new Scanner(System.in);
    }


    public void run() {
        try{
            new MainMenuInterface().accept(scanner, studentServiceInterface);
        } catch (Throwable t){
            t.printStackTrace();
        }
    }
}
