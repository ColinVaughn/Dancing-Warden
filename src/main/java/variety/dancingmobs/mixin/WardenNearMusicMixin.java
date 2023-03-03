package variety.dancingmobs.mixin;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import variety.dancingmobs.DancingMobs;

@Mixin(LivingEntity.class)
public abstract class WardenNearMusicMixin{
private BlockPos SongNearEntity;
private boolean SongNearPlaying;
    @Inject(method="setNearbySongPlaying",at =@At("HEAD"))
    private void setNearbySong( BlockPos songPosition,  boolean playing, CallbackInfo ci) {

        if (((LivingEntity) (Object) this) instanceof WardenEntity) {
            DancingMobs.LOGGER.info("Song is playing G!");
             SongNearEntity=songPosition;
             SongNearPlaying=playing;
        }
    }
    @Inject(method="writeCustomDataToNbt",at=@At("HEAD"))
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        if(this.SongNearEntity!=null) {
            nbt.put("songposition", (NbtElement) this.SongNearEntity);
        }
        nbt.putBoolean("songplaying",this.SongNearPlaying);
    }

}
