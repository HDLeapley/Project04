import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by 014327 on 2/14/2019.
 */
public class TaskList implements Iterable<Task>{

    private Scanner scan = new Scanner(System.in);
    public ArrayList<Task> taskList = new ArrayList<>(); //Array list to hold tasks

    public void addTask(){ //Add a task method

        int taskPriority = 0;

        System.out.println("What is the task title?");
        String taskTitle = scan.nextLine(); //Ask user for task title

        System.out.println("What is the task description?");
        String taskDesc = scan.nextLine(); //Ask user for task description

        boolean validInput;
        do {
            try {
                System.out.println("What is the task priority(0-5)?");
                taskPriority = scan.nextInt();//Ask user for task priority
                scan.nextLine();
                if (-1<taskPriority && taskPriority<6) {
                    validInput = true;
                }else{
                    validInput = false;
                    System.out.println("Invalid input.");
                }
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Invalid input.");
                validInput = false;
            }
        }while(!validInput);
        Task task = new Task(taskTitle,taskDesc,taskPriority); //Create new tasks with input
        taskList.add(task);//Insert task into task list.

    }

    public void remTask(){

        int taskID = 0;
        boolean validInput = false;
        do {
            try {
                listTasks();
                System.out.println("What is the task you would like to remove?");
                taskID = Integer.parseInt(scan.nextLine());
                for (Task task : taskList){
                    if (task.getTaskNum() == taskID){
                        taskList.remove(task); //Remove task that has task num equaling
                        validInput = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                validInput = false;
            }
        }while(!validInput);
    }

    public void editTask(){
        int taskID = 0;
        boolean validInput = false;
        do {
            try {
                listTasks();
                System.out.println("What is the task you would like to edit?");
                taskID = Integer.parseInt(scan.nextLine()); //Asks what task you want to edit.
                for (Task task : taskList){
                    if (task.getTaskNum() == taskID){

                        int taskPriority = 0;

                        System.out.println("What would you like to change the title to?");
                        String taskTitle = scan.nextLine();

                        System.out.println("What would you like to change the description to?");
                        String taskDesc = scan.nextLine();

                        boolean validInput2;
                        do {
                            try {
                                System.out.println("What would you like to change the priority to?(0-5)");
                                taskPriority = scan.nextInt();
                                scan.nextLine();
                                if (-1<taskPriority && taskPriority<6) {
                                    validInput2 = true;
                                }else{
                                    validInput2 = false;
                                    System.out.println("Invalid input.");
                                }
                            } catch (Exception e) {
                                scan.nextLine();
                                System.out.println("Invalid input.");
                                validInput2 = false;
                            }
                        }while(!validInput2);
                        task.setTitle(taskTitle); //Update task title
                        task.setDescription(taskDesc); //Update task description
                        task.setPriority(taskPriority); //Update task priority
                        validInput = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                validInput = false;
            }
        }while(!validInput);
    }

    public void listTasks(){
        int ID = 1;
        for (int i=5;i>=0;i--){
            for (Task task : taskList){
                if(task.getPriority()==i){//Order all tasks based on task priority and set task number accordingly.
                    task.setTaskNum(ID);
                    System.out.println(task.getTaskNum() +") " + task.getTitle() + " ~ " + task.getPriority() +"\n" + task.getDescription());
                    ID++;
                }
            }
        }

    }
    public void listTasksPriority(){
        int taskPriority = 0;
        boolean validInput;
        do {
            try {
                System.out.println("What priority tasks would you like to see?(0-5)");
                taskPriority = scan.nextInt();
                scan.nextLine();
                if (-1<taskPriority && taskPriority<6) {
                    validInput = true;
                }else{
                    validInput = false;
                    System.out.println("Invalid input.");
                }
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Invalid input.");
                validInput = false;
            }
        }while(!validInput);
        for (Task task : taskList){
            if(task.getPriority()==taskPriority){//Order all tasks based on task priority and set task number accordingly.
                task.setTaskNum(taskPriority);
                System.out.println(task.getTaskNum() +") " + task.getTitle() + " ~ " + task.getPriority() +"\n" + task.getDescription());
            }
        }
    }

    public void json(){
        Gson gson = new Gson();

        try {
            FileWriter writer = new FileWriter("tasks.json");
            gson.toJson(taskList,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Iterator<Task> iterator() {
        return taskList.iterator();
    }
}
