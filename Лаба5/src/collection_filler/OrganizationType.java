package collection_filler;

/**
 * Enumeration with OrganizationType category constants.
 */
public enum OrganizationType {
    COMMERCIAL,
    PUBLIC,
    GOVERNMENT,
    TRUST;


    public static String getString() {
        String str="";
        for(OrganizationType organizationType : values())
        {
            str+=organizationType+"; ";
        }

        return str;
    }
}
