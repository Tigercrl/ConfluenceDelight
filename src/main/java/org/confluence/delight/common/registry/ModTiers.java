package org.confluence.delight.common.registry;

import net.minecraft.world.item.crafting.Ingredient;
import org.confluence.mod.common.init.ModTags;
import org.confluence.mod.common.init.ModTiers.PoweredTier;

public class ModTiers {
    public static final PoweredTier ZENISH = new PoweredTier(114514, ModTags.Blocks.UNBREAKABLE, 114514, 100.0F, 100.0F, 100, () -> Ingredient.EMPTY);
}
