package onedgame;

import java.util.ArrayList;

/**
 * Created by Chandran Goodchild on 22.06.17.
 *
 * The goal of this game is to reach the end of the boolean array without encountering an element that has the type "true".
 * The player can make steps s = 1 || s = -1 || s = m, where m is a user input.
 *
 */
public class Main {

    public static boolean isWinnable(int m, boolean[] game) {
        if (game.length < 1 || m <= 0) {
            throw new IllegalArgumentException("game[] must be false");
        }

        if (game[0]) {
            throw new IllegalArgumentException("game[] must be false");
        }

        return crawl(0, m, game, new ArrayList<>());
    }

    public static boolean crawl(int index, int m, boolean[] game, ArrayList<Integer> tested) {

        boolean winnable = false;

        if (tested.contains(index)) {
            return false;
        } else {
            tested.add(index);
        }

        if (index >= game.length - 1) {
            return true;
        }

        if (game[index]) {
            return false;
        }


        if (index - 1 > 0) {
            if(crawl(index - 1, m, game, tested)) {
                winnable = true;
            }
        }

        if (index + 1 < game.length) {
            if(crawl(index + 1, m, game, tested)) {
                winnable = true;
            }
        }

        if (index + m > 0) {
            if(crawl(index + m, m, game, tested)) {
                winnable = true;
            }
        }

        return winnable;
    }
}
