package searchtree;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Integer> listTree (Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();


        if (head.right != null) {
            rightList = listTree(head.right);
        }

        if (head.left != null) {
            leftList = listTree(head.left);
        }

        for (int i = 0; i < leftList.size(); i++) {
            list.add(leftList.get(i));
        }

        list.add(head.key);

        for (int i = 0; i < rightList.size(); i++) {
            list.add(rightList.get(i));
        }

        return list;
    }

    public Tree add(int i) {

        ArrayList<Integer> contents = listTree(this.head);
        int[] empty = new int[contents.size()];

        for (int n = 0; n < contents.size(); n++) {
            empty[n] = contents.get(n);
        }

        Tree newTree = new Tree(empty);


        newTree.head.add(i);

        System.out.println(newTree.elementsAsString());

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

    @Override
    protected Tree clone() throws CloneNotSupportedException {
        return (Tree)super.clone();
    }
}
