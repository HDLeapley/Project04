/**
 * Created by 014327 on 2/13/2019.
 */
public class Task implements Comparable<Task>{

    private int taskNum;
    private String title;
    private String description;
    private int priority;

    public Task(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }
    //Getters and setters for all properties.
    public int getTaskNum() {
        return taskNum;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public int getPriority() {
        return priority;
    }

    public void setTaskNum(int taskNum) {
        this.taskNum = taskNum;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Task o) {
        if (priority != (o.priority)) {
            if (priority>o.priority){
                return -1;
            }else{
                return 1;
            }
        }
        else {
            return title.compareTo(o.title);
        }
    }
}
