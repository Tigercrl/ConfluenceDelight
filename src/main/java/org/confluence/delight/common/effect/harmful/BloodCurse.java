package org.confluence.delight.common.effect.harmful;

import net.minecraft.util.FastColor;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class BloodCurse extends MobEffect {
    public BloodCurse() {
        super(MobEffectCategory.HARMFUL, FastColor.ARGB32.color(255, 170, 0, 0));
    }
}
