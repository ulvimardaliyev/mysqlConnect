package task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        //mysql connection elements and sql statement to execute
        String url, username, password, sql;

        username = "root";

        password = "ulvi291136";

        url = "jdbc:mysql://127.0.0.1:3306/webapp";

        System.out.println("please enter an id number");
        int id = scanner.nextInt();

        System.out.println("please enter your last name");
        String last_name = scanner.next();

        System.out.println("please enter your first name");
        String first_name = scanner.next();

        System.out.println("please enter your email");
        String email = scanner.next();


        sql = "insert into users"
                + "(id, last_name, first_name, email)"
                + " values (?, ?, ?, ?)";

        try  {
            connection = DriverManager.getConnection(url, username, password);

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.setString(2, last_name);

            preparedStatement.setString(3,first_name);

            preparedStatement.setString(4, email);

            preparedStatement.executeUpdate();

            System.out.println("Connected and inserted");

            System.out.println("last id is: "+ id);

        } catch (Exception e) {

            System.out.println(e);

        } finally {
            
            scanner.close();
            
            connection.close();
            
            preparedStatement.close();
            
            System.out.println("Done");
        }

    }
}
