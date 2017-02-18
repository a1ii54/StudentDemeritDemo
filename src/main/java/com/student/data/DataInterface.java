package com.student.data;

import com.student.model.User;

public interface DataInterface {

    public void addUser(User user);

    public boolean validateUser(User user);

    public void registerUserLoginAttempt(User user, boolean susscesful);
}
