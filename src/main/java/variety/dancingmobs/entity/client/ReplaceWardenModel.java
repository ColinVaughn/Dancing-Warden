package variety.dancingmobs.entity.client;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import variety.dancingmobs.DancingMobs;
import variety.dancingmobs.entity.ReplacedWardenEntity;

public class ReplaceWardenModel extends GeoModel<ReplacedWardenEntity> {
    @Override
    public Identifier getModelResource(ReplacedWardenEntity entity) {
        return new Identifier(DancingMobs.MOD_ID, "geo/warden.geo.json");
    }

    @Override
    public Identifier getTextureResource(ReplacedWardenEntity entity) {
        return new Identifier(DancingMobs.MOD_ID, "textures/entity/warden/warden.png");
    }

    @Override
    public Identifier getAnimationResource(ReplacedWardenEntity entity) {
            return new Identifier(DancingMobs.MOD_ID, "animations/model.animation.json");

        }
    }
