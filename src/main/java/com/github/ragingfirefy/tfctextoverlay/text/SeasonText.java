package com.github.ragingfirefy.tfctextoverlay.text;

import com.github.ragingfirefy.tfctextoverlay.common.Month;
import com.github.ragingfirefy.tfctextoverlay.common.Offset;
import com.github.ragingfirefy.tfctextoverlay.common.Season;
import com.github.ragingfirefy.tfctextoverlay.common.Text;
import com.github.ragingfirefy.tfctextoverlay.util.ColorHelper;
import com.github.ragingfirefy.tfctextoverlay.util.HudLocationOffsetUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.util.List;

public class SeasonText extends Text {
    public SeasonText(List<Component> componentList) {
        super(componentList);
    }

    @Override
    public void renderOneLine(GuiGraphics guiGraphics, Minecraft mc, int screenWidth, int screenHeight, double scale, int lineOffsetCount) {
        Month m = Month.MAY;
        Season s = m.toSeason();

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
                    ColorHelper.geSeasonColorComplex(columOffsetCount, s));
            guiGraphics.pose().popPose();

            columOffsetCount++;
            columnOffsetPixel += stringWidth;
        }
    }

}
