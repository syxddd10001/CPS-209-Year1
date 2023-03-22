/**
 * This class Person models a person object that has a name and age.
 */

public class Person
{
    private String firstName;
    private String lastName;
    private int age;

    /**
     * Initializes firstName, lastName and age
     *
     * @param first the first name
     * @param last  the last name
     * @param years the age in years
     */
    public Person(String first, String last, int years)
    {
        firstName = first;
        lastName = last;
        age = years;
    }

    /**
     * Accesses the first name
     *
     * @return firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Accesses the last name
     *
     * @return lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the last name
     *
     * @param lastName the new value.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Accesses the first age
     *
     * @return age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Sets the age
     *
     * @param age the new age
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    public String toString()
    {
        return "(" + lastName + ", " + firstName + ". Age: " + age + ")";
    }
}
