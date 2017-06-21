package loopinterpreter;

import java.util.HashMap;

/**
 * Created by thiemann on 18.06.17.
 */
public class State extends HashMap<String, Integer> {
    /* is this a good idea?
    @Override
    public Integer get(Object key) {
        if (this.containsKey(key)) {
            return super.get(key);
        } else {
            return 0;
        }
    }
    */
}
