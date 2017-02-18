package com.student.userinterface.menus;

import com.student.model.User;
import com.student.service.StudentServiceInterface;

import java.util.*;
import java.util.function.BiConsumer;

public class RegistrationUserInterface extends AbstractFormInterface implements BiConsumer<Scanner, StudentServiceInterface> {

    @Override
    public void accept(Scanner scanner, StudentServiceInterface studentServiceInterface) {
        regisatrationMenu(scanner, studentServiceInterface);
    }



    private void regisatrationMenu(Scanner scanner, StudentServiceInterface studentServiceInterface) {

        String formName = "Registration Form";
        ArrayList<String> fields = new ArrayList<>();
        fields.add("Username");
        fields.add("Firstname");
        fields.add("Surname");
        fields.add("Password");
        Map<String, String> answers = new HashMap<>();

        doForm(scanner, formName, fields, answers);

        if(answers.size() == 4){
            User user = new User(
                    UUID.randomUUID().toString(),
                    answers.get("Username"),
                    answers.get("Firstname"),
                    answers.get("Surname"),
                    answers.get("Password")
            );

            studentServiceInterface.registerUser(user);
        }
    }

}
