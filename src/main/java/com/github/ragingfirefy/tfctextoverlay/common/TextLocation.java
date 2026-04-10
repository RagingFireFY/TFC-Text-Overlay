package com.github.ragingfirefy.tfctextoverlay.common;

import net.minecraft.network.chat.Component;

public enum TextLocation {
    TOP_LEFT(0, "desc.tfctextoverlay.location.topLeft"),

    TOP_CENTER(1, "desc.tfctextoverlay.location.topCenter"),

    TOP_RIGHT(2, "desc.tfctextoverlay.location.topRight"),

    BOTTOM_LEFT(3, "desc.tfctextoverlay.location.bottomLeft"),

    BOTTOM_RIGHT(4, "desc.tfctextoverlay.location.bottomRight");

    private final String key;
    private final Component locationName;
    private final int idNum;

    TextLocation(int id, String key) {
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
