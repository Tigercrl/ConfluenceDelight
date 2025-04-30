package org.confluence.delight.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static org.confluence.delight.ConfluenceDelight.resource;

public class ModTags {
    public static final TagKey<Item> KNIVES = item("tools/knives");
    public static final TagKey<Item> HOT_KNIVES = item("tools/hot_knives");

    private static TagKey<Item> item(String path) {
        return ItemTags.create(resource(path));
    }

    private static TagKey<Block> block(String path) {
        return BlockTags.create(resource(path));
    }

    private static TagKey<EntityType<?>> entity(String path) {
        return TagKey.create(Registries.ENTITY_TYPE, resource(path));
    }
}
