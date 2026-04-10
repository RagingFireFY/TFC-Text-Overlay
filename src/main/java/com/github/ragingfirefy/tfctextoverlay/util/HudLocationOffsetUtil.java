package com.github.ragingfirefy.tfctextoverlay.util;

import com.github.ragingfirefy.tfctextoverlay.common.Offset;
import com.github.ragingfirefy.tfctextoverlay.config.ClientConfig;

public class HudLocationOffsetUtil {
    public static Offset getOffset(int screenWidth, int screenHeight, int stringWidth, int stringHeight, double scale, int lineOffsetCount) {
        Offset offsetObj = new Offset();
        int offsetX = ClientConfig.getHudXOffset();
        int offsetY = ClientConfig.getHudYOffset();

        switch (ClientConfig.getHudLocation()) {
            case TOP_LEFT:
                offsetObj.setX(offsetX);
                offsetObj.setY(offsetY + lineOffsetCount * stringHeight);
                break;

            case TOP_CENTER:
                offsetObj.setX((int) ((((double) screenWidth / 2) - ((double) stringWidth / 2)) / scale) + offsetX);
                offsetObj.setY(offsetY + lineOffsetCount * stringHeight);
                break;

            case TOP_RIGHT:
                offsetObj.setX((int) ((screenWidth - stringWidth) / scale) + offsetX);
                offsetObj.setY(offsetY + lineOffsetCount * stringHeight);
                break;

            case BOTTOM_LEFT:
                offsetObj.setX(offsetX);
                offsetObj.setY((int) (((screenHeight - stringHeight)) / scale) + offsetY - (4 - lineOffsetCount) * stringHeight);
                break;

            case BOTTOM_RIGHT:
                offsetObj.setX((int) (((screenWidth - stringWidth)) / scale) + offsetX);
                offsetObj.setY((int) (((screenHeight - stringHeight)) / scale) + offsetY - (4 - lineOffsetCount) * stringHeight);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + ClientConfig.getHudLocation());
        }

        return offsetObj;
    }
}
