package collection_filler;

/**
 * Enumeration with Position category constants.
 */
public enum Position {
    LABORER(1),
    ENGINEER(2),
    HEAD_OF_DIVISION(4),
    HEAD_OF_DEPARTMENT(5),
    DEVELOPER(3);

    private int value;

    Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * @return str string with all constants of Position
     */
    public static String getString() {
        String str = "";

        for (Position position : values()) {
            str += position + "; ";
        }
        return str;
    }
}
