package baguchan.frostrealm.item.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public class DeferredBlockItem extends BlockItem {
    private final Supplier<Block> block;

    public DeferredBlockItem(DeferredBlock<Block> blockDeferredBlock, Properties p) {
        super(Blocks.AIR, p);
        this.block = blockDeferredBlock;
    }

    @Override
    public Block getBlock() {
        return this.block.get();
    }
}
