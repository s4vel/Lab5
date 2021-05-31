package comands;

import exeptions.CollectioIsEmptyExeption;
import exeptions.ElementAddingInScriptExeption;
import exeptions.NoSuchElementExeption;
import collection_filler.Worker;
import system.Coll;
import system.UserInteraction;

import java.util.Scanner;

/**
 * UpdateID command updates the fields of element with set ID.
 */
public class UpdateID {

    /**
     * Executes command.
     *
     * @param collection collection you want to change element in.
     * @param id         the ID of element you want to update.
     * @param scanner    scanner of user input.
     * @param script     boolean witch shows weather you want to execute script.
     * @throws ElementAddingInScriptExeption
     */
    public static void updateID(Coll collection, int id, Scanner scanner, boolean script) throws ElementAddingInScriptExeption {
        try {
            if (collection.collectionSize() == 0) throw new CollectioIsEmptyExeption();
            Worker worker;
            worker = collection.findByID(id);
            if (worker.getName() == null) throw new NoSuchElementExeption();
            collection.delete(worker);
            if (!script) worker = UserInteraction.getElement(scanner, 0);
            else worker = UserInteraction.getElementScript(scanner, 0);
            worker.setId(id);
            collection.add(worker);
        } catch (NoSuchElementExeption e) {
            System.out.println("В коллекции нет элемента с таким ID!");
        } catch (CollectioIsEmptyExeption e) {
            System.out.println("Коллекция пуста!");
        }
    }
}
