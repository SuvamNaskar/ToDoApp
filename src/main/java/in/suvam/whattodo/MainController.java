package in.suvam.whattodo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private final String url = "jdbc:mysql://localhost:2023/ToDo";
    private final String username = "root";
    private final String password = "system32";

    @GetMapping("/add")
    public String showForm(Model model)
    {
        Task task = new Task();

        model.addAttribute("task", task);
        return "add_task";
    }

    @PostMapping("/add")
    public String submitForm(@ModelAttribute("task") Task task)
    {
        String query = "INSERT INTO tasks(task_name, task_time) VALUES('" + task.getName() + "', '" + task.getTime() + "');";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            int out = stmt.executeUpdate(query);
            System.out.println(out + " rows updated.");
            conn.close();
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println(task);
        return "task_success";
    }

    @GetMapping("/show")
    public String showTasks(Model model)
    {
        allTask tasks = new allTask();
        tasks.fetchName();
        System.out.println(tasks);
        model.addAttribute("tasks", tasks);
        // model.addAttribute("times", tasks.time);
        return "all_tasks";
    }
}