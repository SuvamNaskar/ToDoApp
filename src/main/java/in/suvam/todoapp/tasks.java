package in.suvam.todoapp;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class tasks {
    private String task;
    private String time;

    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "tasks [task=" + task + ", time=" + time + "]";
    }

    void addToDB()
    {
        final String url = "jdbc:mysql://localhost:2023/ToDo";
        final String username = "root";
        final String password = "system32";
        String query = "";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            query = "INSERT INTO Persons(task_name, task_time) VALUES('"+ task +"', '"+ time +"');";
            int out = stmt.executeUpdate(query);
            System.out.println(out + "rows updated.");
            conn.close();
        }
        catch(Exception tx)
        {
            tx.printStackTrace();
        }
    }
}