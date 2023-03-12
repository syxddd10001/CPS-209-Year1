/**
 * Class C extends from Class B. For each method below, finish the method by adding
 * lines of the form:
 *
 * methodX(v + K) for some integer K >= 1
 *
 *      or
 *
 * super.methodX(v + K) for some integer K >= 1
 *
 *      or
 *
 * Some methods may need no additional lines.
 * YOU SHOULD NOT ADD ANY OTHER KINDS OF LINES
 *
 * Ignore the line length hints, as they will not help. Moreover, you should
 * examine InheritanceTester to see what the expected outputs are. That will
 * help you figure out what the different constant K values should be and which
 * methods are called in where.
 */
public class C extends B
{
    public C() {
        super();
    }

    public void methodA1(int v)
    {
        System.out.println("methodA1 in C called with value " + v);

        //-----------Start below here. To do: approximate lines of code = 4
        //
        
        super.methodA1(v+41);
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public void methodA2(int v)
    {
        System.out.println("methodA2 in C called with value " + v);

        //-----------Start below here. To do: approximate lines of code = 4
        //
        super.methodA2(v+25);
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public void methodA3(int v)
    {
        System.out.println("methodA3 in C called with value " + v);

        //-----------Start below here. To do: approximate lines of code = 4
        //
        
        super.methodA3(v+1);
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public void methodB2(int v)
    {
        System.out.println("methodB2 in C called with value " + v);

        //-----------Start below here. To do: approximate lines of code = 4
        //
        
        super.methodB2(v+67);
        methodA1(v+56);
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }


}
