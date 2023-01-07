import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter Length of string: ");
        int lengthString;
        lengthString = inp.nextInt();
        System.out.println("your string: " + createString(lengthString));

    }

    public static String createString(int s)
    {
        Scanner inp = new Scanner(System.in);
        String x;
        String newS = "";
        for (int i = 0; i<s; i++)
        {
            x = inp.nextLine();
            newS+=x;
        }
        return newS;
    }


}