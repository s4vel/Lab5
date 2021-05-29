package comands;

import exeptions.CollectioIsEmptyExeption;
import exeptions.ElementAddingInScriptExeption;
import collection_filler.Worker;
import system.Coll;
import system.UserInteraction;

import java.util.Scanner;

/**
 * RemoveLower command removes all elements with are lower then inputed.
 */
public class RemoveLower {

    /**
     * Executes command.
     *
     * @param collection the collection you want to remove from
     * @param scanner user input scanner
     * @param script boolean witch shows weather you want to execute script
     * @throws ElementAddingInScriptExeption
     */
    public static void RemoveLower(Coll collection, Scanner scanner,boolean script) throws ElementAddingInScriptExeption
    {
        try {
            if(collection.collectionSize()==0)throw new CollectioIsEmptyExeption();
            Worker worker;
            if (!script) worker = UserInteraction.getElement(scanner, collection.getNextId());
            else worker = UserInteraction.getElementScript(scanner, collection.getNextId());
            collection.remoeLover(worker);
        }
        catch (CollectioIsEmptyExeption e)
        {
            System.out.println("Коллекция пуста!");
        }
    }
}
