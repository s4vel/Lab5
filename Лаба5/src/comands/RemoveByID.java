package comands;

import exeptions.CollectioIsEmptyExeption;
import exeptions.NoSuchElementExeption;
import collection_filler.Worker;
import system.Coll;

/**
 * RemoveByID command removes an element from collection by ID.
 */
public class RemoveByID {

    /**
     * Executes the command.
     *
     * @param collection the collection you want to delete element from.
     * @param id the ID of element you want to remove.
     */
    public static void removeByID(Coll collection, int id)
    {
        try {
            if(collection.collectionSize()==0)throw new CollectioIsEmptyExeption();
            Worker worker = collection.findByID(id);
            if(worker.getName()==null) throw new NoSuchElementExeption();
            collection.delete(worker);
        }
        catch (CollectioIsEmptyExeption e)
        {
            System.out.println("Коллекция пуста!");
        }
        catch (NoSuchElementExeption e)
        {
            System.out.println("В коллекции нет элемента с таким ID!");
        }
    }
}
