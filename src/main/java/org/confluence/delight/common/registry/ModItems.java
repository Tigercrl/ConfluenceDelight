package org.confluence.delight.common.registry;

import com.google.common.collect.Sets;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.component.Unbreakable;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.delight.ConfluenceDelight;
import org.confluence.delight.common.item.FoodValues;
import org.confluence.mod.common.init.ModTiers;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.KnifeItem;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Supplier;

import static vectorwing.farmersdelight.common.registry.ModItems.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, ConfluenceDelight.MODID);
    public static LinkedHashSet<Supplier<Item>> FOOD = Sets.newLinkedHashSet();
    public static LinkedHashSet<Supplier<Item>> TOOL = Sets.newLinkedHashSet();
    public static LinkedHashSet<Supplier<Item>> DEVELOPER = Sets.newLinkedHashSet();

    public static Supplier<Item> register(final String name, final Supplier<Item> supplier) {
        return ITEMS.register(name, supplier);
    }

    public static Supplier<Item> registerFood(final String name, final Supplier<Item> supplier) {
        Supplier<Item> item = register(name, supplier);
        FOOD.add(item);
        return item;
    }

    public static Supplier<Item> registerTool(final String name, final Supplier<Item> supplier) {
        Supplier<Item> item = register(name, supplier);
        TOOL.add(item);
        return item;
    }

    public static Supplier<Item> registerDeveloper(final String name, final Supplier<Item> supplier) {
        Supplier<Item> item = register(name, supplier);
        DEVELOPER.add(item);
        return item;
    }

    public static Item.Properties withLore(Item.Properties properties, String name) {
        return properties.component(DataComponents.LORE, new ItemLore(List.of(
                Component.translatable("item.confluence_delight." + name + ".tooltip")
                        .withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC)
        )));
    }

    // Food - Slime pudding
    public static final Supplier<Item> SLIME_PUDDING = registerFood("slime_pudding",
            () -> new ConsumableItem(withLore(bowlFoodItem(FoodValues.SLIME_PUDDING), "slime_pudding")));
    public static final Supplier<Item> PINK_SLIME_PUDDING = registerFood("pink_slime_pudding",
            () -> new ConsumableItem(withLore(bowlFoodItem(FoodValues.PINK_SLIME_PUDDING), "pink_slime_pudding")));

    // Food - Gharrots
    public static final Supplier<Item> GHARROT = registerFood("gharrot",
            () -> new ItemNameBlockItem(ModBlocks.GHARROTS.get(), basicItem().food(ModFoods.GHARROT)));
    public static final Supplier<Item> WILD_GHARROTS = registerFood("wild_gharrots",
            () -> new BlockItem(ModBlocks.WILD_GHARROTS.get(), basicItem()));
    public static final Supplier<Item> GHAST_BLOSSOM = registerFood("ghast_blossom",
            () -> new BlockItem(ModBlocks.GHAST_BLOSSOM.get(), basicItem()));

    // Tools - Knives
    public static final Supplier<Item> ADAMANTITE_KNIFE = registerTool("adamantite_knife",
            () -> new KnifeItem(ModTiers.ADAMANTITE, knifeItem(ModTiers.ADAMANTITE)));
    public static final Supplier<Item> BLOOD_KNIFE = registerTool("blood_knife",
            () -> new KnifeItem(ModTiers.TR_CRIMSON, knifeItem(ModTiers.TR_CRIMSON)));
    public static final Supplier<Item> BONE_KNIFE = registerTool("bone_knife",
            () -> new KnifeItem(ModTiers.BONE, knifeItem(ModTiers.BONE)));
    //    public static final Supplier<Item> CHLOROPHYTE_KNIFE = registerWithTab("chlorophyte_knife",
//            () -> new KnifeItem(ModTiers.CHLOROPHYTE, knifeItem(ModTiers.CHLOROPHYTE)));
    public static final Supplier<Item> COBALT_KNIFE = registerTool("cobalt_knife",
            () -> new KnifeItem(ModTiers.COBALT, knifeItem(ModTiers.COBALT)));
    public static final Supplier<Item> COPPER_KNIFE = registerTool("copper_knife",
            () -> new KnifeItem(ModTiers.COPPER, knifeItem(ModTiers.COPPER)));
    public static final Supplier<Item> FOSSIL_KNIFE = registerTool("fossil_knife",
            () -> new KnifeItem(ModTiers.FOSSIL, knifeItem(ModTiers.FOSSIL)));
    public static final Supplier<Item> HALLOWED_KNIFE = registerTool("hallowed_knife",
            () -> new KnifeItem(ModTiers.HALLOWED, knifeItem(ModTiers.HALLOWED)));
    public static final Supplier<Item> LEAD_KNIFE = registerTool("lead_knife",
            () -> new KnifeItem(ModTiers.LEAD, knifeItem(ModTiers.LEAD)));
    //    public static final Supplier<Item> LUMINITE_KNIFE = registerWithTab("luminite_knife",
//            () -> new KnifeItem(ModTiers.LUMINITE, knifeItem(ModTiers.LUMINITE)));
//    public static final Supplier<Item> METEOR_KNIFE = registerWithTab("meteor_knife",
//            () -> new KnifeItem(ModTiers.METEORITE, knifeItem(ModTiers.METEORITE)));
    public static final Supplier<Item> MOLTEN_KNIFE = registerTool("molten_knife",
            () -> new KnifeItem(ModTiers.HELLSTONE, knifeItem(ModTiers.HELLSTONE)));
    public static final Supplier<Item> MYTHRIL_KNIFE = registerTool("mythril_knife",
            () -> new KnifeItem(ModTiers.MYTHRIL, knifeItem(ModTiers.MYTHRIL)));
    public static final Supplier<Item> ORICHALCUM_KNIFE = registerTool("orichalcum_knife",
            () -> new KnifeItem(ModTiers.ORICHALCUM, knifeItem(ModTiers.ORICHALCUM)));
    public static final Supplier<Item> PALLADIUM_KNIFE = registerTool("palladium_knife",
            () -> new KnifeItem(ModTiers.PALLADIUM, knifeItem(ModTiers.PALLADIUM)));
    public static final Supplier<Item> PLATINUM_KNIFE = registerTool("platinum_knife",
            () -> new KnifeItem(ModTiers.PLATINUM, knifeItem(ModTiers.PLATINUM)));
    public static final Supplier<Item> SHADOW_KNIFE = registerTool("shadow_knife",
            () -> new KnifeItem(ModTiers.DEMONITE, knifeItem(ModTiers.DEMONITE)));
    //    public static final Supplier<Item> SHROOMITE_KNIFE = registerWithTab("shroomite_knife",
//            () -> new KnifeItem(ModTiers.SHROOMITE, knifeItem(ModTiers.SHROOMITE)));
    public static final Supplier<Item> SILVER_KNIFE = registerTool("silver_knife",
            () -> new KnifeItem(ModTiers.SILVER, knifeItem(ModTiers.SILVER)));
    public static final Supplier<Item> TIN_KNIFE = registerTool("tin_knife",
            () -> new KnifeItem(ModTiers.TIN, knifeItem(ModTiers.TIN)));
    public static final Supplier<Item> TITANIUM_KNIFE = registerTool("titanium_knife",
            () -> new KnifeItem(ModTiers.TITANIUM, knifeItem(ModTiers.TITANIUM)));
    public static final Supplier<Item> TUNGSTEN_KNIFE = registerTool("tungsten_knife",
            () -> new KnifeItem(ModTiers.TUNGSTEN, knifeItem(ModTiers.TUNGSTEN)));
    public static final Supplier<Item> ZENISH = registerDeveloper("zenish",
            () -> new KnifeItem(org.confluence.delight.common.registry.ModTiers.ZENISH, withLore(
                    basicItem()
                            .component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .attributes(KnifeItem.createAttributes(org.confluence.delight.common.registry.ModTiers.ZENISH, -1F, 0F)),
                    "zenish"
            )));
}
