package jobieskii.elytranerf.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FireworkRocketItem.class)
public class fireworkSpeedMixin {

    @Redirect(
            method = "use",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;spawnEntity(Lnet/minecraft/entity/Entity;)Z")
    )
    public boolean spawnFireworkInHand(World instance, Entity entity, @Local ItemStack is) {
        FireworkRocketEntity fe = (FireworkRocketEntity) entity;
        int i = 1;
        if (!is.isEmpty() && is.hasNbt()) {
            i += is.getOrCreateSubNbt("Fireworks").getByte("Flight");
        }
        ((fireworkEntityAccessor) fe).setLifetime((i-1) * 2 - 1);

        return instance.spawnEntity(fe);
    }
}



