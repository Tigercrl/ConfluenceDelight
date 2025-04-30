package org.confluence.delight.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.network.chat.Component;
import org.confluence.delight.client.ClientConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static net.minecraft.client.Options.genericValueLabel;

@Mixin(Options.class)
public class OptionsMixin {
    @ModifyReturnValue(method = "biomeBlendRadius", at = @At("RETURN"))
    private OptionInstance<Integer> biomeBlendRadius(OptionInstance<Integer> original) {
        if (ClientConfig.betterBiomeBlend) {
            return new OptionInstance<>(
                    "options.biomeBlendRadius",
                    OptionInstance.noTooltip(),
                    (component, i) ->
                            genericValueLabel(component, Component.translatable("options.biomeBlendRadius.better")),
                    new OptionInstance.IntRange(15, 15, false),
                    15,
                    i -> {
                    }
            );
        }
        return original;
    }
}
