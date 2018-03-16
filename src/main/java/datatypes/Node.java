package datatypes;

import javafx.scene.paint.*;

import java.util.Random;

/**
 * Point quadtree tipindeki ağacın düğümlerini oluşturan veri yapısı.
 */

public class Node {
    /**
     * Düğümün ebeveyn düğümünü tutan özellik.
     */
    public Node parent;
    /**
     * Düğümün x koordinatını tutan özellik.
     */
    public double posX;
    /**
     * Düğümün y koordinatını tutan özellik.
     */
    public double posY;
    /**
     * Düğümün çocuklarını tutan özelliktir. Index numaralarına göre değerleri şunlardır.
     * 0 -> sağ üst
     * 1 -> sol üst
     * 2 -> sol alt
     * 3 -> sağ alt
     */
    public Node[] childs;

    /**
     * Constructor
     *
     * @param posX Oluşturulacak düğümün x koordinatı
     * @param posY Oluşturulacak düğümün y koordinatı
     */
    Node(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
        childs = new Node[4];
    }

    /**
     * Düğüme çocuk eklemeye yarar.
     *
     * @param newNode Düğüme eklenecek çocuk.
     * @return Ekleme işleminin başarılı olup olmadığı durumu.
     */
    public boolean addChild(Node newNode) {
        int region = 0;
        if (this.posX == newNode.posX && this.posY == newNode.posY)
            return false;
        else if (newNode.posX >= this.posX && newNode.posY < this.posY)
            region = 0;
        else if (newNode.posX < this.posX && newNode.posY < this.posY)
            region = 1;
        else if (newNode.posX < this.posX && newNode.posY >= this.posY)
            region = 2;
        else if (newNode.posX >= this.posX && newNode.posY >= this.posY)
            region = 3;
        try {
            return childs[region].addChild(newNode);
        } catch (NullPointerException ex) {
            childs[region] = newNode;
            newNode.parent = this;
            return true;
        }
    }

    /**
     * Düğümün belli bir çember içinde olup olmadığını geri döndüren metoddur.
     *
     * @param posX   Çemberin x koordinatını tutar.
     * @param posY   Çemberin y koordinatını tutar.
     * @param radius Çemberin yarıçapını tutar.
     * @return Düğümün çemberin içinde olup olmadığını verir.
     */
    public boolean isInCircle(int posX, int posY, int radius) {
        int distance = (int) Math.sqrt(Math.pow(Math.abs(posX - this.posX), 2) + Math.pow(Math.abs(posY - this.posY), 2));
        if (distance <= radius) return true;
        else return false;
    }

    public boolean isInRectangle(double posX, double posY, double width, double height){
        if (this.posX > posX && this.posY > posY && this.posX < posX + width && this.posY < posY + height) return true;
        return false;
    }
}
