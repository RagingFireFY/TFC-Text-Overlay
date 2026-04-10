package com.github.ragingfirefy.tfctextoverlay.util;

import com.github.ragingfirefy.tfctextoverlay.common.Season;

import java.awt.Color;

public class ColorHelper {
    public static int LABEL_COLOR = 0xffffff;
    public static int CLIMATE_COLOR = 0x3f3f3f;
    public static int TEMPERATURE_COLOR = 0xf83e3c;
    public static int RAINFALL_COLOR = 0x5e5a93;

    public static int getTemperatureColorComplex(int columOffsetCount) {
        return switch (columOffsetCount) {
            case 1, 3 -> TEMPERATURE_COLOR;
            default -> LABEL_COLOR;
        };
    }

    public static int geRainfallColorComplex(int columOffsetCount) {
        return switch (columOffsetCount) {
            case 1, 3 -> RAINFALL_COLOR;
            default -> LABEL_COLOR;
        };
    }

    public static int geRainfallPeakColorComplex(int columOffsetCount) {
        if (columOffsetCount == 1) {
            return RAINFALL_COLOR;
        } else {
            return LABEL_COLOR;
        }
    }

    public static int geSeasonColorComplex(int columOffsetCount, Season season) {
        return switch (columOffsetCount) {
            case 0, 2 -> getSeasonColor(season);
            default -> LABEL_COLOR;
        };
    }

    public static int getSeasonColor(Season season) {
        Color spring = decode("#80c71f");
        Color summer = decode("#ffd83d");
        Color fall = decode("#f9801d");
        Color winter = decode("#3ab3da");

        return switch (season) {
            case EARLY_SPRING -> getRangeColor(winter, spring, 4, 3);
            case MID_SPRING -> getRangeColor(winter, spring, 4, 4);
            case LATE_SPRING -> getRangeColor(spring, summer, 4, 2);
            case EARLY_SUMMER -> getRangeColor(spring, summer, 4, 3);
            case MID_SUMMER -> getRangeColor(spring, summer, 4, 4);
            case LATE_SUMMER -> getRangeColor(summer, fall, 4, 2);
            case EARLY_AUTUMN -> getRangeColor(summer, fall, 4, 3);
            case MID_AUTUMN -> getRangeColor(summer, fall, 4, 4);
            case LATE_AUTUMN -> getRangeColor(fall, winter, 4, 2);
            case EARLY_WINTER -> getRangeColor(fall, winter, 4, 3);
            case MID_WINTER -> getRangeColor(fall, winter, 4, 4);
            case LATE_WINTER -> getRangeColor(winter, spring, 4, 2);
        };
    }

    public static Color decode(String color) {
        return Color.decode(color);
    }

    private static int getRangeColor(Color from, Color to, int steps, int step) {
        int diffRed = to.getRed() - from.getRed();
        int diffGreen = to.getGreen() - from.getGreen();
        int diffBlue = to.getBlue() - from.getBlue();

        return new Color(
                from.getRed() + ((diffRed * step) / steps),
                from.getGreen() + ((diffGreen * step) / steps),
                from.getBlue() + ((diffBlue * step) / steps)).getRGB();
    }
}
