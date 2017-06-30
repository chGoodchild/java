package searchtree;

/**
 * Created by Chandran Goodchild on 30.06.17.
 *
 * Creating my own ArrayList, because we are not allowed to use any Objects from java.util.*.
 */
public class ArrayList {

    /**
     * The array that holds the current value of the ArrayList.
     */
    int[] array = {};

    /**
     * Constructor
     */
    public ArrayList (){

    }

    /**
     * Add a new element to the ArrayList
     * @param n The new element.
     */
    public void add(int n) {

        int[] tmp = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }

        tmp[array.length] = n;
        this.array = tmp;
    }

    /**
     * Return the size of the ArrayList.
     * @return
     */
    public int size() {
        return array.length;
    }

    /**
     * Return the element at a specific index.
     * @param i The index
     * @return
     */
    public int get(int i) {
        return array[i];
    }
}
