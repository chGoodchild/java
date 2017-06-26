package searchtree;

/**
 * Created by Chandran Goodchild on 26.06.17.
 */
public class Tree {

    Node head = null;
    int[] elements;

    public Tree(int[] elements) {
        this.elements = elements;

        if (elements.length > 0) {
            head = new Node(elements[0]);
        }

        for (int i = 1; i < elements.length; i++) {
            head.add(elements[i]);
        }
    }

    public Tree add(int i) {
        Tree newTree = this;

        newTree.head = this.head.add(i);
        return newTree;
    }

    public boolean contains(int i) {
        if (head == null) {
            return false;
        } else {
            return head.contains(i);
        }
    }

    public int size() {
        if (head == null) {
            return 0;
        } else {
            return head.size();
        }
    }

    public String elementsAsString() {
        if (head == null) {
            return "";
        } else {
            String str = head.elementsAsString();
            return str.substring(0, str.length() - 2);
        }
    }
}
