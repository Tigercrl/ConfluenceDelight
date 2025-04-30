package org.confluence.delight.mixin.client;

import org.confluence.delight.client.advancements.TrToastManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import org.confluence.mod.client.ClientConfigs;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ToastComponent.class)
public class ToastComponentMixin {
    @Shadow
    @Final
    Minecraft minecraft;

    @Inject(method = "render", at = @At("TAIL"))
    private void shineEffect(GuiGraphics guiGraphics, CallbackInfo ci) {
        if (ClientConfigs.achievementToast) {
            TrToastManager.render(minecraft, guiGraphics);
        }
    }
}
