import java.util.Calendar;

/**
 A Horse object has a name and a year of birth.
 The day of birth is always set to January 1.
 You are to complete the following:

   - Complete the default constructor
   - Complete the toString method
 */
class Horse
{
    private String name ;
    private int year ;
    /**
     A default constructor method to initialize name and year with default name and current year.
     The default name should be "Horse".
     */
    public Horse()
    {
        //-----------Start below here. To do: approximate lines of code = 3
        //
        // Note: a nice way to get the current year is:
        //java.util.Calendar calendar = java.util.Calendar.getInstance() ;
        // year = calendar.get(java.util.Calendar.YEAR) ;
        // use this method below.
        //
        // For future refernce, you can also import java.util.Calendar and then do the following
        // Calendar calendar = Calendar.getInstance() ;
        // year = calendar.get(Calendar.YEAR) ;
        // DO NOT ADD THE IMPORT HERE
        name = "Horse";
        java.util.Calendar calender = java.util.Calendar.getInstance();
        year = calender.get(Calendar.YEAR);

        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    /**
     A constructor method that initializes name and year with given name and year of birth
     @param name1 the given name
     @param year the year of birth
     */
    public Horse(String name1, int year)
    {
        name = name1 ;
        this.year = year ;
    }
    /**
     Produces a string representation of the object
     Note: use getClass().getName() rather than "Horse", so that the
     subclass name will be correct.
     @return a string representation
     */
    public String toString()
    {
        //-----------Start below here. To do: approximate lines of code = 1
        //-----------Start below here. To do: approximate lines of code = 1
        // 1. something like: "Horse[name = Lucky Star, year = 2014]"
        return this.getClass().getName() + "[name = " + name + ", year = " + year + "]";
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
