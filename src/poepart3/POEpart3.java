/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart3;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class POEpart3 {
static double totalHours = 0;
    static int taskCount = 0;
    static final int MAX_TASKS = 100;

    // Arrays for task details
    static String[] developers = new String[MAX_TASKS];
    static String[] taskNames = new String[MAX_TASKS];
    static String[] taskIDs = new String[MAX_TASKS];
    static double[] taskDurations = new double[MAX_TASKS];
    static String[] taskStatuses = new String[MAX_TASKS];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Registration reg = new Registration();

        if (reg.checkUsername(sc) && reg.checkPassword(sc)) {
            System.out.println("Enter First Name: ");
            String firstName = sc.next();

            System.out.println("Enter Last Name: ");
            String lastName = sc.next();

            if (Registration.loginUser(sc, reg.getUsername(), reg.getPassword(), firstName, lastName)) {
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");

                while (true) {
                    int choice = Integer.parseInt(JOptionPane.showInputDialog("""
                            1. Add Tasks
                            2. Show Report
                            3. Display 'Done' Tasks
                            4. Find Longest Task
                            5. Search Task by Name
                            6. Search Tasks by Developer
                            7. Delete Task by Name
                            8. Exit
                            """));

                    switch (choice) {
                        case 1 -> {
                            int totalTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
                            addTasks(firstName + " " + lastName, totalTasks);
                        }
                        case 2 -> showReport();
                        case 3 -> displayDoneTasks();
                        case 4 -> findLongestTask();
                        case 5 -> searchTaskByName();
                        case 6 -> searchTasksByDeveloper();
                        case 7 -> deleteTaskByName("Create reports");
                        case 8 -> System.exit(0);
                        default -> JOptionPane.showMessageDialog(null, "Invalid choice");
                    }
                }
            }
        }
    }

    static void addTasks(String developerName, int totalTasks) {
        for (int i = 0; i < totalTasks; i++) {
            if (taskCount >= MAX_TASKS) {
                JOptionPane.showMessageDialog(null, "Maximum tasks reached.");
                break;
            }

            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 chars):");

            if (taskDescription.length() <= 50) {
                double duration = Double.parseDouble(JOptionPane.showInputDialog("Enter Task Duration (hours):"));
                String taskStatus = JOptionPane.showInputDialog("Enter Task Status (To Do/Doing/Done):");
                Task newTask = new Task(taskName, taskDescription, developerName, duration, taskStatus);

                // Populate arrays
                developers[taskCount] = developerName;
                taskNames[taskCount] = taskName;
                taskIDs[taskCount] = newTask.createTaskID();
                taskDurations[taskCount] = duration;
                taskStatuses[taskCount] = taskStatus;

                taskCount++;
                totalHours += duration;

                JOptionPane.showMessageDialog(null, newTask.printTaskDetails());
            } else {
                JOptionPane.showMessageDialog(null, "Task description exceeds 50 characters. Try again.");
                i--; // Retry this task
            }
        }
    }

    static void showReport() {
        if (taskCount == 0) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            report.append(String.format("""
                Task Name: %s
                Developer: %s
                Task ID: %s
                Task Duration: %.2f hours
                Task Status: %s
                """, taskNames[i], developers[i], taskIDs[i], taskDurations[i], taskStatuses[i]));
        }
        report.append("Total Hours: ").append(totalHours);
        JOptionPane.showMessageDialog(null, report.toString());
    }

    static void displayDoneTasks() {
        StringBuilder doneTasks = new StringBuilder("Tasks with Status 'Done':\n");
        for (int i = 0; i < taskCount; i++) {
            if ("Done".equalsIgnoreCase(taskStatuses[i])) {
                doneTasks.append(String.format("""
                    Developer: %s
                    Task Name: %s
                    Duration: %.2f hours
                    """, developers[i], taskNames[i], taskDurations[i]));
            }
        }
        JOptionPane.showMessageDialog(null, doneTasks.toString());
    }

    static void findLongestTask() {
        if (taskCount == 0) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }
        int longestTaskIndex = 0;
        for (int i = 1; i < taskCount; i++) {
            if (taskDurations[i] > taskDurations[longestTaskIndex]) {
                longestTaskIndex = i;
            }
        }
        JOptionPane.showMessageDialog(null, String.format("""
            Longest Task:
            Developer: %s
            Duration: %.2f hours
            """, developers[longestTaskIndex], taskDurations[longestTaskIndex]));
    }

    static void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to search:");
        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                JOptionPane.showMessageDialog(null, String.format("""
                    Task Name: %s
                    Developer: %s
                    Task Status: %s
                    """, taskNames[i], developers[i], taskStatuses[i]));
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    static void searchTasksByDeveloper() {
        String developerName = JOptionPane.showInputDialog("Enter Developer Name to search:");
        StringBuilder result = new StringBuilder("Tasks for Developer " + developerName + ":\n");
        for (int i = 0; i < taskCount; i++) {
            if (developers[i].equalsIgnoreCase(developerName)) {
                result.append(String.format("""
                    Task Name: %s
                    Task Status: %s
                    """, taskNames[i], taskStatuses[i]));
            }
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    static void deleteTaskByName(String create_reports) {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to delete:");
        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                for (int j = i; j < taskCount - 1; j++) {
                    developers[j] = developers[j + 1];
                    taskNames[j] = taskNames[j + 1];
                    taskIDs[j] = taskIDs[j + 1];
                    taskDurations[j] = taskDurations[j + 1];
                    taskStatuses[j] = taskStatuses[j + 1];
                }
                taskCount--;
                JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }


    
}
