package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb",
                    "root",
                    "developerCamu*@");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from students");

            while (resultSet.next()){
                int studentId = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                String[]studentsSurname = {lastName};

                System.out.println("Students name: " + firstName);
                System.out.println("surname " + Arrays.toString(studentsSurname));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
