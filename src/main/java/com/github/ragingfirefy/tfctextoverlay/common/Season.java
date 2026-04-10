package com.github.ragingfirefy.tfctextoverlay.common;

import net.minecraft.network.chat.Component;

public enum Season {
    EARLY_SPRING(0, "text.ftfctextoverlay.season.spring.1"),

    MID_SPRING(1, "text.ftfctextoverlay.season.spring.2"),

    LATE_SPRING(2, "text.ftfctextoverlay.season.spring.3"),

    EARLY_SUMMER(3, "text.ftfctextoverlay.season.summer.1"),

    MID_SUMMER(4, "text.ftfctextoverlay.season.summer.2"),

    LATE_SUMMER(5, "text.ftfctextoverlay.season.summer.3"),

    EARLY_AUTUMN(6, "text.ftfctextoverlay.season.autumn.1"),

    MID_AUTUMN(7, "text.ftfctextoverlay.season.autumn.2"),

    LATE_AUTUMN(8, "text.ftfctextoverlay.season.autumn.3"),

    EARLY_WINTER(9, "text.ftfctextoverlay.season.winter.1"),

    MID_WINTER(10, "text.ftfctextoverlay.season.winter.2"),

    LATE_WINTER(11, "text.ftfctextoverlay.season.winter.3");

    private final String key;
    private final Component locationName;
    private final int idNum;

    Season(int id, String key) {
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
}
