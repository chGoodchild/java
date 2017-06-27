package searchtree;

/**
 * Created by Chandran Goodchild on 26.06.17.
 *
 * A class that describes a node in the Binary Tree. Each node has two pointers,
 * one for the left node and one for the right node. These pointers point to null
 * if there are no further edges.
 */
final public class Node {

    final int key;
    public Node left = null;
    public Node right = null;

    /**
     * Constructor
     * @param key
     */
    public Node (int key) {
        this.key = key;
    }

    /**
     * Search through the tree recursively and add a new node at the correct place.
     * @param i
     * @return Return the node at the current depth after making changes.
     */
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

    /**
     * Search through the tree and check if it contains the given node. Return true if it does.
     * @param i
     * @return Boolean value stating weather the node is present or not.
     */
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

    /**
     * Recursively return the number of sub nodes.
     * @return The number of sub nodes at this level of recursion.
     */
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

    /**
     * Return a recursively generated sorted list of all the elements and sub elements of this node.
     * @return Return the elements (String) at the current level of recursion.
     */
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
