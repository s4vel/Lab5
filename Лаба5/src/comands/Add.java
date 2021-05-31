package comands;

import exeptions.ElementAddingInScriptExeption;
import collection_filler.Worker;
import system.Coll;
import system.UserInteraction;

import java.util.Scanner;

/**
 * Add command adds a new element to collection.
 */
public class Add {


    /**
     * Executes add command
     *
     * @param colection the collection you want to add a worker too
     * @param scanner   the scanner witch reads user input
     * @param script    boolean witch shows weather you want to execute script
     * @throws ElementAddingInScriptExeption
     */
    public static void addElement(Coll colection, Scanner scanner, boolean script) throws ElementAddingInScriptExeption {
        Worker element;
        if (!script) element = UserInteraction.getElement(scanner, colection.getNextId());
        else element = UserInteraction.getElementScript(scanner, colection.getNextId());
        colection.add(element);
    }
}
