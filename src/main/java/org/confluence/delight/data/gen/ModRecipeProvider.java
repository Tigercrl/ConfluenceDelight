package org.confluence.delight.data.gen;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import org.confluence.delight.common.registry.ModItems;
import org.confluence.mod.common.init.item.MaterialItems;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        // Tools - Knives
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ADAMANTITE_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.ADAMANTITE_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLOOD_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.TR_CRIMSON_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
//        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CHLOROPHYTE_KNIFE.get())
//                .pattern("m")
//                .pattern("s")
//                .define('m', MaterialItems.CHLOROPHYTE_INGOT)
//                .define('s', Items.STICK)
//                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
//                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BONE_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.ROTTEN_BONE)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COBALT_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.COBALT_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', Items.COPPER_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FOSSIL_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.STURDY_FOSSIL)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HALLOWED_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.HALLOWED_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LEAD_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.LEAD_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
//        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LUMINITE_KNIFE.get())
//                .pattern("m")
//                .pattern("s")
//                .define('m', MaterialItems.LUMINITE_INGOT)
//                .define('s', Items.STICK)
//                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
//                .save(recipeOutput);
//        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.METEOR_KNIFE.get())
//                .pattern("m")
//                .pattern("s")
//                .define('m', MaterialItems.METEORITE_INGOT)
//                .define('s', Items.STICK)
//                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
//                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MOLTEN_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.HELLSTONE_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MYTHRIL_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.MYTHRIL_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ORICHALCUM_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.ORICHALCUM_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PALLADIUM_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.PALLADIUM_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PLATINUM_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.PLATINUM_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SHADOW_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.DEMONITE_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
//        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SHROOMITE_KNIFE.get())
//                .pattern("m")
//                .pattern("s")
//                .define('m', MaterialItems.SHROOMITE_INGOT)
//                .define('s', Items.STICK)
//                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
//                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SILVER_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.SILVER_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TIN_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.TIN_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TITANIUM_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.TITANIUM_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TUNGSTEN_KNIFE.get())
                .pattern("m")
                .pattern("s")
                .define('m', MaterialItems.TUNGSTEN_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(recipeOutput);
    }
}