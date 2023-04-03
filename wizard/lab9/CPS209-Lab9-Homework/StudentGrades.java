/**
 * For this problem, you will complete code for reading in Student information
 * from a file, store it in a map, prints the contents of the map, and allows
 * for updating values in the map. You are to complete the following tasks
 *
 * - Initialize a TreeMap to hold the students
 * - Add students to the map
 * - Implement printAllInfo which prints each student in the map
 * - Update the grades of certain students as described
 */

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class StudentGrades
{
    /**
     * Extracts a Map of students from the given filenam
     * @param filename The filename to read from
     * @return A Map of Students indexed by name
     */
    public static Map<String, Student> getStudents(String filename)
    {
        //-----------Start below here. To do: approximate lines of code = 1
        // Create a map called students with key of type String (student id) and value of type Student
        Map <String, Student> students = new TreeMap<String, Student>();
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

        try {
            File studentData = new File(filename);
            Scanner in = new Scanner(studentData);
            Scanner inputLine;

            while (in.hasNextLine()) {
                String line = in.nextLine();
                inputLine = new Scanner(line);
                String name = inputLine.next();
                String id = inputLine.next();
                Student student = new Student(name, id);
                while (inputLine.hasNext()) {
                    String course = inputLine.next();
                    String grade = inputLine.next();
                    student.addCourseAndGrade(course, grade);
                }
                //-----------Start below here. To do: approximate lines of code = 1
                // Add the student to the students map
                
                
                students.put(id, student); 
                inputLine.close();               

                //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
            }

        } catch (IOException exception) {
            System.out.println("Error processing file: " + exception);
            System.exit(0);
        }
        return students;
        
    }

    /**
     * Prints all entries in the Map
     *
     * @param students The student map to print
     */
    public static void printAllInfo(Map<String, Student> students)
    {
        //-----------Start below here. To do: approximate lines of code = 3
        // Print all the info for all students in the map
        
        for (String s : students.keySet()){
            System.out.println(students.get(s));
        }
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    public static void main(String[] args)
    {
        Map<String, Student> students = getStudents("students.txt");

        System.out.println("--- Test 1: Print out inputted students");
        System.out.println("OUTPUT:");
        printAllInfo(students);
        System.out.println("EXPECTED:");
        System.out.println("Joe DD1234 CPS209 B- CPS109 A-");
        System.out.println("Adam HH2123 CPS209 B CPS109 D+");
        System.out.println("James JJ2345 CPS209 B+ CPS109 C+");
        System.out.println("Miriam MM3456 CPS209 A+ CPS109 A+");

        //-----------Start below here. To do: approximate lines of code = 6
        // Update the course grade of a student with given id
        //ID: "DD1234" CPS209 update grade to B+
        //ID: "JJ2345" CPS209 update grade to A-
        //ID: "HH2123" CPS209 update grade to B+
        
        students.get("DD1234").updateGrade("CPS209","B+");
        students.get("JJ2345").updateGrade("CPS209","A-");
        students.get("HH2123").updateGrade("CPS209","B+");


        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

        System.out.println("\n\n--- Test 2: Print out after updates");
        System.out.println("OUTPUT:");
        printAllInfo(students);
        System.out.println("EXPECTED:");
        System.out.println("Joe DD1234 CPS209 B+ CPS109 A-");
        System.out.println("Adam HH2123 CPS209 B+ CPS109 D+");
        System.out.println("James JJ2345 CPS209 A- CPS109 C+");
        System.out.println("Miriam MM3456 CPS209 A+ CPS109 A+");
    }
}
