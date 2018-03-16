package datatypes;

import java.util.ArrayList;

/**
 * Point quadtree veri yapısının implemente edilmiş hali.
 */
public class QuadTree {
    /**
     * Ağacın kökünü tutan değişken.
     */
    public Node root;

    public QuadTree(PointData pointData){
        for (double[] point : pointData.getArrayList()){
            Node node = new Node(point[0], point[1]);
            add(node);
        }
    }

    /**
     * Ağaca yeni bir çocuk ekleyen metod.
     *
     * @param newNode Eklenecek metod.
     * @return Ekleme işleminin başarısı.
     */
    public boolean add(Node newNode) {
        try {
            return root.addChild(newNode);
        } catch (NullPointerException ex) {
            root = newNode;
            return true;
        }
    }

    /**
     * QuadTree içinde sorguya bağlı olarak arama işlemi yapan metoddur.
     *
     * @param queryRectangle Sorguyu tutan değişken.
     * @return Sorgunun sonucu.
     */
    public ArrayList<Node> search(QueryRectangle queryRectangle) {
        ArrayList<Node> results = search(root, queryRectangle);
        return results;
    }

    /**
     * Search işlemini özyinelemeli olarak yapan yardımcı metoddur.
     *
     * @param root        Dolaşılacak düğüm.
     * @param queryRectangle Sorgu.
     * @return Sorgunun sonucu.
     */

    private ArrayList<Node> search(Node root, QueryRectangle queryRectangle) {
        if (root == null) return new ArrayList<Node>();
        else {
            ArrayList<Node> results = new ArrayList<>();
            if (root.isInRectangle(queryRectangle.startX, queryRectangle.startY, queryRectangle.width, queryRectangle.height)) results.add(root);
            for (Node child : root.childs) {
                results.addAll(search(child, queryRectangle));
            }
            return results;
        }
    }
}
