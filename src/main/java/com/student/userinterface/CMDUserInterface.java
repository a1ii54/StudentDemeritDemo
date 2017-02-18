package com.student.userinterface;

import com.student.service.StudentServiceInterface;

import java.util.Scanner;

public class CMDUserInterface implements Runnable {

    private StudentServiceInterface studentServiceInterface;
    private Scanner scanner;

    public CMDUserInterface(StudentServiceInterface studentServiceInterface) {
        this.studentServiceInterface = studentServiceInterface;
        scanner = new Scanner(System.in);
    }


    public void run() {
        try{
            String input;
            do{
                input = scanner.nextLine();
                System.out.println("For the lolz");
            }while ("exit".equalsIgnoreCase(input) == false);

        } catch (Throwable t){
            t.printStackTrace();
        }
    }
}
