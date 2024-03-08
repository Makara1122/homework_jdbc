package org.example.controller;

import org.example.model.ConnectPostgresql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseControl {
    private ConnectPostgresql connectPostgresql;
    public  DatabaseControl(){
        connectPostgresql = new ConnectPostgresql();
    }
    public List<MyEntity> FetchDatabase() {
//        Example Query
        List<MyEntity> person = new ArrayList<>();

        String Query = "SELECT * FROM student_list";

        try(
                Connection connection = connectPostgresql.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                ResultSet resultSet = preparedStatement.executeQuery();
                ){
                while (resultSet.next()){

                    String first_name = resultSet.getString(1);
                    int id = resultSet.getInt(2);


                    MyEntity myEntity = new MyEntity(id,first_name);
                    person.add(myEntity);

                }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return person;
    }

//    method for insert new record

    public void insertNewRecord(){
        String insertQuery = "INSERT INTO student_list (name,age,gpa) values (?,?,?)";

        try
        {
            Connection connection = connectPostgresql.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1,"Sok mean");
            preparedStatement.setInt(2, 30);
            preparedStatement.setDouble(3,56.54);

            int rowEffect = preparedStatement.executeUpdate();


//            check the condition, we added new record or not

            if (rowEffect > 0){
                System.out.println("Insert successfully !!");
            }else {
                System.out.println("Insert Error !!");
            }
            connection.isClosed();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        connectPostgresql.closeConnection();
    }



}
