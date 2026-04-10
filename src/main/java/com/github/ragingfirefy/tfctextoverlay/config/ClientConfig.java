package com.github.ragingfirefy.tfctextoverlay.config;

import com.github.ragingfirefy.tfctextoverlay.common.TextLocation;
import com.github.ragingfirefy.tfctextoverlay.util.StringLine;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.ConfigValue;

public class ClientConfig {
    public static final ModConfigSpec CLIENT_SPEC;
    private static ConfigValue<Boolean> enableMod;
    private static ConfigValue<TextLocation> hudLocation;
    private static ConfigValue<Integer> hudXOffset;
    private static ConfigValue<Integer> hudYOffset;
    private static ConfigValue<Double> hudScale;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        setupConfig(builder);
        CLIENT_SPEC = builder.build();
    }

    private ClientConfig() {
    }

    private static void setupConfig(ModConfigSpec.Builder builder) {
        builder.push("TFCTextOverlay");
        enableMod = builder.comment(StringLine.builder()
                        .addLine("Enable the mod?")
                        .addLine("(true/false)")
                        .lastLine("Default is " + DefaultClientConfig.DEFAULT_ENABLE_MOD + "."))
                .define("enable_mod", DefaultClientConfig.DEFAULT_ENABLE_MOD);

        builder.push("HUD");
        hudLocation = builder.comment(StringLine.builder()
                        .addLine("Where to display the Hud.")
                        .lastLine("Default is " + DefaultClientConfig.DEFAULT_HUD_LOCATION + "."))
                .defineEnum("hud_location", DefaultClientConfig.DEFAULT_HUD_LOCATION);

        hudXOffset = builder.comment(StringLine.builder()
                        .addLine("The horizontal offset of the HUD based on hud_location (in pixels)")
                        .lastLine("Default is " + DefaultClientConfig.DEFAULT_X_OFFSET + "."))
                .define("hud_x_offset", DefaultClientConfig.DEFAULT_X_OFFSET);

        hudYOffset = builder.comment(StringLine.builder()
                        .addLine("The vertical offset of the HUD based on hud_location (in pixels)")
                        .lastLine("Default is " + DefaultClientConfig.DEFAULT_Y_OFFSET + "."))
                .define("hud_y_offset", DefaultClientConfig.DEFAULT_Y_OFFSET);

        hudScale = builder.comment(StringLine.builder()
                        .addLine("The scale of the HUD.")
                        .lastLine("Default is " + DefaultClientConfig.DEFAULT_HUD_SCALE + "."))
                .defineInRange("hud_scale", DefaultClientConfig.DEFAULT_HUD_SCALE, DefaultClientConfig.HUD_SCALE_MIN, DefaultClientConfig.HUD_SCALE_MAX);

        builder.pop();
    }

    private static <T> T getOrDefault(ConfigValue<T> config) {
        if (CLIENT_SPEC.isLoaded()) {
            return config.get();
        } else {
            return config.getDefault();
        }
    }

    // enable
    public static boolean getEnableMod() {
        return getOrDefault(enableMod);
    }

    public static void setEnableMod(boolean enable) {
        ClientConfig.enableMod.set(enable);
    }

    // HUD
    public static TextLocation getHudLocation() {
        return getOrDefault(hudLocation);
    }

    public static void setHudLocation(TextLocation location) {
        ClientConfig.hudLocation.set(location);
    }

    public static int getHudXOffset() {
        return getOrDefault(hudXOffset);
    }

    public static void setHudXOffset(int x) {
        ClientConfig.hudXOffset.set(x);
    }

    public static int getHudYOffset() {
        return getOrDefault(hudYOffset);
    }

    public static void setHudYOffset(int y) {
        ClientConfig.hudYOffset.set(y);
    }

    public static double getHudScale() {
        return getOrDefault(hudScale);

    }

    public static void setHudScale(double scale) {
        ClientConfig.hudScale.set(scale);
    }
}
