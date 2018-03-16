package datatypes;

/**
 * Bu sınıf, sorgunun modellendiği sınıftır.
 */
public class QueryRectangle {
    /**
     * Sorgunun merkezinin x koordinatı.
     */
    public double startX;
    /**
     * Sorgunun merkezinin y koordinatı.
     */
    public double startY;
    /**
     * Sorgunun yarıçapı
     */
    public double width;

    public double height;

    /**
     * Constructor
     *
     * @param startX Sorgunun merkezinin x koordinatı.
     * @param startY Sorgunun merkezinin y koordinatı.
     */
    public QueryRectangle(double startX, double startY, double width, double height) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
    }
}
