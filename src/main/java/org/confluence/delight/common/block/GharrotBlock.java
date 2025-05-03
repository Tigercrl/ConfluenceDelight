package org.confluence.delight.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.confluence.delight.common.registry.ModItems;
import org.jetbrains.annotations.NotNull;

public class GharrotBlock extends CropBlock {
    public static final MapCodec<GharrotBlock> CODEC = simpleCodec(GharrotBlock::new);
    public static final int FIRST_MAX_AGE = 8; // 萝卜成熟
    public static final int SECOND_MAX_AGE = 13; // 开花
    public static final int MAX_AGE = SECOND_MAX_AGE;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, MAX_AGE);

    public GharrotBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    @Override
    public MapCodec<GharrotBlock> codec() {
        return CODEC;
    }

    @NotNull
    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.GHARROT.get();
    }

    @NotNull
    @Override
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        int height = 0;
        switch (state.getValue(AGE)) {
            case 0, 1 -> height = 2;
            case 2, 3 -> height = 3;
            case 4, 5 -> height = 4;
            case 6, 7 -> height = 5;
            case 8 -> height = 6;
            case 9 -> height = 7;
            case 10 -> height = 8;
            case 11 -> height = 9;
            case 12 -> height = 10;
            case 13 -> height = 12;
        }
        return Block.box(0, 0, 0, 16, height, 16);
    }

    @NotNull
    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
