package org.confluence.delight.common.block;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.Arrays;

public class ConfluenceWildCropBlock extends WildCropBlock {
    private static final Logger LOGGER = LogUtils.getLogger();

    private final Object[] mayPlaceOn;

    public ConfluenceWildCropBlock(Holder<MobEffect> suspiciousStewEffect, int effectDuration, Properties properties, Object... mayPlaceOn) {
        super(suspiciousStewEffect, effectDuration, properties);
        this.mayPlaceOn = mayPlaceOn;
    }

    @Override
    protected boolean mayPlaceOn(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return Arrays.stream(mayPlaceOn).anyMatch(obj -> matches(state, obj));
    }

    private boolean matches(BlockState state, Object obj) {
        if (obj instanceof Block block) return state.is(block);
        if (obj instanceof TagKey<?> tag && tag.isFor(BuiltInRegistries.BLOCK.key()))
            return state.is((TagKey<Block>) tag);
        if (obj instanceof Holder<?> holder) return matches(state, holder.value());
        if (obj instanceof HolderSet<?> set)
            return set.stream().anyMatch(holder -> matches(state, holder));
        LOGGER.warn("Unknown block predicate type: {}", obj.getClass().getName());
        return true;
    }
}
