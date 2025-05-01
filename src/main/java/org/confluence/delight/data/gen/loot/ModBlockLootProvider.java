package org.confluence.delight.data.gen.loot;

import com.google.common.collect.Iterables;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

import static org.confluence.delight.common.registry.ModBlocks.*;

public class ModBlockLootProvider extends BlockLootSubProvider {
    private final Holder.Reference<Enchantment> fortune;

    public ModBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
        fortune = registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
    }

    @Override
    protected void generate() {
        add(WILD_GHARROTS.get(), createSilkTouchOrShearsDispatchTable(
                GHAST_BLOSSOM.get(),
                applyExplosionDecay(
                        WILD_GHARROTS.get(),
                        LootItem.lootTableItem(WILD_GHARROTS.get())
                                .apply(createItemCountFunction(1, 3))
                                .apply(ApplyBonusCount.addUniformBonusCount(fortune, 2))
                )
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(GHAST_BLOSSOM.get()).when(hasShearsOrSilkTouch()))
        ));
        dropSelf(GHAST_BLOSSOM.get());
        dropPottedContents(POTTED_GHAST_BLOSSOM.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return Iterables.transform(BLOCKS.getEntries(), DeferredHolder::get);
    }

    private LootItemCondition.Builder hasShearsOrSilkTouch() {
        return HAS_SHEARS.or(hasSilkTouch());
    }

    protected LootItemConditionalFunction.Builder<?> createItemCountFunction(int count) {
        return SetItemCountFunction.setCount(ConstantValue.exactly(count));
    }

    protected LootItemConditionalFunction.Builder<?> createItemCountFunction(int min, int max) {
        return SetItemCountFunction.setCount(UniformGenerator.between(min, max));
    }
}
