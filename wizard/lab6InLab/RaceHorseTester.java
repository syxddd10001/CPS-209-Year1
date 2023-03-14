/**
 * RaceHorseTester -- to test the RaceHorse class in which you have to write
 * a default constructor, a constructor with parameters and a toString method.
 * Change nothing here.
 */
public class RaceHorseTester
{
    public static void main(String[] args)
    {
        System.out.println("--- TEST 1: Check that the constructor and toString work");
        RaceHorse horse = new RaceHorse();
        System.out.println("OUTPUT:   " + horse);
        java.util.Calendar rightNow = java.util.Calendar.getInstance();
        int year = rightNow.get(java.util.Calendar.YEAR);
        System.out.println("EXPECTED: RaceHorse[name = Horse, year = "
                + year + "][trainer = tbd, wins = 0, places = 0, losses = 0]");

        System.out.println("\n\n--- TEST 2: Check that record updating works correctly");
        horse = new RaceHorse("Blaze", 2009, "Charles Chase");
        horse.record(RaceHorse.Outcome.PLACE);
        horse.record(RaceHorse.Outcome.LOSS);
        horse.record(RaceHorse.Outcome.LOSS);
        horse.record(RaceHorse.Outcome.PLACE);
        horse.record(RaceHorse.Outcome.PLACE);
        horse.record(RaceHorse.Outcome.WIN);
        System.out.println("OUTPUT:   " + horse);
        System.out.println("EXPECTED: RaceHorse[name = Blaze, year = 2009][trainer = Charles Chase, wins = 1, places = 3, losses = 2]");
    }
}

