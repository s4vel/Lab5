package comands;

import system.Coll;

/**
 * Clear command clears the collection of all elements
 */
public class Clear {

    /**
     * Executes clear command
     *
     * @param collection collection you want to clear
     */
    public static void clear(Coll collection)
    {
        collection.delleteAll();
        System.out.println("Коллекция очищенна!");
    }
}
