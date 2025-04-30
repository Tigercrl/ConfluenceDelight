package org.confluence.delight.common.effect.benifitial;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobDespawnEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import org.confluence.delight.ConfluenceDelight;
import org.confluence.delight.client.ClientConfig;
import org.confluence.delight.mixin.client.LevelRendererInvoker;
import org.confluence.mod.common.init.ModEffects;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = ConfluenceDelight.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ShineEffectHelper {
    public static final Map<LivingEntity, Vec3> storage = new HashMap<>();

    public static boolean canShine(Entity entity) {
        return entity instanceof LivingEntity livingEntity &&
                livingEntity.hasEffect(ModEffects.SHINE) &&
                !(livingEntity instanceof Player p && p.isSpectator());
    }

    public static int lightAtPos(BlockPos pos) {
        final int[] brightness = {0};
        storage.values().forEach(vec3 -> {
            brightness[0] = Math.max(brightness[0], Math.toIntExact(Math.round(lightAtPos(pos, vec3))));
        });
        return brightness[0];
    }

    private static double lightAtPos(BlockPos pos, Vec3 source) {
        double radius = 7.75;

        double dx = source.x - pos.getX() + 0.5;
        double dy = source.y - pos.getY() + 0.5;
        double dz = source.z - pos.getZ() + 0.5;

        double distanceSquared = dx * dx + dy * dy + dz * dz;
        if (distanceSquared <= radius * radius)
            return 15 - Math.sqrt(distanceSquared) / radius * 15;

        return 0;
    }

    private static void updateLightingAtChunkPos(int x, int y, int z) {
        try {
            ((LevelRendererInvoker) Minecraft.getInstance().levelRenderer)
                    .invokeSetSectionDirty(x, y, z, false);
        } catch (NullPointerException ignored) {
        }
    }

    private static void updateLighting(ChunkPos chunkPos, int y) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    updateLightingAtChunkPos(chunkPos.x + i, y + j, chunkPos.z + k);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Post event) {
        if (event.getEntity() instanceof LivingEntity livingEntity && ClientConfig.shineEffectFix) {
            Vec3 old = storage.get(livingEntity);
            if (canShine(livingEntity)) storage.put(livingEntity, livingEntity.position());
            else storage.remove(livingEntity);
            if (!Objects.equals(old, livingEntity.position())) {
                ChunkPos chunkPos = livingEntity.chunkPosition();
                updateLighting(chunkPos, SectionPos.blockToSectionCoord(livingEntity.getY()));
            }
        }
    }

    @SubscribeEvent
    public static void onEntityDespawn(MobDespawnEvent event) {
        if (ClientConfig.shineEffectFix)
            storage.remove(event.getEntity());
    }

    @SubscribeEvent
    public static void onLevelLoad(LevelEvent.Load event) {
        storage.clear();
    }
}
