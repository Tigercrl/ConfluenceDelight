package org.confluence.delight.client.advancements;

import com.google.common.collect.Queues;
import org.confluence.delight.ConfluenceDelight;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.LevelEvent;

import java.util.Deque;

@EventBusSubscriber(modid = ConfluenceDelight.MODID, bus = EventBusSubscriber.Bus.GAME)
public class TrToastManager {
    private static final long INTERVAL = 500;
    private static final Deque<TrAdvancementToast> queued = Queues.newArrayDeque();
    private static TrAdvancementToast curr = null;
    private static long nextTime = 0;

    public static void addToast(TrAdvancementToast toast) {
        queued.add(toast);
    }

    public static void render(Minecraft minecraft, GuiGraphics guiGraphics) {
        long now = Util.getMillis();
        if (curr == null && now > nextTime) curr = queued.poll();
        if (curr != null && !minecraft.options.hideGui && minecraft.screen == null) {
            if (curr.render(minecraft, guiGraphics)) {
                curr = null;
                nextTime = now + INTERVAL;
            }
        }
    }

    public static void clear() {
        queued.clear();
    }

    @SubscribeEvent
    public static void onLevelUnload(LevelEvent.Unload event) {
        clear();
    }
}
