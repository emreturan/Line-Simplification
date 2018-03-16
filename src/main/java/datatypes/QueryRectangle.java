package datatypes;

/**
 * Bu sınıf, sorgunun modellendiği sınıftır.
 */
public class QueryRectangle {
    /**
     * Sorgunun merkezinin x koordinatı.
     */
    public double neLat;
    /**
     * Sorgunun merkezinin y koordinatı.
     */
    public double neLng;
    /**
     * Sorgunun yarıçapı
     */
    public double swLat;

    public double swLng;

    /**
     * Constructor
     *
     * @param neLat Sorgunun merkezinin x koordinatı.
     * @param neLng Sorgunun merkezinin y koordinatı.
     */
    public QueryRectangle(double neLat, double neLng, double swLat, double swLng) {
        this.neLat = neLat;
        this.neLng = neLng;
        this.swLat = swLat;
        this.swLng = swLng;
    }
}
