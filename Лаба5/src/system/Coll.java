package system;

import collection_filler.*;

import java.time.LocalDateTime;
import java.util.ArrayDeque;

/**
 * The collection user works with.
 */
public class Coll {
    private ArrayDeque<Worker> myccolection = new ArrayDeque();
    private int ID;
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;


    /**
     * Adds new element to the collection.
     *
     * @param element
     */
    public void add(Worker element) {
        myccolection.addFirst(element);
        int t = 1;
    }

    /**
     * @return worker with the lowest ID
     */
    public Worker minByID() {
        Worker min_id_worker = myccolection.getFirst();
        for (Worker worker : this.myccolection) {
            if (min_id_worker.getId() > worker.getId()) {
                min_id_worker = worker;

            }
        }

        return min_id_worker;
    }

    /**
     * Deletes element from a collection
     *
     * @param element
     */
    public void delete(Worker element) {
        myccolection.remove(element);
    }

    /**
     * @return str string with all elements of collection.
     */
    public String show() {
        String str = "";
        for (Worker element : this.myccolection) {
            str += element.toString() + "\n";
        }
        return str;
    }

    /**
     * @return sum float summ of all salary fields in the collection
     */
    public float sumOfSalary() {
        float sum = 0;
        for (Worker element : this.myccolection) {
            sum += element.getSalary();
        }
        return sum;
    }

    /**
     * Delets all elements from the collection
     */
    public void delleteAll() {
        myccolection.clear();
    }

    /**
     * Finds element by it's ID
     *
     * @param id
     * @return worker with this ID
     */
    public Worker findByID(int id) {
        Worker workerid = new Worker();
        for (Worker element : this.myccolection) {
            if (element.getId() == id) {
                workerid = element;
            }
        }
        return workerid;
    }

    /**
     * Returns head element of the collection
     *
     * @return head
     */
    public Worker head() {
        return myccolection.peekFirst();
    }

    /**
     * Counts the amount of elements with position greater then position.
     *
     * @param position
     * @return i int
     */
    public int countGreaterThenPosition(Position position) {
        int i = 0;
        for (Worker element : this.myccolection) {

            if (element.getPosition().getValue() > position.getValue()) {
                i += 1;
            }
        }
        return i;
    }

    /**
     * Finds elements lower than given and delets them.
     *
     * @param param Worker type element for comparison
     */
    public void remoeLover(Worker param) {
        for (Worker worker : myccolection) {
            if (worker.compareTo(param) <= 0) {
                delete(worker);
            }
        }
    }

    /**
     * sets localSaveTime to date at the moment
     */
    public void save() {
        lastSaveTime = LocalDateTime.now();
    }

    /**
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @param lastInitTime
     */
    public void setLastInitTime(LocalDateTime lastInitTime) {
        this.lastInitTime = lastInitTime;
    }

    /**
     * @param lastSaveTime
     */
    public void setLastSaveTime(LocalDateTime lastSaveTime) {
        this.lastSaveTime = lastSaveTime;
    }

    /**
     * @param myccolection
     */
    public void setMyccolection(ArrayDeque<Worker> myccolection) {
        this.myccolection = myccolection;
    }

    /**
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * @return lastInitTime
     */
    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * @return lastSaveTime
     */
    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    /**
     * @return myccolection
     */
    public ArrayDeque<Worker> getMyccolection() {
        return myccolection;
    }

    /**
     * @return name of class stored inside collection.
     */
    public String collectionType() {
        return myccolection.getClass().getName();
    }

    /**
     * @return collection size
     */
    public int collectionSize() {
        return myccolection.size();
    }

    /**
     * @return this ID increased by 1.
     */
    public int getNextId() {
        ID = ID + 1;
        return ID;
    }

}