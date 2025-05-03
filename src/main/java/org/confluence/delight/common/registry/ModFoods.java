package org.confluence.delight.common.registry;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties GHARROT =
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.6F)
                    .effect(() -> new MobEffectInstance(
                            Holder.direct(ModEffects.BLOOD_CURSE.get()),
                            120,
                            0
                    ), 0.1F)
                    .build();
}
