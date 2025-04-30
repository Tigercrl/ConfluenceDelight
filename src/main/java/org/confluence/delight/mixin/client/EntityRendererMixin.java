package org.confluence.delight.mixin.client;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import org.confluence.delight.client.ClientConfig;
import org.confluence.delight.common.effect.benifitial.ShineEffectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EntityRenderer.class, priority = 500)
public class EntityRendererMixin {
    @Inject(method = "getBlockLightLevel", at = @At("RETURN"), cancellable = true)
    private <T extends Entity> void shineEffect(T entity, BlockPos pos, CallbackInfoReturnable<Integer> cir) {
        if (ClientConfig.shineEffectFix)
            cir.setReturnValue(Math.max(cir.getReturnValue(), ShineEffectHelper.lightAtPos(pos)));
    }
}
