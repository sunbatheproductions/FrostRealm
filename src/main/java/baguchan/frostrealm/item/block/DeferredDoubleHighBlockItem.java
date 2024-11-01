package baguchan.frostrealm.item.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public class DeferredDoubleHighBlockItem extends BlockItem {
    private final Supplier<? extends Block> block;


    public DeferredDoubleHighBlockItem(DeferredBlock<? extends Block> blockDeferredBlock, Item.Properties p) {
        super(Blocks.AIR, p);
        this.block = blockDeferredBlock;
    }

    @Override
    public Block getBlock() {
        return this.block.get();
    }

    @Override
    protected boolean placeBlock(BlockPlaceContext p_41013_, BlockState p_41014_) {
        Level level = p_41013_.getLevel();
        BlockPos blockpos = p_41013_.getClickedPos().above();
        BlockState blockstate = level.isWaterAt(blockpos) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
        level.setBlock(blockpos, blockstate, 27);
        return super.placeBlock(p_41013_, p_41014_);
    }
}
