package org.confluence.delight.data.gen.loot;

import com.google.common.collect.Iterables;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.confluence.delight.common.block.GharrotBlock;
import org.confluence.delight.common.registry.ModBlocks;
import org.confluence.delight.common.registry.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootProvider extends BlockLootSubProvider {
    private final Holder.Reference<Enchantment> fortune;

    public ModBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
        fortune = registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
    }

    @Override
    protected void generate() {
        // Foods - Gharrot
        LootItemCondition.Builder gharrotsFirstAge = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(Blocks.CARROTS)
                .setProperties(
                        StatePropertiesPredicate.Builder.properties().hasProperty(GharrotBlock.AGE, GharrotBlock.FIRST_MAX_AGE)
                );
        for (int i = GharrotBlock.FIRST_MAX_AGE; i <= GharrotBlock.SECOND_MAX_AGE; i++) {
            gharrotsFirstAge = gharrotsFirstAge.or(
                    LootItemBlockStatePropertyCondition
                            .hasBlockStateProperties(ModBlocks.GHARROTS.get())
                            .setProperties(
                                    StatePropertiesPredicate.Builder.properties()
                                            .hasProperty(GharrotBlock.AGE, i)
                            )
            );
        }
        LootItemCondition.Builder gharrotsSecondAge = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.GHARROTS.get())
                .setProperties(
                        StatePropertiesPredicate.Builder.properties()
                                .hasProperty(GharrotBlock.AGE, GharrotBlock.SECOND_MAX_AGE)
                );
        add(ModBlocks.GHARROTS.get(), applyExplosionDecay(
                ModBlocks.GHARROTS.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GHARROT.get())))
                        .withPool(
                                LootPool.lootPool()
                                        .when(gharrotsFirstAge)
                                        .add(LootItem.lootTableItem(ModItems.GHARROT.get())
                                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(fortune, 4 / 7F, 3)))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .when(gharrotsSecondAge)
                                        .add(LootItem.lootTableItem(ModItems.GHAST_BLOSSOM.get()))
                                        .add(LootItem.lootTableItem(ModItems.GHAST_BLOSSOM.get())
                                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(fortune, 4 / 7F, 3)))
                        )
        ));

        add(ModBlocks.WILD_GHARROTS.get(), createSilkTouchOrShearsDispatchTable(
                ModBlocks.GHAST_BLOSSOM.get(),
                applyExplosionDecay(
                        ModBlocks.WILD_GHARROTS.get(),
                        LootItem.lootTableItem(ModItems.GHARROT.get())
                                .apply(createItemCountFunction(1, 3))
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(fortune, 4 / 7F, 3))
                )
        ).withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModBlocks.GHAST_BLOSSOM.get()).when(hasShearsOrSilkTouch()))
        ));
        dropSelf(ModBlocks.GHAST_BLOSSOM.get());
        dropPottedContents(ModBlocks.POTTED_GHAST_BLOSSOM.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return Iterables.transform(ModBlocks.BLOCKS.getEntries(), DeferredHolder::get);
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
