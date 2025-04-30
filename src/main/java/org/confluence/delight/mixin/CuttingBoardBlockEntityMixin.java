package org.confluence.delight.mixin;

import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.confluence.delight.common.registry.ModSounds;
import org.confluence.delight.common.registry.ModTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vectorwing.farmersdelight.common.block.entity.CuttingBoardBlockEntity;
import vectorwing.farmersdelight.common.block.entity.SyncedBlockEntity;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;

import java.util.Optional;
import java.util.stream.Collectors;

@Mixin(CuttingBoardBlockEntity.class)
public abstract class CuttingBoardBlockEntityMixin {
    @Unique
    private final RecipeManager.CachedCheck<SingleRecipeInput, SmokingRecipe> confluenceDelight$smokingQuickCheck =
            RecipeManager.createCheck(RecipeType.SMOKING);

    @Shadow
    public abstract void playSound(SoundEvent sound, float volume, float pitch);

    @Unique
    private Optional<RecipeHolder<SmokingRecipe>> confluenceDelight$getSmokingRecipe(ItemStack boardItem) {
        return confluenceDelight$smokingQuickCheck.getRecipeFor(
                new SingleRecipeInput(boardItem),
                ((SyncedBlockEntity) (Object) this).getLevel()
        );
    }

    @Inject(method = "getMatchingRecipe", at = @At("RETURN"), cancellable = true)
    public void hotKnifeRecipe(ItemStack toolStack, Player player, CallbackInfoReturnable<Optional<RecipeHolder<CuttingBoardRecipe>>> cir) {
        Optional<RecipeHolder<CuttingBoardRecipe>> returnValue = cir.getReturnValue();
        if (toolStack.is(ModTags.HOT_KNIVES)) {
            returnValue.ifPresent(recipeHolder -> {
                CuttingBoardRecipe recipe = recipeHolder.value();
                cir.setReturnValue(Optional.of(new RecipeHolder<>(recipeHolder.id(), new CuttingBoardRecipe(
                        recipe.getGroup(),
                        recipe.getIngredients().getFirst(),
                        recipe.getTool(),
                        NonNullList.copyOf(recipe.getRollableResults().stream().map(result ->
                                new ChanceResult(
                                        confluenceDelight$getSmokingRecipe(result.stack()).map(holder -> {
                                            ItemStack output = holder.value().assemble(
                                                    new SingleRecipeInput(result.stack()),
                                                    ((SyncedBlockEntity) (Object) this).getLevel().registryAccess()
                                            );
                                            output.setCount(result.stack().getCount());
                                            return output;
                                        }).orElse(result.stack()),
                                        result.chance()
                                )
                        ).collect(Collectors.toList())),
                        recipe.getSoundEvent()
                ))));
            });
        }
    }

    @Inject(method = "playProcessingSound", at = @At("HEAD"))
    private void playHotKnifeSound(SoundEvent sound, ItemStack tool, ItemStack boardItem, CallbackInfo ci) {
        if (tool.is(ModTags.HOT_KNIVES) && confluenceDelight$getSmokingRecipe(boardItem).isPresent()) {
            playSound(ModSounds.BLOCK_CUTTING_BOARD_HOT_KNIFE, 0.8F, 1.0F);
        }
    }
}
