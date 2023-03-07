package com.evil.inc.tddassistant;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.evil.inc.tddassistant.Phase.*;


public enum Assistant {
    INSTANCE;

    private final Map<Phase, String> cycleLaws = new HashMap<>() {{
        put(RED, "Create a unit tests that fails.");
        put(GREEN, "Write production code that makes that test pass.");
        put(REFACTOR, "Clean up the mess you just made.");
    }};
    private final Map<Phase, ImageIcon> cycleLawsImagePaths = new HashMap<>() {{
        put(RED, new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("./images/red.png"))));
        put(GREEN, new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("./images/green.png"))));
        put(REFACTOR, new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("./images/refactor.png"))));
    }};
    private final JMenuItem hideLawsItem = new JMenuItem("Hide laws");
    private final JMenuItem hideImageItem = new JMenuItem("Hide image");
    private JButton REDButton;
    private JButton GREENButton;
    private JButton REFACTORButton;
    private JButton NEXTButton;
    private JLabel cyclePhaseTextLabel;
    private JLabel cyclePhaseLabel;
    private JTextPane firstLaw;
    private JTextPane secondLaw;
    private JTextPane thirdLaw;
    private JPanel windowPanel;
    private JPanel imageJPanel;
    private JPanel lawsJPanel;
    private JPanel buttonsJPanel;
    private Phase currentPhase;

    Assistant() {
        ContextMenu popup = new ContextMenu(imageJPanel, lawsJPanel);
        windowPanel.setComponentPopupMenu(popup);
        ensurePopUpInheritance();

        setPhase(RED);

        REDButton.addActionListener(e -> setPhase(RED));
        GREENButton.addActionListener(e -> setPhase(GREEN));
        REFACTORButton.addActionListener(e -> setPhase(REFACTOR));

        NEXTButton.addActionListener(e -> nextPhase());
    }

    private void ensurePopUpInheritance() {
        windowPanel.setInheritsPopupMenu(true);
        imageJPanel.setInheritsPopupMenu(true);
        lawsJPanel.setInheritsPopupMenu(true);
        buttonsJPanel.setInheritsPopupMenu(true);
        firstLaw.setInheritsPopupMenu(true);
        secondLaw.setInheritsPopupMenu(true);
        thirdLaw.setInheritsPopupMenu(true);
    }

    public void nextPhase() {
        switch (currentPhase) {
            case RED:
                setPhase(GREEN);
                break;
            case GREEN:
                setPhase(REFACTOR);
                break;
            case REFACTOR:
                setPhase(RED);
                break;
        }
    }

    private void setPhase(Phase phase) {
        cyclePhaseLabel.setIcon(cycleLawsImagePaths.get(phase));
        cyclePhaseTextLabel.setText(cycleLaws.get(phase));
        windowPanel.setBorder(BorderFactory.createLineBorder(phase.getColor(), 5));
        currentPhase = phase;
    }

    public JPanel getWindowPanel() {
        return windowPanel;
    }

    public JPanel getImageJPanel() {
        return imageJPanel;
    }

    public JPanel getLawsJPanel() {
        return lawsJPanel;
    }
}
