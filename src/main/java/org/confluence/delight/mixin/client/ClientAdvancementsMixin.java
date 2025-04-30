package org.confluence.delight.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import org.confluence.delight.client.advancements.TrAdvancementToast;
import org.confluence.delight.client.advancements.TrToastManager;
import net.minecraft.advancements.AdvancementNode;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.multiplayer.ClientAdvancements;
import org.confluence.mod.client.ClientConfigs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = ClientAdvancements.class, priority = 1145)
public class ClientAdvancementsMixin {
    @WrapOperation(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/toasts/ToastComponent;addToast(Lnet/minecraft/client/gui/components/toasts/Toast;)V"))
    private void showAchievementToast(ToastComponent instance, Toast toast, Operation<Void> original, @Local AdvancementNode advancementNode) {
        if (ClientConfigs.achievementToast) {
            TrToastManager.addToast(new TrAdvancementToast(advancementNode.holder()));
        } else {
            original.call(instance, toast);
        }
    }
}
