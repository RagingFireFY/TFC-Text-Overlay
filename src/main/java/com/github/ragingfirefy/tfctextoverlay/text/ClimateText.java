package com.github.ragingfirefy.tfctextoverlay.text;

import com.github.ragingfirefy.tfctextoverlay.common.Offset;
import com.github.ragingfirefy.tfctextoverlay.common.Text;
import com.github.ragingfirefy.tfctextoverlay.util.ColorHelper;
import com.github.ragingfirefy.tfctextoverlay.util.HudLocationOffsetUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ClimateText extends Text {
    public ClimateText(List<Component> componentList) {
        super(componentList);
    }

    @Override
    public void renderOneLine(GuiGraphics guiGraphics, Minecraft mc, int screenWidth, int screenHeight, double scale, int lineOffsetCount) {
        Component first = this.componentList.getFirst();

        int stringWidth = (int) (mc.font.width(first) * scale);
        int stringHeight = (int) (mc.font.lineHeight * scale);

        Offset offsetObj = HudLocationOffsetUtil.getOffset(screenWidth, screenHeight, stringWidth, stringHeight, scale, lineOffsetCount);

        guiGraphics.pose().pushPose();
        guiGraphics.pose().scale((float) scale, (float) scale, 1F);
        guiGraphics.drawString(mc.font, first, offsetObj.getX(), offsetObj.getY(), ColorHelper.CLIMATE_COLOR);
        guiGraphics.pose().popPose();
    }
}
