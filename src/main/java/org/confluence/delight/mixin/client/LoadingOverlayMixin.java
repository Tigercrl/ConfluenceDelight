package org.confluence.delight.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ReloadInstance;
import net.neoforged.neoforge.client.loading.NeoForgeLoadingOverlay;
import org.confluence.delight.client.ClientConfig;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

import static org.confluence.delight.ConfluenceDelight.resource;

@Mixin(NeoForgeLoadingOverlay.class)
public class LoadingOverlayMixin {
    @Shadow
    @Final
    private Minecraft minecraft;
    @Shadow
    private long fadeOutStart;
    @Shadow
    @Final
    private ReloadInstance reload;
    @Shadow
    @Final
    private Consumer<Optional<Throwable>> onFinish;
    @Unique
    private final long confluenceDelight$fadeInStart = Util.getMillis();
    @Unique
    private long confluenceDelight$musicStart = 0;
    @Unique
    private static final long confluenceDelight$fadeInTime = 500;
    @Unique
    private static final long confluenceDelight$fadeOutTime = 500;
    @Unique
    private static final long confluenceDelight$musicWaitTime = 9000;
    @Unique
    private static final long confluenceDelight$imgFadeTime = 500;
    @Unique
    private static final int confluenceDelight$type = new Random().nextInt(10) + 1;
    @Unique
    private static final ResourceLocation confluenceDelight$img0 = resource("textures/gui/splash/" + confluenceDelight$type + "-0.png");
    @Unique
    private static final ResourceLocation confluenceDelight$img1 = resource("textures/gui/splash/" + confluenceDelight$type + "-1.png");
    @Unique
    private static final ResourceLocation confluenceDelight$img2 = resource("textures/gui/splash/" + confluenceDelight$type + "-2.png");
    @Unique
    private static final ResourceLocation confluenceDelight$img3 = resource("textures/gui/splash/" + confluenceDelight$type + "-3.png");

    @Inject(method = "render", at = @At("TAIL"))
    private void trSplash(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, CallbackInfo ci) {
        if (ClientConfig.trLoading) {
            RenderSystem.disableScissor();
            int width = minecraft.getWindow().getWidth();
            int height = minecraft.getWindow().getHeight();
            long now = Util.getMillis();
            float alpha = Math.min((now - confluenceDelight$fadeInStart) / (float) confluenceDelight$fadeInTime, 1);
            long fadeOutStart = confluenceDelight$musicStart + confluenceDelight$musicWaitTime;
            if (alpha == 1) RenderSystem.clear(0, true);
            if (fadeOutStart > confluenceDelight$musicWaitTime && now > fadeOutStart) {
                alpha = Math.max(1 - (now - fadeOutStart) / (float) confluenceDelight$fadeOutTime, 0);
            }

            RenderSystem.enableBlend();

            guiGraphics.setColor(1f, 1f, 1f, alpha);
            guiGraphics.blit(confluenceDelight$img0, 0, 0, 0, 0, width, height, width, -height);

            int size = Math.round(Math.min(width, height) / 2.25f);
            guiGraphics.blit(confluenceDelight$img1, width - size, 0, 0, 0, size, size, size, -size);

            float imgAlpha = 1;
            ResourceLocation img = confluenceDelight$img3;
            if (confluenceDelight$musicStart > 0) {
                if (now - confluenceDelight$musicStart > confluenceDelight$imgFadeTime) {
                    imgAlpha = Math.min((now - confluenceDelight$musicStart - confluenceDelight$imgFadeTime) / (float) confluenceDelight$imgFadeTime, 1);
                    img = confluenceDelight$img2;
                } else {
                    imgAlpha = Math.max(1 - (now - confluenceDelight$musicStart) / (float) confluenceDelight$imgFadeTime, 0);
                }
            }
            guiGraphics.setColor(1f, 1f, 1f, imgAlpha);
            guiGraphics.blit(img, 0, 0, 0, 0, width, height, width, -height);

            guiGraphics.setColor(1f, 1f, 1f, 1f);
            RenderSystem.disableBlend();
        }
    }

    @Inject(method = "render", at = @At("HEAD"))
    public void playMusic(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, CallbackInfo ci) {
        if (ClientConfig.trLoading) {
            long now = Util.getMillis();
            if (confluenceDelight$fadeInStart + confluenceDelight$fadeInTime < now)
                RenderSystem.enableScissor(0, 0, 0, 0);
            if (reload.isDone()) {
                if (confluenceDelight$musicStart == 0) {
                    confluenceDelight$musicStart = now;
                } else if (confluenceDelight$musicStart + confluenceDelight$musicWaitTime + confluenceDelight$fadeOutTime - 1000 > now)
                    fadeOutStart = -2L;
                else if (fadeOutStart == -2L) {
                    try {
                        reload.checkExceptions();
                        onFinish.accept(Optional.empty());
                    } catch (Throwable throwable) {
                        onFinish.accept(Optional.of(throwable));
                    }

                    if (minecraft.screen != null) {
                        minecraft.screen.init(minecraft, minecraft.getWindow().getGuiScaledWidth(), minecraft.getWindow().getGuiScaledHeight());
                    }

                    fadeOutStart = 0L;
                }
            }
        }
    }
}
