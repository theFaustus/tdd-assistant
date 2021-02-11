package com.evil.inc;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.openapi.wm.ToolWindowType;
import com.intellij.openapi.wm.ex.ToolWindowEx;
import com.intellij.ui.JBColor;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.evil.inc.Phase.GREEN;
import static com.evil.inc.Phase.RED;
import static com.evil.inc.Phase.REFACTOR;

public class Assistant {
    private final Map<Phase, String> cycleLaws = new HashMap<>() {{
        put(RED, "Create a unit tests that fails.");
        put(GREEN, "Write production code that makes that test pass.");
        put(REFACTOR, "Clean up the mess you just made.");
    }};
    private final Map<Phase, ImageIcon> cycleLawsImagePaths = new HashMap<>() {{
        put(RED, new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("/images/red.png"))));
        put(GREEN, new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("/images/green.png"))));
        put(REFACTOR, new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("/images/refactor.png"))));
    }};
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

    public Assistant() {
        windowPanel.setInheritsPopupMenu(true);
        imageJPanel.setInheritsPopupMenu(true);
        lawsJPanel.setInheritsPopupMenu(true);
        buttonsJPanel.setInheritsPopupMenu(true);

        setPhase(RED);

        REDButton.addActionListener(e -> setPhase(RED));
        GREENButton.addActionListener(e -> setPhase(GREEN));
        REFACTORButton.addActionListener(e -> setPhase(REFACTOR));

        NEXTButton.addActionListener(e -> {
            switch (currentPhase) {
                case RED -> setPhase(GREEN);
                case GREEN -> setPhase(REFACTOR);
                case REFACTOR -> setPhase(RED);
            }
        });
    }

    private void setPhase(Phase phase) {
        cyclePhaseLabel.setIcon(cycleLawsImagePaths.get(phase));
        cyclePhaseTextLabel.setText(cycleLaws.get(phase));
        windowPanel.setBorder(BorderFactory.createLineBorder(phase.getColor(), 5));
        currentPhase = phase;
    }

    public JPanel getWindowPanel(){
        return windowPanel;
    }

    public JPanel getImageJPanel() {
        return imageJPanel;
    }

    public JPanel getLawsJPanel() {
        return lawsJPanel;
    }
}
