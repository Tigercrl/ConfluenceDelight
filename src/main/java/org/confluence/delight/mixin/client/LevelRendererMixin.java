package org.confluence.delight.mixin.client;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.confluence.delight.client.ClientConfig;
import org.confluence.delight.common.effect.benifitial.ShineEffectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = LevelRenderer.class, priority = 500)
public class LevelRendererMixin {
    @Inject(method = "getLightColor(Lnet/minecraft/world/level/BlockAndTintGetter;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;)I", at = @At("RETURN"), cancellable = true)
    private static void shineEffect(BlockAndTintGetter level, BlockState state, BlockPos pos, CallbackInfoReturnable<Integer> cir) {
        if (ClientConfig.shineEffectFix) {
            int returnValue = cir.getReturnValue();
            int sky = returnValue >> 20;
            int block = (returnValue >> 4) & 0xF;
            block = Math.max(block, ShineEffectHelper.lightAtPos(pos));
            cir.setReturnValue((sky << 20) | (block << 4));
        }
    }
}
