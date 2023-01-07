import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter Length of string: ");
        int lengthString;
        lengthString = inp.nextInt();

        mainmenu(createString(lengthString));
    }

    public static String createString(int s)
    {
        Scanner inp = new Scanner(System.in);
        String p;
        String newS = "";
        for (int i = 0; i<s; i++)
        {
            p = inp.nextLine();
            newS+=p;
        }
        return newS;
    }

    public static void mainmenu(String s)
    {
        String a = s;
        System.out.println(a);
        System.out.println("added from desktop");

    }

}