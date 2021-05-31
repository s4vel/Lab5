package comands;

import exeptions.CollectioIsEmptyExeption;
import collection_filler.Worker;
import system.Coll;

/**
 * Min by id command returns the element with the lowest id.
 */
public class MinByID {

    /**
     * Executes the command.
     *
     * @param collection collection you want to find element in.
     */
    public static void minById(Coll collection) {
        try {
            if (collection.collectionSize() == 0) throw new CollectioIsEmptyExeption();
            Worker worker = collection.minByID();
            System.out.println(worker.toString());
        } catch (CollectioIsEmptyExeption e) {
            System.out.println("Коллекция пуста!");
        }
    }

}
