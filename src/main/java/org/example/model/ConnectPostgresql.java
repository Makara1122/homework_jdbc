package org.example.model;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectPostgresql {

    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String uername = "postgres";
    private String password = "010104";

    private Connection connection;
    public ConnectPostgresql(){
        try{
//            I try to connect java jdbc driver
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,uername,password);
            System.out.println("Connceted succesffully with postgres !!");
        }catch (ClassNotFoundException | SQLException exception){
            exception.printStackTrace();
        }


    }

//    I get the connection
    public Connection getConnection(){
        return connection;
    }

//    I close the connection

    public void closeConnection() {
        try {
            if(connection != null && !connection.isClosed()){
                connection.isClosed();
                System.out.println("Connection closed !! ");
            };
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

}
