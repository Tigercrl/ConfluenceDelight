package org.confluence.delight.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.delight.ConfluenceDelight;
import org.confluence.delight.common.effect.harmful.BloodCurse;

import java.util.function.Supplier;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, ConfluenceDelight.MODID);

    public static final Supplier<MobEffect> BLOOD_CURSE = EFFECTS.register("blood_curse", BloodCurse::new);
}
