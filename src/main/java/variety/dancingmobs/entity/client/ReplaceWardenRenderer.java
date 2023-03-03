package variety.dancingmobs.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.WardenEntity;

import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;
import variety.dancingmobs.entity.ReplacedWardenEntity;

    public class ReplaceWardenRenderer extends GeoReplacedEntityRenderer<WardenEntity, ReplacedWardenEntity> {
        public ReplaceWardenRenderer(EntityRendererFactory.Context renderManager) {
            super(renderManager, new ReplaceWardenModel(), new ReplacedWardenEntity());
        }


    }