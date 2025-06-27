package com.evil.inc.tddassistant;

import javax.swing.*;
import java.awt.*;

public class ContextMenu extends JPopupMenu {
    private final JMenuItem hideLawsItem;
    private final JMenuItem hideImageItem;

    private final JPanel imageJPanel;
    private final JPanel lawsJPanel;

    public ContextMenu(JPanel imageJPanel, JPanel lawsJPanel) {

        this.imageJPanel = imageJPanel;
        this.lawsJPanel = lawsJPanel;

        hideLawsItem = new JMenuItem("Hide laws");
        hideLawsItem.addActionListener(e -> {
            lawsJPanel.setVisible(!lawsJPanel.isVisible());
            hideLawsItem.setText(lawsJPanel.isVisible() ? "Hide laws" : "Display laws");

            Window root = SwingUtilities.getWindowAncestor(lawsJPanel);
            if (root != null) root.pack();
        });

        hideImageItem = new JMenuItem("Hide image");
        hideImageItem.addActionListener(e -> {
            imageJPanel.setVisible(!imageJPanel.isVisible());
            hideImageItem.setText(imageJPanel.isVisible() ? "Hide image" : "Display image");

            Window root = SwingUtilities.getWindowAncestor(imageJPanel);
            if (root != null) root.pack();
        });
        add(hideImageItem);
        add(hideLawsItem);
    }

}
