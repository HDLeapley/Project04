import java.util.Collections;
import java.util.Scanner;

/*
Hudson Leapley 2/26/2019
Create a program that allows a user to add, remove, edit, and list to-do items
similar to the program created for Project 1.

Individual to-do items should be represented by a class and should allow
a title, description, and priority to be tracked with each to-do item.
Priority should be specified using a numeric value between 0 and 5 where 5
indicates high priority and 0 indicates low priority.

Users should be prompted to specify the title, description, and priority when
adding tasks.  The user should have the ability to list all tasks or list
only tasks of a specified priority.

The program should implement exception handling to deal with bad input from
the user and any other exceptions that might arise.
 */
public class Main {

    private static TaskList taskList = new TaskList();
    private static boolean running = true;
    private static Scanner scan = new Scanner(System.in);

    private static void displayMenu(){ //Display menu and ask for a menu option every loop

        System.out.println("--------------\n" +
                "Choose an option: \n" +
                "(1) Add a Task \n" +
                "(2) Remove a Task \n" +
                "(3) Edit a Task \n" +
                "(4) List Tasks \n" +
                "(5) List Tasks according to priority\n" +
                "(0) Exit");
        String input = scan.nextLine();

        switch(input){
            case "1": taskList.addTask(); //Run add task method in taskList
                break;
            case "2": taskList.remTask(); //Run remove task method in taskList
                break;
            case "3": taskList.editTask(); //Run edit task method in taskList
                break;
            case "4":
                Collections.sort(taskList.taskList);
                for(Task task: taskList) {
                    System.out.println(task.getTaskNum() +") " + task.getTitle() + " ~ " + task.getPriority() +"\n" + task.getDescription());
                }//Run list task method in taskList
                break;
            case "5": taskList.listTasksPriority(); //Run listTaskPriority method in taskList
                break;
            case "0":
                taskList.json();
                running=false; //Exit program
                break;
            default:
                System.out.println("Input not valid"); //Invalid input
        }
    }
    public static void main(String[] args) {

        while(running){ //While program is running, keep asking for options
            displayMenu();
        }
    }
}
