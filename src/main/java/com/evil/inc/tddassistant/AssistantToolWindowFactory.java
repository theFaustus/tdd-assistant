package com.evil.inc.tddassistant;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.openapi.wm.ToolWindowType;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AssistantToolWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentFactory contentFactory = ContentFactory.getInstance();
        Assistant assistant = Assistant.INSTANCE;
        JPanel windowPanel = assistant.getWindowPanel();
        Content content = contentFactory.createContent(windowPanel, "", false);
        toolWindow.getContentManager().addContent(content);
        toolWindow.setType(ToolWindowType.FLOATING, () -> {});
    }
}
