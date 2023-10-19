package in.suvam.todoapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class MainController {
    @PostMapping("/")
    public String submitForm(@ModelAttribute("task") tasks task) {
        System.out.println(task);
        return "view_tasks";
    }

    @GetMapping("/")
    public String showForm(Model model)
    {
        final String url = "jdbc:mysql://localhost:2023/ToDo";
        final String username = "root";
        final String password = "system32";
        
        List<String> listTasks = new ArrayList<>();
        
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
                    listTasks.add(task_name);
                    listTasks.add(task_time);
            }

            conn.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        model.addAttribute("listTasks", listTasks);

        return "view_tasks";
    }
}