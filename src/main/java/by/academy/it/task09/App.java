package by.academy.it.task09;

/**
 * Create three classes
 * 1) Task - has the following fields
 * - id
 * - name
 * - description
 *
 * 2) HomeTask extends Task - has additional fields
 * - startDate
 * - endDate
 * @Embedded
 * - performer (type Person [has two fields first and last name, make them Embeddable])
 * @Embedded
 * - accepter (type Person [has two fields first and last name, make them Embeddable])
 *
 * 3) WorkTask extends Task - has additional field
 * - cost
 *
 * In three git branches, implement 3 inheritance strategies:
 * 1 - Table per class hierarchy
 * 2 - Table per subclass
 * 3 - Table Per Concrete class mapping
 *
 * Write there some data from the main method.
 * Check through tests on H2, connect checkstyle, jacoco.
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    }
}
