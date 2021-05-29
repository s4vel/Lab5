package comands;

import exeptions.CollectioIsEmptyExeption;
import system.Coll;

/**
 * SumOfSalary command returns sum of all salary fields from collection
 */
public class SumOfSalary {

    /**
     * Executes command.
     *
     * @param collection the collection you work with.
     */
    public static void sumOfSalary(Coll collection)
    {
        try {
            if(collection.collectionSize()==0) throw new CollectioIsEmptyExeption();
            System.out.println(collection.sumOfSalary());
        }
        catch (CollectioIsEmptyExeption e)
        {
            System.out.println("Коллекция пуста!");
        }
    }
}
