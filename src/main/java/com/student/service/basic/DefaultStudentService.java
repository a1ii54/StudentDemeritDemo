package com.student.service.basic;

import com.student.data.DataInterface;
import com.student.model.User;
import com.student.service.StudentServiceInterface;

public class DefaultStudentService implements StudentServiceInterface {

    private DataInterface dataInterface;

    public DefaultStudentService(DataInterface dataInterface) {
        this.dataInterface = dataInterface;
    }

    public void registerUser(User user) {

        dataInterface.addUser(user);
    }

    public boolean login(User user) {
        return dataInterface.validateUser(user);
    }
}
