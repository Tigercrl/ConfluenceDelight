package org.confluence.delight.data.gen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.confluence.delight.ConfluenceDelight;
import org.confluence.delight.common.registry.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ConfluenceDelight.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.SLIME_PUDDING.get());
        basicItem(ModItems.PINK_SLIME_PUDDING.get());

        blockItem(ModItems.WILD_GHARROTS.get());
        blockItem(ModItems.GHAST_BLOSSOM.get());

        basicItem(ModItems.ADAMANTITE_KNIFE.get());
        basicItem(ModItems.BLOOD_KNIFE.get());
        basicItem(ModItems.BONE_KNIFE.get());
        basicItem(ModItems.COBALT_KNIFE.get());
        basicItem(ModItems.COPPER_KNIFE.get());
        basicItem(ModItems.FOSSIL_KNIFE.get());
        basicItem(ModItems.HALLOWED_KNIFE.get());
        basicItem(ModItems.LEAD_KNIFE.get());
        basicItem(ModItems.MOLTEN_KNIFE.get());
        basicItem(ModItems.MYTHRIL_KNIFE.get());
        basicItem(ModItems.ORICHALCUM_KNIFE.get());
        basicItem(ModItems.PALLADIUM_KNIFE.get());
        basicItem(ModItems.PLATINUM_KNIFE.get());
        basicItem(ModItems.SHADOW_KNIFE.get());
        basicItem(ModItems.SILVER_KNIFE.get());
        basicItem(ModItems.TIN_KNIFE.get());
        basicItem(ModItems.TITANIUM_KNIFE.get());
        basicItem(ModItems.TUNGSTEN_KNIFE.get());
        basicItem(ModItems.ZENISH.get());
    }

    public ItemModelBuilder blockItem(Item item) {
        ResourceLocation location = BuiltInRegistries.ITEM.getKey(item);
        return getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("item/handheld")).texture("layer0", ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "block/" + location.getPath()));
    }
}