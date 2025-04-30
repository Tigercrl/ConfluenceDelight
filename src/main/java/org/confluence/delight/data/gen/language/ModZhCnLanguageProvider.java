package org.confluence.delight.data.gen.language;

import net.minecraft.data.PackOutput;
import org.confluence.delight.common.registry.ModCreativeTabs;
import org.confluence.delight.common.registry.ModItems;

public class ModZhCnLanguageProvider extends AbstractModLanguageProvider {
    public ModZhCnLanguageProvider(PackOutput output) {
        super(output, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add("options.biomeBlendRadius.better", "32x32（更好 - 汇流乐事）");
        add("confluence_delight.configuration.shineEffectFix", "修复发光效果");
        add("confluence_delight.configuration.shineEffectFix.tooltip", "修复汇流来世的发光效果");
        add("confluence_delight.configuration.betterBiomeBlend", "更好的群系过渡");
        add("confluence_delight.configuration.betterBiomeBlend.tooltip", "使用更高的生物群系过渡距离");
        add("confluence_delight.configuration.trLoading", "泰拉瑞亚加载");
        add("confluence_delight.configuration.trLoading.tooltip", "使用泰拉瑞亚加载界面");

        addCreativeTab(ModCreativeTabs.FOOD, "汇流乐事｜食物");
        addCreativeTab(ModCreativeTabs.TOOL, "汇流乐事｜工具");
        addCreativeTab(ModCreativeTabs.DEVELOPER, "汇流乐事｜开发者物品");


        addItem(ModItems.SLIME_PUDDING, "史莱姆布丁", "“滑溜又好吃！”");
        addItem(ModItems.PINK_SLIME_PUDDING, "粉史莱姆布丁", "“超级弹性！”");

        addItem(ModItems.ADAMANTITE_KNIFE, "精金刀");
        addItem(ModItems.BLOOD_KNIFE, "血肉刀");
        addItem(ModItems.BONE_KNIFE, "骨刀");
//        addItem(ModItems.CHLOROPHYTE_KNIFE, "叶绿刀");
        addItem(ModItems.COBALT_KNIFE, "钴刀");
        addItem(ModItems.COPPER_KNIFE, "铜刀");
        addItem(ModItems.FOSSIL_KNIFE, "化石刀");
        addItem(ModItems.HALLOWED_KNIFE, "神圣刀");
        addItem(ModItems.LEAD_KNIFE, "铅刀");
//        addItem(ModItems.LUMINITE_KNIFE, "夜明刀");
//        addItem(ModItems.METEOR_KNIFE, "流行刀");
        addItem(ModItems.MOLTEN_KNIFE, "熔岩刀");
        addItem(ModItems.MYTHRIL_KNIFE, "秘银刀");
        addItem(ModItems.ORICHALCUM_KNIFE, "山铜刀");
        addItem(ModItems.PALLADIUM_KNIFE, "钯金刀");
        addItem(ModItems.PLATINUM_KNIFE, "铂金刀");
        addItem(ModItems.SHADOW_KNIFE, "暗影刀");
//        addItem(ModItems.SHROOMITE_KNIFE, "蘑菇矿刀");
        addItem(ModItems.SILVER_KNIFE, "银刀");
        addItem(ModItems.TIN_KNIFE, "锡刀");
        addItem(ModItems.TITANIUM_KNIFE, "钛金刀");
        addItem(ModItems.TUNGSTEN_KNIFE, "钨刀");

        addItem(ModItems.ZENISH, "§l§a天§b顶§e鱼", "“只要把它当武器就彳亍”");

        add("confluence_delight.subtitles.cutting_board.knife_cut.hot", "刀：加热");
    }
}
