package Life;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class tbbuttonStyle extends JButton {

    // declare fields

    private Border line;
    private Border margin;
    private Border compound;
    private JPanel panel;
    static Font font = new Font("SANS_SERIF", Font.PLAIN, 12);

    /**
     * constructor to format the button style
     */
    public tbbuttonStyle() {
        line = BorderFactory.createLineBorder(Color.BLACK);
        margin = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        compound = new CompoundBorder(line, margin);

        this.setFocusPainted(false);
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
        this.setBorder(compound);
        this.setPreferredSize(new Dimension(50, 40));
        this.setFont(font);

    }

}
