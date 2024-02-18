package jobieskii.elytranerf.mixin;

import net.minecraft.entity.projectile.FireworkRocketEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(FireworkRocketEntity.class)
public interface fireworkEntityAccessor {
    @Accessor("lifeTime")
    public void setLifetime(int lifetime);
}
