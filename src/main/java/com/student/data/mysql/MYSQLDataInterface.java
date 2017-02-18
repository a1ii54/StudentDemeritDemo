package com.student.data.mysql;

import com.student.data.DataInterface;
import com.student.model.User;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.UUID;

public class MYSQLDataInterface implements DataInterface {

    private Connection getDBConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDemeritSystem?" +
                    "user=root&password=password&useSSL=false");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private boolean tableExists(String tableName){
        Connection conn = null;
        String SQL = "SHOW TABLES LIKE ?;";
        PreparedStatement checkTable = null;
        ResultSet resultSet = null;

        conn = getDBConnection();
        try {
            checkTable = conn.prepareStatement(SQL);
            checkTable.setString(1, tableName);
            resultSet = checkTable.executeQuery();
            if(resultSet !=null && resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                close(conn, checkTable, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    private void close(Connection conn, PreparedStatement checkTable, ResultSet resultSet) throws SQLException {
        if (resultSet !=null){
            resultSet.close();
        }
        if (checkTable != null){
            checkTable.close();
        }
        if(conn != null){
            conn.close();
        }
    }

    private void createUserLoginTable(){
        Connection conn = null;
        String SQL = "CREATE TABLE userLogin (" +
                "id VARCHAR (50)," +
                "username VARCHAR (30)," +
                "firstname VARCHAR (30)," +
                "surname VARCHAR (30)," +
                "password VARCHAR (30)," +
                "PRIMARY KEY (id));";
        PreparedStatement createTable = null;

        conn = getDBConnection();
        try {
            createTable = conn.prepareStatement(SQL);
            createTable.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                close(conn, createTable, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addUser(User user) {
        Connection conn = null;
        String SQL = "INSERT INTO userLogin VALUES(?, ?, ?, ?, ?)";
        PreparedStatement insert = null;

        conn = getDBConnection();
        try {
            insert = conn.prepareStatement(SQL);
            insert.setString(1, user.getId());
            insert.setString(2, user.getUsername());
            insert.setString(3, user.getFirstname());
            insert.setString(4, user.getSurname());
            insert.setString(5, user.getPassword());
            insert.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                close(conn, insert, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean validateUser(User user) {
        Connection conn = null;
        String SQL = "SELECT 1 FROM userLogin WHERE username = ? AND password = ?;";
        PreparedStatement select = null;
        ResultSet resultSet = null;

        conn = getDBConnection();
        try {
            select = conn.prepareStatement(SQL);
            select.setString(1, user.getUsername());
            select.setString(2, user.getPassword());
            resultSet = select.executeQuery();
            if(resultSet !=null && resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                close(conn, select, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void registerUserLoginAttempt(User user, boolean susscesful) {

    }

    public static void main(String[] args) {
//        MYSQLDataInterface mysqlDataInterface = new MYSQLDataInterface();
//        boolean usersExist = mysqlDataInterface.tableExists("userLogin");
//        if(!usersExist){
//            mysqlDataInterface.createUserLoginTable();
//        }
//        System.out.println(mysqlDataInterface.tableExists("userLogin"));
//
//        User user = new User(UUID.randomUUID().toString(), "jnaidoo", "Jarred", "Naidoo", "password");
//
//        mysqlDataInterface.addUser(user);
//
//        User userValid = new User(null, "jnaidoo", null, null, "password");
//        boolean isValid = mysqlDataInterface.validateUser(userValid);
//        System.out.println(isValid);
//
//        User userInvalid = new User(null, "jnadoo", null, null, "blah blah");
//        isValid= mysqlDataInterface.validateUser(userInvalid);
//        System.out.println(isValid);
    }
}
