package com.github.ragingfirefy.tfctextoverlay.common;

import net.minecraft.network.chat.Component;

public enum Month {
    JANUARY(0, "text.ftfctextoverlay.month.01"),

    FEBRUARY(1, "text.ftfctextoverlay.month.02"),

    MARCH(2, "text.ftfctextoverlay.month.03"),

    APRIL(3, "text.ftfctextoverlay.month.04"),

    MAY(4, "text.ftfctextoverlay.month.05"),

    JUNE(5, "text.ftfctextoverlay.month.06"),

    JULY(6, "text.ftfctextoverlay.month.07"),

    AUGUST(7, "text.ftfctextoverlay.month.08"),

    SEPTEMBER(8, "text.ftfctextoverlay.month.09"),

    OCTOBER(9, "text.ftfctextoverlay.month.10"),

    NOVEMBER(10, "text.ftfctextoverlay.month.11"),

    DECEMBER(11, "text.ftfctextoverlay.month.12");

    private final String key;
    private final Component locationName;
    private final int idNum;

    Month(int id, String key) {
        this.idNum = id;
        this.key = key;
        this.locationName = Component.translatable(key);
    }

    public int getId() {
        return this.idNum;
    }

    public String getKey() {
        return this.key;
    }

    public Component getTranslate() {
        return this.locationName;
    }

    public Season toSeason() {
        switch (this.idNum) {
            case 0 -> {
                return Season.MID_WINTER;
            }
            case 1 -> {
                return Season.LATE_WINTER;
            }
            case 2 -> {
                return Season.EARLY_SPRING;
            }
            case 3 -> {
                return Season.MID_SPRING;
            }
            case 4 -> {
                return Season.LATE_SPRING;
            }
            case 5 -> {
                return Season.EARLY_SUMMER;
            }
            case 6 -> {
                return Season.MID_SUMMER;
            }
            case 7 -> {
                return Season.LATE_SUMMER;
            }
            case 8 -> {
                return Season.EARLY_AUTUMN;
            }
            case 9 -> {
                return Season.MID_AUTUMN;
            }
            case 10 -> {
                return Season.LATE_AUTUMN;
            }
            case 11 -> {
                return Season.EARLY_WINTER;
            }

        }
        return Season.EARLY_SPRING;
    }
}
