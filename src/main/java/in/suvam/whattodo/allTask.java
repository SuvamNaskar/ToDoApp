package in.suvam.whattodo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class allTask {
    List<String> name = new ArrayList<String>();
    List<String> time = new ArrayList<String>();
    List<String> id = new ArrayList<String>();
    int i = 0;
    public int[] Size;

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
            ResultSet result = stmt.executeQuery("SELECT * FROM tasks ORDER BY task_time ASC;");
            for(i = 0; i < 10 && result.next(); i++)
            {
                id.add(Integer.toString(result.getInt(1)));
                name.add(result.getString(2));
                time.add(result.getString(3));
            }
            conn.close();
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        i = 0;
        Size = new int[id.size()];
    }

    public String getID()
    {
        System.out.println();
        System.out.println(id.get(i-1));
        return id.get(i-1);
    }

    public String getName()
    {
        return name.get(i);
    }

    public String getTime()
    {
        return time.get(i++);
    }

    @Override
    public String toString() {
        return "allTask [name=" + name + ", time=" + time + ", id=" + id + "]";
    }
}
