package org.confluence.delight.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import org.confluence.delight.client.ClientConfig;
import org.confluence.delight.common.registry.ModSounds;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow
    @Final
    private MusicManager musicManager;
    @Unique
    private static long confluenceDelight$playIntro = 0;

    @ModifyReturnValue(method = "getSituationalMusic", at = @At("RETURN"))
    private Music getSitutuationalMusic(Music original) {
        if (musicManager.isPlayingMusic(ModSounds.TITLE_INTRO) &&
                Util.getMillis() > confluenceDelight$playIntro + 5000
        ) {
            confluenceDelight$playIntro = -1;
        }
        if (ClientConfig.trLoading && original == Musics.MENU) {
            if (confluenceDelight$playIntro >= 0) {
                if (confluenceDelight$playIntro == 0)
                    confluenceDelight$playIntro = Util.getMillis();
                return ModSounds.TITLE_INTRO;
            } else return ModSounds.TITLE;
        }
        return original;
    }
}
