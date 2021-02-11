package com.evil.inc;

import com.intellij.ui.JBColor;

public enum Phase {
    RED(JBColor.RED), GREEN(JBColor.GREEN), REFACTOR(JBColor.BLUE);

    private JBColor color;

    Phase(JBColor color) {
        this.color = color;
    }

    public JBColor getColor() {
        return color;
    }
}
