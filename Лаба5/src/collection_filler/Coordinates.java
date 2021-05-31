package collection_filler;

import java.util.Comparator;

/**
 * X, Y coordinates
 */
public class Coordinates implements Comparable<Coordinates> {
    private Long x; //Значение поля должно быть больше -327, Поле не может быть null
    private Long y; //Поле не может быть null

    /**
     * @param x
     */
    public void setX(Long x) {
        this.x = x;
    }

    /**
     * @param y
     */
    public void setY(Long y) {
        this.y = y;
    }

    /**
     * @return this X
     */
    public Long getX() {
        return x;
    }

    /**
     * @return this Y
     */
    public Long getY() {
        return y;
    }

    @Override
    public int compareTo(Coordinates o) {
        return Comparator.comparing(Coordinates::getX).thenComparing(Coordinates::getY).compare(this, o);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
