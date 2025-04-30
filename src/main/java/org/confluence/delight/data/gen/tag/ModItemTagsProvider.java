package org.confluence.delight.data.gen.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.confluence.delight.ConfluenceDelight;
import org.confluence.delight.common.registry.ModItems;
import org.confluence.delight.common.registry.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.CommonTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> b, @Nullable ExistingFileHelper helper) {
        super(output, provider, b, ConfluenceDelight.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModTags.HOT_KNIVES).add(
                ModItems.MOLTEN_KNIFE.get()
        );
        tag(ModTags.KNIVES).add(
                ModItems.ADAMANTITE_KNIFE.get(),
                ModItems.BLOOD_KNIFE.get(),
                ModItems.BONE_KNIFE.get(),
                ModItems.COBALT_KNIFE.get(),
                ModItems.COPPER_KNIFE.get(),
                ModItems.FOSSIL_KNIFE.get(),
                ModItems.HALLOWED_KNIFE.get(),
                ModItems.LEAD_KNIFE.get(),
                ModItems.MYTHRIL_KNIFE.get(),
                ModItems.ORICHALCUM_KNIFE.get(),
                ModItems.PALLADIUM_KNIFE.get(),
                ModItems.PLATINUM_KNIFE.get(),
                ModItems.SHADOW_KNIFE.get(),
                ModItems.SILVER_KNIFE.get(),
                ModItems.TIN_KNIFE.get(),
                ModItems.TITANIUM_KNIFE.get(),
                ModItems.TUNGSTEN_KNIFE.get(),
                ModItems.ZENISH.get()
        ).addTags(ModTags.HOT_KNIVES);
        tag(CommonTags.TOOLS_KNIFE).addTags(ModTags.KNIVES);
        tag(vectorwing.farmersdelight.common.tag.ModTags.KNIVES).addTags(ModTags.KNIVES);

        tag(ItemTags.BEE_FOOD).add(
                ModItems.GHAST_BLOSSOM.get()
        );
        tag(ItemTags.SMALL_FLOWERS).add(
                ModItems.GHAST_BLOSSOM.get()
        );
    }
}