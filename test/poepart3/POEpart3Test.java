/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package poepart3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class POEpart3Test {
    
    public POEpart3Test() {
    }

    @Test
    public void testDeveloperArray() {
        POEpart3.developers = new String[100];
        POEpart3.taskNames = new String[100];
        POEpart3.taskDurations = new double[100];
        POEpart3.taskStatuses = new String[100];
        POEpart3.taskCount = 0;

        POEpart3.addTasks("mike smith", 1);
        POEpart3.taskNames[0] = "Create login";
        POEpart3.taskDurations[0] = 5;
        POEpart3.taskStatuses[0] = "To do";

        POEpart3.addTasks("Edward Harrison", 1);
        POEpart3.taskNames[1] = "Create add features";
        POEpart3.taskDurations[1] = 8;
        POEpart3.taskStatuses[1] = "Doing";

        POEpart3.addTasks("Samantha Paulson", 1);
        POEpart3.taskNames[2] = "Create reports";
        POEpart3.taskDurations[2] = 2;
        POEpart3.taskStatuses[2] = "Done";

        POEpart3.addTasks("Glenda oberholzer", 1);
        POEpart3.taskNames[3] = "Add arrays";
        POEpart3.taskDurations[3] = 11;
        POEpart3.taskStatuses[3] = "To do";

        String[] expectedDevelopers = {"mike smith", "Edward Harrison", "Samantha Paulson", "Glenda oberholzer"};
        assertArrayEquals(expectedDevelopers, POEpart3.developers);
    }

    @Test
    public void testLongestTask() {
        POEpart3.developers = new String[100];
        POEpart3.taskNames = new String[100];
        POEpart3.taskDurations = new double[100];
        POEpart3.taskStatuses = new String[100];
        POEpart3.taskCount = 0;

        POEpart3.addTasks("mike smith", 1);
        POEpart3.taskNames[0] = "Create login";
        POEpart3.taskDurations[0] = 5;
        POEpart3.taskStatuses[0] = "To do";

        POEpart3.addTasks("Edward Harrison", 1);
        POEpart3.taskNames[1] = "Create add features";
        POEpart3.taskDurations[1] = 8;
        POEpart3.taskStatuses[1] = "Doing";

        POEpart3.addTasks("Samantha Paulson", 1);
        POEpart3.taskNames[2] = "Create reports";
        POEpart3.taskDurations[2] = 2;
        POEpart3.taskStatuses[2] = "Done";

        POEpart3.addTasks("Glenda oberholzer", 1);
        POEpart3.taskNames[3] = "Add arrays";
        POEpart3.taskDurations[3] = 11;
        POEpart3.taskStatuses[3] = "To do";

        String expectedLongestTask = "Glenda oberholzer, 11.0";
        assertEquals(expectedLongestTask, POEpart3.findLongestTask());
    }

    @Test
    public void testSearchTask() {
        POEpart3.developers = new String[100];
        POEpart3.taskNames = new String[100];
        POEpart3.taskDurations = new double[100];
        POEpart3.taskStatuses = new String[100];
        POEpart3.taskCount = 0;

        POEpart3.addTasks("mike smith", 1);
        POEpart3.taskNames[0] = "Create login";
        POEpart3.taskDurations[0] = 5;
        POEpart3.taskStatuses[0] = "To do";

        POEpart3.addTasks("Edward Harrison", 1);
        POEpart3.taskNames[1] = "Create add features";
        POEpart3.taskDurations[1] = 8;
        POEpart3.taskStatuses[1] = "Doing";

        POEpart3.addTasks("Samantha Paulson", 1);
        POEpart3.taskNames[2] = "Create reports";
        POEpart3.taskDurations[2] = 2;
        POEpart3.taskStatuses[2] = "Done";

        POEpart3.addTasks("Glenda oberholzer", 1);
        POEpart3.taskNames[3] = "Add arrays";
        POEpart3.taskDurations[3] = 11;
        POEpart3.taskStatuses[3] = "To do";

        String expectedSearchResult = "mike smith, Create login";
        assertEquals(expectedSearchResult, POEpart3.searchTaskByName("Create login"));
    }

    @Test
    public void testSearchTasksByDeveloper() {
        POEpart3.developers = new String[100];
        POEpart3.taskNames = new String[100];
        POEpart3.taskDurations = new double[100];
        POEpart3.taskStatuses = new String[100];
        POEpart3.taskCount = 0;

        POEpart3.addTasks("mike smith", 1);
        POEpart3.taskNames[0] = "Create login";
        POEpart3.taskDurations[0] = 5;
        POEpart3.taskStatuses[0] = "To do";

        POEpart3.addTasks("Edward Harrison", 1);
        POEpart3.taskNames[1] = "Create add features";
        POEpart3.taskDurations[1] = 8;
        POEpart3.taskStatuses[1] = "Doing";

        POEpart3.addTasks("Samantha Paulson", 1);
        POEpart3.taskNames[2] = "Create reports";
        POEpart3.taskDurations[2] = 2;
        POEpart3.taskStatuses[2] = "Done";

        POEpart3.addTasks("Glenda oberholzer", 1);
        POEpart3.taskNames[3] = "Add arrays";
        POEpart3.taskDurations[3] = 11;
        POEpart3.taskStatuses[3] = "To do";

        String expectedSearchResult = "Create reports";
        assertEquals(expectedSearchResult, POEpart3.searchTasksByDeveloper("Samantha Paulson"));
    }

    @Test
    public void testDeleteTask() {
        POEpart3.developers = new String[100];
        POEpart3.taskNames = new String[100];
        POEpart3.taskDurations = new double[100];
        POEpart3.taskStatuses = new String[100];
        POEpart3.taskCount = 0;

        POEpart3.addTasks("mike smith", 1);
        POEpart3.taskNames[0] = "Create login";
        POEpart3.taskDurations[0] = 5;
        POEpart3.taskStatuses[0] = "To do";

        POEpart3.addTasks("Edward Harrison", 1);
        POEpart3.taskNames[1] = "Create add features";
        POEpart3.taskDurations[1] = 8;
        POEpart3.taskStatuses[1] = "Doing";

        POEpart3.addTasks("Samantha Paulson", 1);
        POEpart3.taskNames[2] = "Create reports";
        POEpart3.taskDurations[2] = 2;
        POEpart3.taskStatuses[2] = "Done";

        POEpart3.addTasks("Glenda oberholzer", 1);
        POEpart3.taskNames[3] = "Add arrays";
        POEpart3.taskDurations[3] = 11;
        POEpart3.taskStatuses[3] = "To do";

        String expectedDeleteMessage = "Task 'Create reports' deleted successfully.";
        assertEquals(expectedDeleteMessage, POEpart3.deleteTaskByName("Create reports"));
    }

    @Test
    public void testDisplayReport() {
        POEpart3.developers = new String[100];
        POEpart3.taskNames = new String[100];
        POEpart3.taskDurations = new double[100];
        POEpart3.taskStatuses = new String[100];
        POEpart3.taskCount = 0;

        POEpart3.addTasks("mike smith", 1);
        POEpart3.taskNames[0] = "Create login";
POEpart3.taskDurations[0] = 5;

        POEpart3.addTasks("Edward Harrison", 1);
        POEpart3.taskNames[1] = "Create add features";
        POEpart3.taskDurations[1] = 8;

        POEpart3.addTasks("Samantha Paulson", 1);
        POEpart3.taskNames[2] = "Create reports";
        POEpart3.taskDurations[2] = 2;

        POEpart3.addTasks("Glenda oberholzer", 1);
        POEpart3.taskNames[3] = "Add arrays";
        POEpart3.taskDurations[3] = 11;

        String report = POEpart3.showReport();
        assertTrue(report.contains("mike smith"));
        assertTrue(report.contains("Create login"));
        assertTrue(report.contains("Edward Harrison"));
        assertTrue(report.contains("Create add features"));
        assertTrue(report.contains("Samantha Paulson"));
        assertTrue(report.contains("Create reports"));
        assertTrue(report.contains("Glenda oberholzer"));
        assertTrue(report.contains("Add arrays"));
        assertTrue(report.contains("Total Hours"));
    }
}