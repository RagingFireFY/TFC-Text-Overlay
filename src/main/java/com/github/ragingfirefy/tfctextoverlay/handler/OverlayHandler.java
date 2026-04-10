package com.github.ragingfirefy.tfctextoverlay.handler;

import com.github.ragingfirefy.tfctextoverlay.common.Text;
import com.github.ragingfirefy.tfctextoverlay.config.ClientConfig;
import com.github.ragingfirefy.tfctextoverlay.util.TerraFirmaCraftHelper;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.DeathScreen;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public class OverlayHandler implements LayeredDraw.Layer {

    public static final OverlayHandler INSTANCE = new OverlayHandler();

    @Override
    public void render(@NonNull GuiGraphics guiGraphics, @NonNull DeltaTracker deltaTracker) {
        Minecraft mc = Minecraft.getInstance();

        if (mc.player != null && ClientConfig.getEnableMod() && (mc.screen == null || mc.screen instanceof ChatScreen ||
                mc.screen instanceof DeathScreen) && !mc.getDebugOverlay().showDebugScreen() && !mc.options.hideGui &&
                !mc.player.isScoping()) {
            int screenWidth = mc.getWindow().getGuiScaledWidth();
            int screenHeight = mc.getWindow().getGuiScaledHeight();

            double scale = ClientConfig.getHudScale();

            List<Text> textList = TerraFirmaCraftHelper.getTextList();
            int lineOffsetCount = 0;

            for (Text text : textList) {
                text.renderOneLine(guiGraphics, mc, screenWidth, screenHeight, scale, lineOffsetCount);
                lineOffsetCount++;
            }
        }
    }
}

