package in.suvam.todoapp;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class view {
    view()
    {
        final String url = "jdbc:mysql://localhost:2023/ToDo";
        final String username = "root";
        final String password = "system32";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM tasks");
            while(result.next())
            {
                int id = result.getInt(1);
                String task_name = result.getString(3);
                String task_time = result.getString(2);
                System.out.println(id + " " + task_name + " " + task_time);
            }

            conn.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
