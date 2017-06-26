package searchtree;

/**
 * Created by Chandran Goodchild on 26.06.17.
 */
final public class Node {

    final int key;
    public Node left = null;
    public Node right = null;
//    public Node previous = null;

    public Node (int key) {
        this.key = key;
    }

    public Node add(int i) {
        if (this.key < i) {
            // Add left
            if (this.left == null) {
                this.left = new Node(i);
            } else {
                this.left.add(i);
            }
        }

        if (this.key > i) {
            // Add right
            if (this.right == null) {
                this.right = new Node(i);
            } else {
                this.right.add(i);
            }
        }
        return this;
    }

    public boolean contains(int i) {
        if (this.key == i) {
            return true;
        } else {
            if (this.left != null) {
                if (this.left.contains(i)) {
                    return  true;
                }
            }

            if (this.right != null) {
                if (this.right.contains(i)) {
                    return  true;
                }
            }
        }

        return false;
    }

    public int size() {
        int size = 1;

        if (this.left != null) {
            size += this.left.size();
        }

        if (this.right != null) {
            size += this.right.size();
        }

        return size;
    }

    public String elementsAsString() {
        String elements = "";

        if (this.right != null) {
            elements =  elements + this.right.elementsAsString();
        }

        elements += this.key + ", ";

        if (this.left != null) {
            elements += this.left.elementsAsString();
        }

        return elements;
    }
}
