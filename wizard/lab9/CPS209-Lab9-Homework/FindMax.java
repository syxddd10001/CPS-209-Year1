import java.util.Map;
import java.util.TreeMap;

/**
 * You are given a map of names to test scores. You must complete getMaxScores which returns
 * the name of the person with the highest score.
 */
public class FindMax
{

    public static String getMaxScore(Map<String, Integer> scores)
    {
        // Can assume the score is from 0 to 100
        int maxScore = -1;
        String maxName = "";
        //-----------Start below here. To do: approximate lines of code = 8
        // 1-5. find the name (maxName) of the person with the highest score
        
        if (scores.size() == 0) return "null";
        

        for (Map.Entry<String, Integer> entry: scores.entrySet()){
            if (entry.getValue() > maxScore) {
                maxName = entry.getKey();
                maxScore = entry.getValue();
            }
        }
        

        
        
        
        return maxName;
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public static void main(String[] args)
    {
        Map<String, Integer> scores = new TreeMap<String, Integer>();

        System.out.println("--- Test 1: Empty Map");
        System.out.println("OUTPUT:   " + getMaxScore(scores));
        System.out.println("EXPECTED: null");

        scores.put("Usman", 47);
        scores.put("Rabib", 13);
        scores.put("Chang", 54);
        scores.put("Carlos", 4);

        System.out.println("\n--- Test 2: Added 4 people");
        System.out.println("OUTPUT:   " + getMaxScore(scores));
        System.out.println("EXPECTED: Chang");

        scores.put("Matthew", 34);
        scores.put("Dmytro", 85);
        scores.put("Stefan", 88);
        scores.put("Andrew", 6);
        scores.put("Syeda", 78);
        scores.put("Sundar", 48);
        scores.put("Minesh", 69);
        scores.put("Atoosa", 73);
        scores.put("Shah", 17);

        System.out.println("\n--- Test 3: Added all people");
        System.out.println("OUTPUT:   " + getMaxScore(scores));
        System.out.println("EXPECTED: Stefan");
    }
}
