package com.github.ragingfirefy.tfctextoverlay.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.util.List;

public abstract class Text {
    public List<Component> componentList;

    public Text(List<Component> componentList) {
        this.componentList = componentList;
    }

    public abstract void renderOneLine(GuiGraphics guiGraphics, Minecraft mc, int screenWidth, int screenHeight,
                                       double scale, int lineOffsetCount);
}
