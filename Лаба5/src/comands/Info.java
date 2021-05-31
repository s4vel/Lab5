package comands;

import system.Coll;

/**
 * Info commands returns the information about collection.
 */
public class Info {

    /**
     * Executes the command.
     *
     * @param collection collection you want to get information about.
     */
    public static void infoComand(Coll collection) {
        System.out.println("Свединья о коллекции");
        System.out.println(collection.collectionSize());
        System.out.println(collection.collectionType());
        System.out.println(collection.getLastInitTime());
        System.out.println(collection.getLastSaveTime());
    }
}
