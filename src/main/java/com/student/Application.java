package com.student;

import com.student.data.DataInterface;
import com.student.data.mysql.MYSQLDataInterface;
import com.student.service.DefaultStudentService;
import com.student.service.StudentServiceInterface;
import com.student.userinterface.CMDUserInterface;
import javafx.scene.chart.PieChart;

public class Application {

    private DataInterface dataInterface;
    private StudentServiceInterface studentServiceInterface;

    public static void main(String[] args) {

        DataInterface dataInterface = new MYSQLDataInterface();
        StudentServiceInterface studentServiceInterface = new DefaultStudentService(dataInterface);

        CMDUserInterface cmdUserInterface = new CMDUserInterface(studentServiceInterface);
        cmdUserInterface.run();

    }
}
