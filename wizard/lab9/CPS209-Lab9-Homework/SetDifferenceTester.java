import java.util.TreeSet;
import java.util.Set;

/**
 * For this question, you are to implement a method that calculates the difference
 * between two given sets. This is a set containing the elements that are in one
 * of the given sets, but not both.
 */
public class SetDifferenceTester
{
    //-----------Start below here. To do: approximate lines of code = 9
    //
    // Calculates the set difference between the two given sets. These are the
    // elements that are in one set, but not the other.
    // Note, a new set should be created and the original sets should not be altered
    // Use a TreeSet to ensure when the sets are printed, they are printed in
    // alphabetical order
    
    public static Set <String> difference(Set <String> s1, Set <String> s2){

        Set diffSet = new TreeSet<String>();
    
        // Create the set to return
    
    
        // Add elements in set1 that aren't in set2 to the set to return
    
        for (String s : s1){
            if (!s2.contains(s)) diffSet.add(s);
        }

        for (String t : s2){
            if (!s1.contains(t)) diffSet.add(t);
        }
    
    
    
    
    
        // Add elements in set2 that aren't in set1 to the set to return
    
    
    
    
    
    
    
        // return your list
        return diffSet;
    }
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    public static void main(String[] args)
    {
        Set<String> set1 = new TreeSet<String>();
        Set<String> set2 = new TreeSet<String>();

        set1.add("A");
        set1.add("B");
        set1.add("C");
        set1.add("D");
        set1.add("F");
        set1.add("G");
        set1.add("H");
        set1.add("I");

        set2.add("F");
        set2.add("G");
        set2.add("H");
        set2.add("I");
        set2.add("J");
        set2.add("K");

        System.out.println("--- TEST 1: Difference between two sets above");
        System.out.println("OUTPUT:   " + difference(set1, set2));
        System.out.println("EXPECTED: [A, B, C, D, J, K]");
        System.out.println("\ncheck that set1 hasn't changed");
        System.out.println("OUTPUT:   " + set1);
        System.out.println("EXPECTED: [A, B, C, D, F, G, H, I]");
        System.out.println("\ncheck that set2 hasn't changed");
        System.out.println("OUTPUT:   " + set2);
        System.out.println("EXPECTED: [F, G, H, I, J, K]");

        System.out.println("\n\n--- TEST 2: Difference between two sets above");
        set2 = new TreeSet<>();
        System.out.println("OUTPUT:   " + difference(set1, set2));
        System.out.println("EXPECTED: [A, B, C, D, F, G, H, I]");
        System.out.println("\ncheck that set1 hasn't changed");
        System.out.println("OUTPUT:   " + set1);
        System.out.println("EXPECTED: [A, B, C, D, F, G, H, I]");
        System.out.println("\ncheck that set2 hasn't changed");
        System.out.println("OUTPUT:   " + set2);
        System.out.println("EXPECTED: []");

        System.out.println("\n\n--- TEST 3: Difference between empty sets");
        set1 = new TreeSet<>();
        System.out.println("OUTPUT:   " + difference(set1, set2));
        System.out.println("EXPECTED: []");
    }
}
