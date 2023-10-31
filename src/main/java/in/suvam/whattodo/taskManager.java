package in.suvam.whattodo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class taskManager {
    private final String url = "jdbc:mysql://localhost:2023/ToDo";
    private final String username = "root";
    private final String password = "system32";

    String query = "DELETE FROM tasks WHERE id = ";
    
    void deleteViaId(String id)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            int out = stmt.executeUpdate(query + id + ";");
            System.out.println(out + " rows deleted.");
            conn.close();
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
