package comands;

import exeptions.CollectioIsEmptyExeption;
import system.Coll;

/**
 * Show command prints all the elements of collection.
 */
public class Show {

    /**
     * Executes command.
     *
     * @param collection the collection you want to prints elements from.
     */
    public static void show(Coll collection)
    {
        try {
            if(collection.collectionSize()==0)throw new CollectioIsEmptyExeption();
            System.out.print(collection.show());
        }
        catch (CollectioIsEmptyExeption e)
        {
            System.out.println("Коллекция пуста!");
        }
    }
}
