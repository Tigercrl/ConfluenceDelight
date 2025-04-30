package org.confluence.delight.common.world.filter;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import org.confluence.delight.common.registry.ModPlacementModifiers;
import org.jetbrains.annotations.NotNull;

public class BiomeFilter extends PlacementFilter {
    public static final MapCodec<BiomeFilter> CODEC = RecordCodecBuilder.mapCodec((builder) ->
            builder.group(
                    ResourceLocation.CODEC.fieldOf("biome").forGetter((instance) -> instance.biomeId)
            ).apply(builder, BiomeFilter::new));


    private final ResourceLocation biomeId;

    private BiomeFilter(ResourceLocation biomeId) {
        System.out.println(biomeId);
        this.biomeId = biomeId;
    }

    @Override
    protected boolean shouldPlace(PlacementContext context, @NotNull RandomSource random, @NotNull BlockPos pos) {
        Holder<Biome> biome = context.getLevel().getBiome(pos);
        System.out.println(pos);
        return biome.is(biomeId);
    }

    @Override
    @NotNull
    public PlacementModifierType<?> type() {
        return ModPlacementModifiers.BIOME_ID.get();
    }
}
