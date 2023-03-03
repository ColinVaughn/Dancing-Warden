package variety.dancingmobs.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import variety.dancingmobs.entity.client.ReplaceWardenRenderer;

@Environment(EnvType.CLIENT)
public class DancingMobsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityType.WARDEN, ReplaceWardenRenderer::new);

    }
}
