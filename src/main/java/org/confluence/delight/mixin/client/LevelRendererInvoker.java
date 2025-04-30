package org.confluence.delight.mixin.client;

import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = LevelRenderer.class, priority = 500)
public interface LevelRendererInvoker {
    @Invoker("setSectionDirty")
    void invokeSetSectionDirty(int sectionX, int sectionY, int sectionZ, boolean reRenderOnMainThread);
}
