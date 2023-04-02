import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * You are given a file "babynames.txt", which lists the top 1000 most popular
 * baby names in the USA in 1990 for each of boys and girls. The given file is
 * ordered by popularity.
 *
 * Your task is to generate two new files, one which contains the list of the
 * top 1000 boys names and one which contains the list of the top 1000 girls
 * names. The resulting files should be ordered alphabetically.
 *
 * You should complete the following tasks:
 *
 *  - Complete the lineHandler method which takes in a line of text from the baby names files, extracts relevant data, and adds them to the corresponding ArrayLists
 *  - Complete outputBabyList which takes in an ArrayList of BabyInfo objects and outputs them to the given file name
 *  - Create a Comparator that can be used to sort an ArrayList of BabyInfo objects alphabetically
 *  - Complete the code in main that extracts the baby names file line by line, sorts the ArrayLists, and outputs the ArrayList values
 */
public class BabyNamesSeparator
{

    /**
     * Handles a line in the baby names file that contains baby names and count information.
     * BabyInfo objects are then constructed and added to ArrayLists, one for boys and one
     * for girls
     * @param line The line of text to extract baby information from
     * @param boys The ArrayList of boys to add to
     * @param girls The ArrayList of girls to add to
     */
    public static void lineHandler(String line, ArrayList<BabyInfo> boys, ArrayList<BabyInfo> girls)
    {
        //-----------Start below here. To do: approximate lines of code = 8
        //
        // Takes in a line of the baby names file, extracts the names and counts, and creates
        // a BabyInfo object for each baby. These are then added to the corresponding ArrayList
        //
        // The format of each line is 1\tBoyName\tBoyCount\tGirlName\tGirlCount
        ;
        // Create a scanner to extract parts of the line
        Scanner scan = new Scanner(line);
        
        // Get the rank
        int rank = Integer.parseInt(scan.next());
        
        // Get the boy name and count, create a new BabyInfo object and add it to the boys ArrayList
        // Remember you can use next vs nextInt for different purposes
        String boyName = scan.next();
        int boyCount = Integer.parseInt(scan.next());

        BabyInfo boyInfo = new BabyInfo(boyName, boyCount);
        
        
        
        // Repeat how you handled the boy name for the girl name
        String girlName = scan.next();
        int girlCount = Integer.parseInt(scan.next());

        BabyInfo girlInfo = new BabyInfo(girlName, girlCount);
        
        
        boys.add(boyInfo);
        girls.add(girlInfo);
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Outputs the given ArrayList of BabyInfo objects to the given output file
     *
     * @param babies The ArrayList of baby objects
     * @param outputFile The name of the output file
     * @throws IOException
     */
    public static void outputBabyList(ArrayList<BabyInfo> babies, String outputFile) throws IOException
    {
        //-----------Start below here. To do: approximate lines of code = 7
        //
        // This code should take in an ArrayList of BabyInfo objects and output them to the given file
        // Create a PrintWriter for the given outputFile
        PrintWriter pw = new PrintWriter(outputFile);        
        // The first two lines should be "Popularity in 1990" and "Rank\tMale name\tCount\tFemale name\tCount"
        
        pw.println("Popularity in 1990");
        pw.println("Rank\tMale name\tCount\tFemale name\tCount");

        
        
        // Loop through the babies in the given ArrayList and print out a line
        // The format should be the number (ie. count in the array list + 1) followed by tab ("\t")
        // and then you can use the baby info toString for the rest
        int rank = 1;

        for (BabyInfo bbinfo : babies){
            pw.println(rank + "\t" + bbinfo);
            ++rank;
        } 
        
        
        pw.close();
        
        
        // Remember to close the writer
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }


    //-----------Start below here. To do: approximate lines of code = 3
    //
    // Create a comparator that will compare the baby names alphabetically
    
    public static class compareName implements Comparator<BabyInfo>
    {
        public int compare(BabyInfo a, BabyInfo b){

            return a.getName().compareTo(b.getName());
        }


    }
    
    
    
    
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    public static void main(String[] args) throws IOException
    {
        ArrayList<BabyInfo> boys = new ArrayList<>();
        ArrayList<BabyInfo> girls = new ArrayList<>();

        String inputFilename = "babynames.txt";
        String boysOutputFilename = "boys.txt";
        String girlsOutputFilename = "girls.txt";

        //-----------Start below here. To do: approximate lines of code = 5
        // This code should read in the baby names file, and fill
        // the two ArrayLists
        // Create a scanner for baby names that reads
        
        // Skip the first two lines
        File file = new File(inputFilename);
        Scanner babyScan = new Scanner(file);

               
        babyScan.nextLine();
        babyScan.nextLine();
        
        // Iterate through all lines in the input file and call
        // lineHandler to populate the ArrayLists
        
        while (babyScan.hasNextLine()){
            lineHandler(babyScan.nextLine(), boys, girls);
        }
        
        babyScan.close();
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

        //-----------Start below here. To do: approximate lines of code = 4
        // Now you will sort the array lists and output them
        
        // perform the sort using Collections.sort and your comparator
        
        Collections.sort(boys, new compareName());
        Collections.sort(girls, new compareName());


        
        // Use outputBabyList to output the two array lists to their corresponding file
        outputBabyList(boys, boysOutputFilename);
        
        outputBabyList(girls, girlsOutputFilename);
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.


        System.out.println("--- TEST 1: Checks boys.txt");
        System.out.println("OUTPUT:");
        Scanner boyScanner = new Scanner(new File(boysOutputFilename));
        for(int i = 0; i < 10; i++)
        {
            System.out.println(boyScanner.nextLine());
        }

        System.out.println("EXPECTED:");
        System.out.println("Popularity in 1990\n" +
                "Rank\tMale name\tCount\tFemale name\tCount\n" +
                "1\tAaron\t14545\n" +
                "2\tAbdul\t122\n" +
                "3\tAbel\t603\n" +
                "4\tAbraham\t1128\n" +
                "5\tAbram\t125\n" +
                "6\tAdam\t14709\n" +
                "7\tAdan\t335\n" +
                "8\tAddison\t247");

        System.out.println("\n\n--- TEST 2: Checks first 10 lines of girls.txt");
        System.out.println("OUTPUT:");
        Scanner girlScanner = new Scanner(new File(girlsOutputFilename));
        for(int i = 0; i < 10; i++)
        {
            System.out.println(girlScanner.nextLine());
        }
        System.out.println("EXPECTED:");
        System.out.println("Popularity in 1990\n" +
                "Rank\tMale name\tCount\tFemale name\tCount\n" +
                "1\tAbbey\t507\n" +
                "2\tAbbie\t311\n" +
                "3\tAbby\t1293\n" +
                "4\tAbigail\t3719\n" +
                "5\tAdrian\t376\n" +
                "6\tAdriana\t2148\n" +
                "7\tAdrianna\t850\n" +
                "8\tAdrianne\t257");
    }
}	
