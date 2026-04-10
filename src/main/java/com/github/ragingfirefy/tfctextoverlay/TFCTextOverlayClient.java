package com.github.ragingfirefy.tfctextoverlay;

import com.github.ragingfirefy.tfctextoverlay.config.ClientConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(value = TFCTextOverlayClient.ID, dist = Dist.CLIENT)
public class TFCTextOverlayClient {
    public static final String ID = "tfctextoverlay";

    public TFCTextOverlayClient(ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.CLIENT, ClientConfig.CLIENT_SPEC, "tfctextoverlay-client.toml");
    }
}
