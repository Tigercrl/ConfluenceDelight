package org.confluence.delight.data.gen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.confluence.delight.ConfluenceDelight;
import org.confluence.delight.common.registry.ModBlocks;
import vectorwing.farmersdelight.FarmersDelight;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ConfluenceDelight.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        wildCropBlock(ModBlocks.WILD_GHARROTS.get());
        simpleCrossBlock(ModBlocks.GHAST_BLOSSOM.get());
        flowerPotBlock(ModBlocks.POTTED_GHAST_BLOSSOM.get(), ModBlocks.GHAST_BLOSSOM.get());
    }

    private static String blockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    public static ResourceLocation resourceBlock(Block block) {
        return ResourceLocation.fromNamespaceAndPath(ConfluenceDelight.MODID, "block/" + blockName(block));
    }

    public void simpleCrossBlock(Block block) {
        simpleBlock(block, models().cross(blockName(block), resourceBlock(block)).renderType("cutout"));
    }

    public void flowerPotBlock(Block pottedBlock, Block flowerBlock) {
        simpleBlock(pottedBlock, models().withExistingParent(blockName(pottedBlock), "minecraft:block/flower_pot_cross").texture("plant", resourceBlock(flowerBlock)).renderType("cutout"));
    }

    public void wildCropBlock(Block block) {
        wildCropBlock(block, false);
    }

    public void wildCropBlock(Block block, boolean isBushCrop) {
        if (isBushCrop) {
            simpleBlock(block, models().singleTexture(blockName(block), ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID, "block/bush_crop"), "crop", resourceBlock(block)).renderType("cutout"));
        } else {
            simpleBlock(block, models().cross(blockName(block), resourceBlock(block)).renderType("cutout"));
        }
    }
}