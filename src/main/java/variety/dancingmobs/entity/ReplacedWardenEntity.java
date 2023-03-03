package variety.dancingmobs.entity;

import net.minecraft.block.Blocks;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.core.animation.*;
import net.minecraft.entity.EntityType;
import software.bernie.geckolib.animatable.GeoReplacedEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;

import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public  class ReplacedWardenEntity implements GeoReplacedEntity {
        private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
        private boolean songPlaying;
        @Nullable
        private BlockPos songSource;
    public void mobTick(Entity relatedEntity) {
        this.updateAnimations(relatedEntity);
    }
        @Override
        public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
           // controllers.add(DefaultAnimations.genericWalkIdleController(this));
            new AnimationController<>(this, "animations", 0, this::predicate);
        }
        private PlayState predicate(AnimationState<ReplacedWardenEntity> state) {
            AnimationController contr = state.getController();

            String animationname = "";
            if (contr.getCurrentAnimation() != null) {
                animationname = contr.getCurrentAnimation().animation().name();
            }

            if (isSongPlaying()) {
                if (!animationname.equals("dance")) {
                    state.getController().forceAnimationReset();
                    state.getController().setAnimation(RawAnimation.begin().then("dance", Animation.LoopType.PLAY_ONCE));                }
            }
            return PlayState.CONTINUE;
        }
    public boolean isSongPlaying() {
        return this.songPlaying;
    }
        private void updateAnimations( Entity relatedEntity) {
            if (this.songSource == null || !this.songSource.isWithinDistance(relatedEntity.getPos(), 20.0) || !relatedEntity.getWorld().getBlockState(this.songSource).isOf(Blocks.JUKEBOX)) {
                this.songPlaying = false;
                this.songSource = null;
            }
        }
    public void readCustomDataFromNbt(NbtCompound nbt) {
        this.songPlaying=nbt.getBoolean("songplaying");
        this.songSource= BlockPos.fromLong(nbt.getInt("songposition"));
    }
    @Override
    public EntityType<?> getReplacingEntityType() {
        return EntityType.WARDEN;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }


}
