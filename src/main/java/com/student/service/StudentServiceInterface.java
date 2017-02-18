package com.student.service;

import com.student.model.User;

public interface StudentServiceInterface {

    public void registerUser(User user);

    public boolean login(User user);
}
