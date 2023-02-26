import java.util.*;
public class test 
{
    public static void main(String [] args)
    {
        int[][] a = {{5, 9, 3, 2, 14}, {77, 44, 22, 15, 99},
				     {14, 2, 3, 9, 5}, {88, 15, 17, 121, 33}};

        System.out.println("even index average: " + avg(a));
        ArrayList <Integer> n = new ArrayList<Integer>();
        n.add(1);n.add(1.1);n.add(1);n.add(1);n.add(1);
        for (Integer elem: n)
        {
            System.out.println(elem);
        }

    }    


    public static double avg(int[][] aa)
    {
        double total = 0;
        int counter = 0;
        double average = 0;

        for (int i = 0; i<aa.length; i++)
        {
            for (int j = 0; j<aa[i].length; j+=1)
            {            
                
                if (counter%2 == 0)
                {
                    System.out.print(aa[i][j] + " ");
                }
                
                counter++;
            }
        }
        average = total/(counter);
        return average;

    }

}
