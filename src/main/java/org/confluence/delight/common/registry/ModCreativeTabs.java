package org.confluence.delight.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.delight.ConfluenceDelight;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ConfluenceDelight.MODID);

    public static final Supplier<CreativeModeTab> FOOD = CREATIVE_TABS.register(ConfluenceDelight.MODID + "_food",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.confluence_delight.food"))
                    .icon(() -> new ItemStack(ModItems.SLIME_PUDDING.get()))
                    .displayItems((parameters, output) -> ModItems.FOOD.forEach((item) -> output.accept(item.get())))
                    .build());

    public static final Supplier<CreativeModeTab> TOOL = CREATIVE_TABS.register(ConfluenceDelight.MODID + "_tool",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.confluence_delight.tool"))
                    .icon(() -> new ItemStack(ModItems.MOLTEN_KNIFE.get()))
                    .displayItems((parameters, output) -> ModItems.TOOL.forEach((item) -> output.accept(item.get())))
                    .build());

    public static final Supplier<CreativeModeTab> DEVELOPER = CREATIVE_TABS.register(ConfluenceDelight.MODID + "_developer",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.confluence_delight.developer"))
                    .icon(() -> new ItemStack(ModItems.ZENISH.get()))
                    .displayItems((parameters, output) -> ModItems.DEVELOPER.forEach((item) -> output.accept(item.get())))
                    .build());
}