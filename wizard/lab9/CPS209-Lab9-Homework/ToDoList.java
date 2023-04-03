/**
 * This program allows for testing a Priority Queue that stores Task objects.
 * You are to complete the following:
 *
 * - Create a PriorityQueue that orders Tasks using the Comparable functionality
 * - Add tasks to that priority queue
 * - Implement a Comparator that orders tasks first by time and then by priority
 * - Create a PriorityQueue that orders Tasks using your Comparator
 * - Add tasks to that priority queue
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class ToDoList
{
    public static void main(String[] args)
    {
        Task task1 = new Task("clean bedroom", 5, 25);
        Task task2 = new Task("fix hole in roof", 1, 180);
        Task task3 = new Task("fix leaky faucet", 2, 60);
        Task task4 = new Task("clean living room", 5, 20);
        Task task5 = new Task("take dog for walk", 4, 25);

        System.out.println("--- Test 1: Order by Comparable");

        //-----------Start below here. To do: approximate lines of code = 6
        // Create a Priority Queue called q, and add the 5 tasks above
        
        PriorityQueue <Task> q = new PriorityQueue<Task>();

        q.add(task1);
        q.add(task2);
        
        q.add(task3);
        q.add(task4);
        
        q.add(task5);
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

        System.out.println("OUTPUT:");
        while(!q.isEmpty())
        {
            System.out.println(q.remove());
        }
        System.out.println("EXPECTED:");
        System.out.println("fix hole in roof\n" +
                "fix leaky faucet\n" +
                "take dog for walk\n" +
                "clean living room\n" +
                "clean bedroom");

        //-----------Start below here. To do: approximate lines of code = 5
        //
        // Create a comparator that orders Tasks in terms of lowest estimated
        // minutes, and breaks ties using priority
        
        class OrderComparator implements Comparator<Task>{

        
                public int compare(Task a, Task b)
                {
                    if (a.getEstimatedMinutes() == b.getEstimatedMinutes()){
                        if (a.getPriority()>b.getPriority()) return 1;
                        else if (a.getPriority()<b.getPriority()) return -1;
                        
                    }
                    
                    else if (a.getEstimatedMinutes()>b.getEstimatedMinutes()) return 1;
                    
                    else if (b.getEstimatedMinutes()>a.getEstimatedMinutes()) return -1;

                    return 0;



                }
        
        
                // Compare by minutes first
        
        
        
        
                // If estimated minutes is equal, compare by priority
        
        }
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

        System.out.println("\n\n--- Test 2: Order by your comparator");
        //-----------Start below here. To do: approximate lines of code = 6
        // Create a PriorityQueue called q2 of Task objects
        // This time, pass an object of your comparator class to the constructor
        // so it orders elements using that criteria
        // Then add the tasks to the queue
        
        PriorityQueue <Task> q2 = new PriorityQueue<Task>(new OrderComparator());

        q2.add(task1);
        q2.add(task2);
        q2.add(task3);

        q2.add(task4);
        q2.add(task5);
        
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

        System.out.println("OUTPUT:");
        while(!q2.isEmpty())
        {
            System.out.println(q2.remove());
        }
        System.out.println("EXPECTED:");
        System.out.println("clean living room\n" +
                "take dog for walk\n" +
                "clean bedroom\n" +
                "fix leaky faucet\n" +
                "fix hole in roof");
    }
}
