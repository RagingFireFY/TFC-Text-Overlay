package com.github.ragingfirefy.tfctextoverlay.event;

import com.github.ragingfirefy.tfctextoverlay.TFCTextOverlayClient;
import com.github.ragingfirefy.tfctextoverlay.handler.OverlayHandler;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

@EventBusSubscriber(value = Dist.CLIENT, modid = TFCTextOverlayClient.ID)
public class OverlayEvent {
    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiLayersEvent event) {
        event.registerAbove(VanillaGuiLayers.CAMERA_OVERLAYS,
                ResourceLocation.fromNamespaceAndPath(TFCTextOverlayClient.ID, TFCTextOverlayClient.ID),
                OverlayHandler.INSTANCE);
    }
}
