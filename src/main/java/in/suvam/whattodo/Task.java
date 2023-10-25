package in.suvam.whattodo;

public class Task {
    private String name;
    private String time;
    
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

    @Override
    public String toString() {
        return "Task [name=" + name + ", time=" + time + "]";
    }
}
