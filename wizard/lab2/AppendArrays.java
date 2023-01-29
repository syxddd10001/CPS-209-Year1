/*
 * 
 * Uses a method append() to append one integer array onto the end of another 
 * e.g. if the first array contains  17 63 41 29 and the second contains 23 99 then
 * after the append the first array should contain 17 63 41 29 23 99 
 * 
 */

public class AppendArrays 
{
	public static void main(String[] args)
	{
		int[] a = new int[5];
		int[] b = new int[3];
		int i;

		for (i = 0; i < 5; i++)
		{
			/* Initialize array a to some values */
			a[i] = i + 3;
		}
		System.out.print("a: ");
		for (i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();


		for (i = 0; i < 3; i++)
		{
			/* Initialize array b to some values */
			b[i] = i + 2;
		}
		System.out.print("b: ");
		for (i = 0; i < b.length; i++)
		{
			System.out.print(b[i] + " ");
		}
		System.out.println();

		// Append b to the end of a
		int[] ab = append(a, b);

		System.out.println("Result of append of a and b is: ");
		for (i = 0; i < ab.length; i++)
		{
			System.out.print(ab[i] + " ");
		}
		System.out.println();
		System.out.println("Expected:\n3 4 5 6 7 2 3 4");

		// Append a to the end of b
		int[] ba = append(b, a);

		System.out.println("Result of append of b and a is: ");

		for (i = 0; i < ba.length; i++)
		{
			System.out.print(ba[i] + " ");
		}
		System.out.println();
		System.out.println("Expected:\n2 3 4 3 4 5 6 7");

	}

	/**

            Return a new array that contains the array elements from array parameter x followed by the elements of array parameter y
            @param int[] x
			@param int[] y
	 */
	public static int[] append(int[] x, int[] y)
	{
		//-----------Start below here. To do: approximate lines of code = 6
		// append the integer elements in array y to the end of array x (use the .length variable of an array)
		// Hint: first create a new array big enough to hold all of the integers in array x and array y
		// then use a for loop that goes through each element of array x and adds it to the new bigger array 
		// then use another for loop that goes through each element of array y and adds it to the end of the new bigger array
		
        // Declare and allocate a new array that is big enough to hold all the elements from arrays x and y 
		int [] newArray = new int[x.length+y.length]; 
		
		// Copy the elements from array x to the new bigger array you created 
		
		System.arraycopy(x, 0, newArray, 0, x.length);

		
		// Copy the elements from array y to the end of the new array
		// be careful of the start index in the new array - you have already added the elements from x! 
		
		System.arraycopy(y, 0, newArray, x.length, y.length);
		
		
		// return the new array
		return newArray;
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
}

