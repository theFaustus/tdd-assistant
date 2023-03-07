package com.evil.inc.tddassistant;

import javax.swing.*;

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
            this.lawsJPanel.setVisible(!lawsJPanel.isVisible());
            hideLawsItem.setText(lawsJPanel.isVisible() ? "Hide laws" : "Display laws");
        });
        hideImageItem = new JMenuItem("Hide image");
        hideImageItem.addActionListener(e -> {
            this.imageJPanel.setVisible(!imageJPanel.isVisible());
            hideImageItem.setText(imageJPanel.isVisible() ? "Hide image" : "Display image");
        });
        add(hideImageItem);
        add(hideLawsItem);
    }

}
