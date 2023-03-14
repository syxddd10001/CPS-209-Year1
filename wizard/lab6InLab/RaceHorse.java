/**
 A RaceHorse is a specialized horse that has a trainer, and a record.
 You are to complete the following tasks:

   - Set up the Class so that is a subclass of Horse
   - Complete the constructor that takes in input variables
   - Complete the record method to update the current record of the horse based on a race outcome
   - Override the toString method
 */
//-----------Start below here. To do: approximate lines of code = 1
//-----------Start below here. To do: approximate lines of code = 1
// 2. class ... so that class RaceHorse is a subclass of Horse

//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
class RaceHorse extends Horse{ 
    public enum Outcome {
        WIN,
        PLACE,
        LOSS
    }

    private String trainer ;
    private int wins ;
    private int places ;
    private int losses ;
    /**
     A default constructor method that initializes inherited variables as well as added variables trainer, wins, places, losses
     The default trainer is "tbd".
     The wins, places, and  losses start at zero.
     */
    public RaceHorse()
    {
        
        trainer = "tbd" ;
        wins = places = losses = 0 ;  // Note, this is a short way to set all of these parameters to 0
    }
    /**
     A constructor method to initialize inherited name variable and variables year and trainer with given parameter variables
     and sets the wins places and losses to zero.
     @param name1 the given name
     @param year the year of birth
     @param trainer the name of the trainer
     */
    public RaceHorse(String name1, int year, String trainer)
    {
        //-----------Start below here. To do: approximate lines of code = 2
        //-----------Start below here. To do: approximate lines of code = 2
        // 3. super call to initialize inherited name (HINT: use super() call with appropriate parameter )
        super(name1,year);
        //4. trainer
        this.trainer = trainer;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
        wins = places = losses = 0 ;  // Note, this is a short way to set all of these parameters to 0
    }
    /**
     Records result of a race, incrementing one of wins, places, losses depending on the
     type of outcome that happened
     @param type the result of the race
     */
    public void record(Outcome type)
    {
        // update the correct counter instance variable depending on the outcome type
        //-----------Start below here. To do: approximate lines of code = 6
        //
        if (type.equals(Outcome.WIN)) wins++;
        
        else if (type.equals(Outcome.LOSS)) losses++;

        else if (type.equals(Outcome.PLACE)) places++;
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    /**
     Produces a string representation of the object
     @return a string representation
     */
    public String toString()
    {
        //-----------Start below here. To do: approximate lines of code = 2
        //-----------Start below here. To do: approximate lines of code = 2
        // 5-6. something like: "RaceHorse[name = Lucky Star, year = 2011][trainer = Billy Wonder, wins = 1, places = 2, losses = 10]" and use super call
        
        return super.toString() + "[trainer = " + trainer + ", wins = " + wins + ", places = " + places + ", losses = " + losses +"]";
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
