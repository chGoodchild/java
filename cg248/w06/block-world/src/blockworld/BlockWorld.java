package blockworld;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chandran on 6/6/17.
 */
public class BlockWorld {

    int width, height;
    List<Block> blocks;
    char empty;
    ArrayList<ArrayList<ArrayList<Block>>> world = new ArrayList<>();

    public BlockWorld(int width, int height, List<Block> blocks, char empty) {
        this.width = width;
        this.height = height;
        this.blocks = blocks;
        this.empty = empty;
        this.blocks = blocks;

        for (int m = 0; m < this.width; m++) {
            // Add a new ArrayList for each line.
            world.add(new ArrayList<>());
            for (int n = 0; n < this.height; n++) {
                // Add a new ArrayList for each column.
                world.get(m).add(new ArrayList<>());

                for (int i = 0; i < this.blocks.size(); i++) {
                    if (this.blocks.get(i).y == m && this.blocks.get(i).x == n) {
                        this.world.get(m).get(n).add(this.blocks.get(i));
                    }
                }
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public char[][] observe() {

        char[][] out = new char[this.width][this.height];

        for (int m = 0; m < this.width; m++) {
            for (int n = 0; n < this.height; n++) {
                System.out.println("ping");
                if (this.world.get(m).get(n).size() == 0) {
                    out[m][n] = empty;
                } else {
                    out[m][n] = 0;
                    for (int o = 0; o < this.world.get(m).get(n).size(); o++) {
                        if (out[m][n] < (int) this.world.get(m).get(n).get(o).shape) {
                            out[m][n] = this.world.get(m).get(n).get(o).shape;
                        }
                    }
                }
                System.out.println(out[m][n]);
            }
        }
        System.out.println("done");
        return out;
    }

    public void step() {
        for (int m = 0; m < this.width; m++) {
            for (int n = 0; n < this.height; n++) {
                for (int o = 0; o < this.world.get(m).get(n).size(); o++) {
//                    if (this.height >= this.world.get(m).get(n).get(o).velocity) {
                        this.world.get(m).get(n).get(o).y = this.world.get(m).get(n).get(o).y - this.world.get(m).get(n).get(o).velocity;
//                    }

                    if (this.world.get(m).get(n).get(o).y  < 0) {
                        this.world.get(m).get(n).get(o).y = 0;
                    }
                }
            }
        }
    }

    public boolean isDead() {
        boolean is_dead = true;
        for (int m = 0; m < this.width; m++) {
            for (int n = 0; n < this.height - 1; n++) {
                if (this.world.get(m).get(n).size() > 0) {
                    is_dead = false;
                }
            }
        }
        return is_dead;
    }
}
