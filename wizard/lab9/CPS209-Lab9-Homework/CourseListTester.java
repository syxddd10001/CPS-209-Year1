/**
 * For this question, you will store a set of course lists in a map. The map will
 * use course code as the key and store an array list of strings (ie. student names)
 * for each value. These correspond to the students in the class. You are to complete
 * the following:
 *
 * - Complete the addStudentToCourse method which adds a student to the correct course list as long as they aren't in there already
 * - Initialize the class list Map
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CourseListTester
{
    /**
     * Adds the student to the list of students in a course, where the lists are stored in a map
     * where the key is the course code.
     *
     * Should only add the student if they aren't already in the task list
     *
     * @param courseMap The course map
     * @param courseCode The course code
     * @param studentName The student name
     */
    public static void addStudentToCourse(Map<String, ArrayList<String>> courseMap, String courseCode, String studentName)
    {
        //-----------Start below here. To do: approximate lines of code = 8
        //
        // Check if courseCode is in the map using .containsKey
        if (courseMap.containsKey(courseCode)){
                
            if (!courseMap.get(courseCode).contains(studentName)){
                courseMap.get(courseCode).add(studentName);
            } 

        }
        
            // if courseCode is in the map, get the list of students with that course code
            // The return value of .get will be ArrayList<String>
        
        
            // Only add student if they aren't already in the list
        
        else{
            courseMap.put(courseCode,new ArrayList<String>());
            courseMap.get(courseCode).add(studentName);
        }
        
        
        
            // If this is a new course code, create a new array list, add the student name to it
            // and then put that array list into the map
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public static void main(String[] args)
    {
        //-----------Start below here. To do: approximate lines of code = 1
        // Create a map with key String and values ArrayList<String> named courseMap
        // You may use either TreeMap or HashMap
        Map <String, ArrayList<String>> courseMap = new HashMap<String, ArrayList<String>>();
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

        System.out.println("--- Test 1: Add unique students to different courses");
        addStudentToCourse(courseMap, "cps209", "Keanu Reeves");
        addStudentToCourse(courseMap, "cps209", "Charlize Theron");
        addStudentToCourse(courseMap, "cps209", "Idris Elba");
        addStudentToCourse(courseMap, "cps305", "Charlize Theron");
        addStudentToCourse(courseMap, "cps109", "Michael B. Jordan");
        addStudentToCourse(courseMap, "cps109", "Michelle Yeoh");

        System.out.println("check map size is 3");
        System.out.println("OUTPUT:   " + courseMap.size());
        System.out.println("EXPECTED: 3");

        System.out.println("\ncheck class list of cps209");
        System.out.println("OUTPUT:   " + courseMap.get("cps209"));
        System.out.println("EXPECTED: [Keanu Reeves, Charlize Theron, Idris Elba]");

        System.out.println("\ncheck class list of cps305");
        System.out.println("OUTPUT:   " + courseMap.get("cps305"));
        System.out.println("EXPECTED: [Charlize Theron]");

        System.out.println("\ncheck class list of cps109");
        System.out.println("OUTPUT:   " + courseMap.get("cps109"));
        System.out.println("EXPECTED: [Michael B. Jordan, Michelle Yeoh]");

        System.out.println("\n\n--- Test 2: Add duplicate students and a new one");
        addStudentToCourse(courseMap, "cps209", "Keanu Reeves");
        addStudentToCourse(courseMap, "cps109", "Michael B. Jordan");
        addStudentToCourse(courseMap, "cps305", "Idris Elba");

        System.out.println("check map size is 3");
        System.out.println("OUTPUT:   " + courseMap.size());
        System.out.println("EXPECTED: 3");

        System.out.println("\ncheck class list of cps209");
        System.out.println("OUTPUT:   " + courseMap.get("cps209"));
        System.out.println("EXPECTED: [Keanu Reeves, Charlize Theron, Idris Elba]");

        System.out.println("\ncheck class list of cps305");
        System.out.println("OUTPUT:   " + courseMap.get("cps305"));
        System.out.println("EXPECTED: [Charlize Theron, Idris Elba]");

        System.out.println("\ncheck class list of cps109");
        System.out.println("OUTPUT:   " + courseMap.get("cps109"));
        System.out.println("EXPECTED: [Michael B. Jordan, Michelle Yeoh]");
    }
}
