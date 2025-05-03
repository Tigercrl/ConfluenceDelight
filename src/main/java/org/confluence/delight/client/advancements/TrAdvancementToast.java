package org.confluence.delight.client.advancements;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.confluence.delight.common.registry.ModSounds;

import static org.confluence.delight.ConfluenceDelight.resource;

public class TrAdvancementToast {
    private final int FADE_IN_TIME = 500;
    private final int STAY_TIME = 3000;
    private final int FADE_OUT_TIME = 500;
    private final int WIDTH = 20;
    private final int HEIGHT = 20;
    private final ResourceLocation TEXTURE = resource("toast/advancement");

    public final AdvancementHolder advancement;
    private final String name;
    private final int color;
    private final int width;
    private final ItemStack icon;
    private long renderStart = 0;

    public TrAdvancementToast(AdvancementHolder advancement) {
        this.advancement = advancement;
        icon = this.advancement.value().display().map(DisplayInfo::getIcon).orElse(null);
        Component component = advancement.value().name().orElse(Component.literal("[]").withStyle(ChatFormatting.YELLOW));
        this.name = component.getString().substring(1, component.getString().length() - 1);
        color = component.getStyle().getColor().getValue();
        Font font = Minecraft.getInstance().font;
        width = font.width(this.name) + 8 + (icon != null ? 18 : 0);
    }

    public boolean render(Minecraft minecraft, GuiGraphics guiGraphics) {
        long now = Util.getMillis();

        if (name.isEmpty() && icon == null) return true;

        if (renderStart == 0) {
            renderStart = now;
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(ModSounds.ADVANCEMENT_TOAST_OUT, 1f, 1f));
        }
        float alpha = Math.min(1, (now - renderStart) / (float) FADE_IN_TIME);
        if (renderStart + FADE_IN_TIME + STAY_TIME < now) {
            alpha = Math.max(0, 1 - (now - renderStart - FADE_IN_TIME - STAY_TIME) / (float) FADE_OUT_TIME);
            if (alpha == 0) {
                return true;
            }
        }

        int guiWidth = guiGraphics.guiWidth();
        int guiHeight = guiGraphics.guiHeight();
        int x = (guiWidth - width) / 2;
        int y = guiHeight * 3 / 4;

        RenderSystem.enableBlend();
        guiGraphics.setColor(1f, 1f, 1f, alpha);

        guiGraphics.blitSprite(TEXTURE, WIDTH, HEIGHT, 0, 0, x, y, WIDTH / 2 - 1, HEIGHT);
        for (int i = WIDTH / 2 - 1; i <= width - (WIDTH / 2 - 1); i++) {
            guiGraphics.blitSprite(TEXTURE, WIDTH, HEIGHT, WIDTH / 2, 0, x + i, y, 1, HEIGHT);
        }
        guiGraphics.blitSprite(TEXTURE, WIDTH, HEIGHT, WIDTH / 2 + 1, 0, x + width - (WIDTH / 2 + 1), y, WIDTH / 2 - 1, HEIGHT);

        if (icon != null)
            guiGraphics.renderFakeItem(icon, x + width - 22, y + 2);
        guiGraphics.drawString(minecraft.font, name, x + 4, y + 6, color);

        guiGraphics.setColor(1f, 1f, 1f, 1f);
        RenderSystem.disableBlend();

        return false;
    }
}
