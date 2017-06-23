package blockworld;

import javax.swing.*;
import java.awt.*;
import java.io.Console;
import java.io.IOException;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BlockWorld w = new BlockWorld(10, 20, asList(new Block(0, 0, 1, 'x'),
                                                     new Block(5, 0, 1, 'o')), '.');
        runBlockWorld(w);
    }

     /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI(JLabel worldLabel, JLabel statusLabel) {
        //Create and set up the window.
        JFrame frame = new JFrame("Blockworld");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // add both labels in a vertical layout
        Container content = frame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        content.add(worldLabel);
        content.add(statusLabel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }

    public static void runBlockWorld(BlockWorld w) throws InterruptedException {
        JLabel worldLabel = new JLabel();
        JLabel statusLabel = new JLabel();
        renderWorld(worldLabel, statusLabel, w);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(worldLabel, statusLabel);
            }
        });

        do {
            w.step();
            renderWorld(worldLabel, statusLabel, w);
            Thread.sleep(1000);
        } while (!w.isDead());
    }

    static void renderWorld(JLabel worldLabel, JLabel statusLabel, BlockWorld w) {
        StringBuilder result = new StringBuilder("<html>");
        char[][] grid = w.observe();
        for (int j = 0; j < w.getHeight(); j++) {
            result.append(String.format("<font face=\"%s\">", Font.MONOSPACED));
            for (int i = 0; i < w.getWidth(); i++) {
                result.append(grid[i][j]);
            }
            result.append("</font><br>");
        }
        result.append("</html>");
        worldLabel.setText(result.toString());
        statusLabel.setText(w.isDead()? "DEAD" : "ALIVE" );
    }

}
