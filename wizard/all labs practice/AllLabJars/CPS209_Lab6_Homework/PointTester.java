import java.util.ArrayList;
/**
 * A Tester of the point class. You should complete the following tasks:
 *
 *   - Complete the getDistance method
 *   - Complete the getMaxDistance method
 *   - Complete the getUniquePoints method
 */
public class PointTester
{
    /**
     * Calculate the distance between the two points. Recall that the distance
     * between (x1, y1) and (x2, y2) is given by
     *
     * sqrt((x1 - x2)^2 + (y1 - y2)^2)
     *
     * @param p1 The first point
     * @param p2 The second point
     * @return The distance between the points
     */
    public static double getDistance(Point p1, Point p2)
    {
        //-----------Start below here. To do: approximate lines of code = 3
        //
        // You may wish to use Math.sqrt and Math.pow for this method
        
        double distance = 0;


	distance = Math.sqrt(Math.pow((p1.getX()-p2.getX()),2) + Math.pow((p1.getY()-p2.getY()),2));

	return distance;
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Returns the maximum distance between any two pair of points in the given
     * array list of points. That is, for points (p1, p2, p3), it will be the
     * maximum of the distances between p1 and p2, p1 and p3, and p2 and p3.
     *
     * @param points A list of points
     * @return The maximum of the distances between any two points in the list
     */
    public static double getMaxDistance(ArrayList<Point> points)
    {
        //-----------Start below here. To do: approximate lines of code = 7
        //
       double dist = 0; 
        
       for (int i = 0; i<points.size(); i++){
		for (int j = i; j<points.size();j++){
			if (getDistance(points.get(i), points.get(j))> dist){
				dist = getDistance(points.get(i), points.get(j));
			}
		}
       }

       return dist;
        
        
        
        
        
        
        
        
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Returns a new list that contains only the unique points in the
     * original list.
     *
     * @param points The list of points
     * @return A new list containing only the unique points in the original list
     */
    public static ArrayList<Point> getUniquePoints(ArrayList<Point> points)
    {
        //-----------Start below here. To do: approximate lines of code = 5
        //
        // HINT: Create a new list. Then iterate over the old list, checking if
        // each element is already in the new list.
        // You may wish to use the ArrayList "list.contains(e)" method to check if e
        // is in list. It uses equals to do the check
        
	ArrayList <Point> newP = new ArrayList<Point>();
	
	for (Point p : points){
		if (!(newP.contains(p))){
			newP.add(p);
		}
	}
        
        return newP;
        
        
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }



    public static void main(String[] args)
    {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(-5, 20);
        Point p3 = new Point(13, -9);

        System.out.println("--- TEST 1: Check that Point toString works correctly");
        System.out.println("print out p1");
        System.out.println("OUTPUT:   " + p1);

        System.out.println("print out p2");
        System.out.println("EXPECTED: (10.0, 20.0)\n");
        System.out.println("OUTPUT:   " + p2);
        System.out.println("EXPECTED: (-5.0, 20.0)");

        System.out.println("\n\n--- TEST 2: Check that equals works correctly");
        Point p4 = new Point(10, 20);
        System.out.println("p1 equals p2?");
        System.out.println("OUTPUT:   " + p1.equals(p2));
        System.out.println("EXPECTED: false\n");

        System.out.println("p1 equals p3?");
        System.out.println("OUTPUT:   " + p1.equals(p3));
        System.out.println("EXPECTED: false\n");

        System.out.println("p1 equals p4?");
        System.out.println("OUTPUT:   " + p1.equals(p4));
        System.out.println("EXPECTED: true");

        System.out.println("\n\n--- TEST 3: Check that getDistance works correctly");
        System.out.println("distance from p1 to p2");
        System.out.printf("OUTPUT:   %.2f\n", getDistance(p1, p2));
        System.out.println("EXPECTED: 15.00\n");

        System.out.println("distance from p2 to p1");
        System.out.printf("OUTPUT:   %.2f\n", getDistance(p2, p1));
        System.out.println("EXPECTED: 15.00\n");

        System.out.println("distance from p1 to p3");
        System.out.printf("OUTPUT:   %.2f\n", getDistance(p1, p3));
        System.out.println("EXPECTED: 29.15");

        System.out.println("\n\n--- TEST 4: Check that getMaxDistance works correctly");
        ArrayList<Point> points = new ArrayList<>();
        System.out.println("check empty list");
        System.out.printf("OUTPUT:   %.2f\n", getMaxDistance(points));
        System.out.println("EXPECTED: 0.00\n");

        points.add(p1);
        points.add(p2);
        points.add(p3);
        System.out.println("check list with 3 points");
        System.out.printf("OUTPUT:   %.2f\n", getMaxDistance(points));
        System.out.println("EXPECTED: 34.13");

        System.out.println("\n\n--- TEST 5: Check that getUniquePoints works correctly");
        ArrayList<Point> emptyList = new ArrayList<>();
        System.out.println("check empty list");
        System.out.println("OUTPUT:   " + getUniquePoints(emptyList));
        System.out.println("EXPECTED: []\n");

        System.out.println("check list where they are already unique");
        System.out.println("OUTPUT:   " + getUniquePoints(points));
        System.out.println("EXPECTED: [(10.0, 20.0), (-5.0, 20.0), (13.0, -9.0)]\n");

        System.out.println("check list where they are not unique");
        points.add(p4);
        System.out.println("OUTPUT:   " + getUniquePoints(points));
        System.out.println("EXPECTED: [(10.0, 20.0), (-5.0, 20.0), (13.0, -9.0)]\n");
    }
}
