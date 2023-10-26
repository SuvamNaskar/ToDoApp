package in.suvam.whattodo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class allTask {
    private String name;
    private String time;

    private final String url = "jdbc:mysql://localhost:2023/ToDo";
    private final String username = "root";
    private final String password = "system32";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    void fetchName()
    {
        int loop = 1;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM tasks;");
            while(result.next())
            {
                name = result.getString(2);
                time = result.getString(3);
                System.out.println(name + " " + time);
            }
            loop = 0;

            conn.close();
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "allTask [name=" + name + ", time=" + time + "]";
    }
}
