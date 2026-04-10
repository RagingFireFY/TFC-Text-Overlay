package com.github.ragingfirefy.tfctextoverlay.text;

import com.github.ragingfirefy.tfctextoverlay.common.Offset;
import com.github.ragingfirefy.tfctextoverlay.common.Text;
import com.github.ragingfirefy.tfctextoverlay.util.ColorHelper;
import com.github.ragingfirefy.tfctextoverlay.util.HudLocationOffsetUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.util.List;

public class RainfallText extends Text {
    public RainfallText(List<Component> componentList) {
        super(componentList);
    }

    @Override
    public void renderOneLine(GuiGraphics guiGraphics, Minecraft mc, int screenWidth, int screenHeight, double scale, int lineOffsetCount) {
        int columOffsetCount = 0;
        int columnOffsetPixel = 0;

        for (Component component : this.componentList) {
            int stringWidth = (int) (mc.font.width(component) * scale);
            int stringHeight = (int) (mc.font.lineHeight * scale);

            Offset offsetObj = HudLocationOffsetUtil.getOffset(screenWidth, screenHeight, stringWidth, stringHeight,
                    scale, lineOffsetCount);

            guiGraphics.pose().pushPose();
            guiGraphics.pose().scale((float) scale, (float) scale, 1F);
            guiGraphics.drawString(mc.font, component, offsetObj.getX() + columnOffsetPixel, offsetObj.getY(),
                    ColorHelper.geRainfallColorComplex(columOffsetCount));
            guiGraphics.pose().popPose();

            columOffsetCount++;
            columnOffsetPixel += stringWidth;
        }
    }

}
