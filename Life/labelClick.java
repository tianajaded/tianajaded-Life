package Life;

import java.awt.*;

import Life.Buttons;

/**
 * class to take in mouse click and update cells based on the click
 */
public class labelClick extends java.awt.event.MouseAdapter {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        Label source = (Label) evt.getSource();
        if (Buttons.setcellsFlag == 1) {
            if (source.getBackground() == Color.BLACK) {
                source.setBackground(Color.WHITE);
            }
            if (source.getBackground() == Color.WHITE) {
                source.setBackground(Color.BLACK);
            }
        }
    }
}
