package collection_filler;

/**
 * Organization address
 * street name and zip-code
 */
public class Address {
    private String street; //Поле не может быть null
    private String zipCode; //Поле не может быть null

    /**
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return this street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @return this zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "{" +
                "street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
