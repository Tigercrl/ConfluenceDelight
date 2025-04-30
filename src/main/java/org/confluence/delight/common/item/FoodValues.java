package org.confluence.delight.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodValues {
    private static final FoodProperties.Builder BASE_SLIME_PUDDING = (new FoodProperties.Builder()).nutrition(5).saturationModifier(0.6F);
    public static final FoodProperties SLIME_PUDDING = BASE_SLIME_PUDDING.build();
    public static final FoodProperties PINK_SLIME_PUDDING = BASE_SLIME_PUDDING.effect(
            () -> new MobEffectInstance(
                    MobEffects.REGENERATION,
                    vectorwing.farmersdelight.common.FoodValues.BRIEF_DURATION,
                    0, false, true
            ), 1F
    ).build();
}