package comands;

import exeptions.CollectioIsEmptyExeption;
import collection_filler.Worker;
import system.Coll;

/**
 * Returns the head of collection
 */
public class Head {

    /**
     * Executes the command
     *
     * @param collection collection you want to get the head from.
     */
    public static void head(Coll collection) {
        try {
            if (collection.collectionSize() == 0) throw new CollectioIsEmptyExeption();
            Worker worker = collection.head();
            System.out.println(worker.toString());
        } catch (CollectioIsEmptyExeption e) {
            System.out.println("Коллекция пуста!");
        }
    }
}
