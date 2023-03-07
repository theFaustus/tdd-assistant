package com.evil.inc.tddassistant;

import com.intellij.ui.JBColor;

public enum Phase {
    RED(JBColor.RED), GREEN(JBColor.GREEN), REFACTOR(JBColor.BLUE);

    private final JBColor color;

    Phase(JBColor color) {
        this.color = color;
    }

    public JBColor getColor() {
        return color;
    }
}
