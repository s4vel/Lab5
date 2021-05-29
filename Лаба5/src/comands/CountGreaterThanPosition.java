package comands;

import exeptions.CollectioIsEmptyExeption;
import collection_filler.Position;
import system.Coll;

/**
 * CountGreaterThanPosition command counts the amount of elements whos position is greater then imputed
 */
public class CountGreaterThanPosition {

    /**
     * Executes the command
     *
     * @param collection the collection you want to count elements in
     * @param position the position for comparison
     * @throws CollectioIsEmptyExeption
     */
    public static void countGreaterThanPosition(Coll collection, Position position) throws CollectioIsEmptyExeption
    {
        if (collection.collectionSize()==0) throw new CollectioIsEmptyExeption();
        int i=collection.countGreaterThenPosition(position);
        System.out.println(i);
    }
}
