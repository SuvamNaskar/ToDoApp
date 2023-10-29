package in.suvam.whattodo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class allTask {
    public List<String> name=new ArrayList<String>();
    public List<String> time=new ArrayList<String>();
    int i = 0;

    private final String url = "jdbc:mysql://localhost:2023/ToDo";
    private final String username = "root";
    private final String password = "system32";

    void fetchName()
    {
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM tasks;");
            for(i = 0; i < 10 && result.next(); i++)
            {
                name.add(result.getString(2));
                time.add(result.getString(3));
            }
            conn.close();
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        for (String string : name) {
            System.out.println(string);
        }
        for (String string : time) {
            System.out.println(string);
        }
    }

    @Override
    public String toString() {
        return "allTask [name=" + name + ", time=" + time + "]";
    }
}
