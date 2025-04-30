package org.confluence.delight.common.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.delight.ConfluenceDelight;
import org.confluence.delight.common.block.ConfluenceWildCropBlock;
import org.confluence.mod.common.init.block.NatureBlocks;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, ConfluenceDelight.MODID);

    // Food - Gharrots
//    public static final Supplier<Block> GHARROTS = B
    public static final Supplier<Block> WILD_GHARROTS = BLOCKS.register("wild_gharrots",
            () -> new ConfluenceWildCropBlock(
                    Holder.direct(ModEffects.BLOOD_CURSE.get()),
                    8,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS),
                    NatureBlocks.TR_CRIMSON_GRASS_BLOCK,
                    BlockTags.DIRT
            ));
    public static final Supplier<Block> GHAST_BLOSSOM = BLOCKS.register("ghast_blossom",
            () -> new FlowerBlock(
                    MobEffects.NIGHT_VISION,
                    100,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .noCollission()
                            .instabreak()
                            .sound(SoundType.GRASS)
                            .offsetType(BlockBehaviour.OffsetType.XZ)
                            .pushReaction(PushReaction.DESTROY)
            ));
    public static final Supplier<Block> POTTED_GHAST_BLOSSOM = BLOCKS.register("potted_ghast_blossom",
            () -> flowerPot(GHAST_BLOSSOM.get()));

    private static Block flowerPot(Block potted) {
        return new FlowerPotBlock(potted, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    }
}
