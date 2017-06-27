package searchtree;

/**
 * Created by Chandran Goodchild on 26.06.17.
 *
 * Generate a tree
 */
public class Trees {
    /**
     * Generate a tree
     * @param elements
     * @return A tree.
     */
    public static Tree makeTree(int[] elements) {
        return new Tree(elements);
    }
}
