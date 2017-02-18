package com.student.userinterface.Forms;

import com.student.model.User;
import com.student.service.StudentServiceInterface;

import java.util.*;
import java.util.function.BiConsumer;

public class LoginUserInterface extends AbstractFormInterface implements BiConsumer<Scanner, StudentServiceInterface> {

    @Override
    public void accept(Scanner scanner, StudentServiceInterface studentServiceInterface) {
        loginMenu(scanner, studentServiceInterface);
    }

    private void loginMenu(Scanner scanner, StudentServiceInterface studentServiceInterface) {

        String formName = "Login Form";
        ArrayList<String> fields = new ArrayList<>();
        fields.add("Username");
        fields.add("Password");
        Map<String, String> answers = new HashMap<>();

        doForm(scanner, formName, fields, answers);

        if(answers.size() == 2){
            User user = new User(
                    null,
                    answers.get("Username"),
                    null,
                    null,
                    answers.get("Password")
            );

            boolean success = studentServiceInterface.login(user);
            if(success){
                System.out.println("Login Successful!");
            } else {
                System.out.println("Login Failed!");
            }
        }

    }

}
