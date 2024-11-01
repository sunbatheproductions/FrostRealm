package baguchan.frostrealm.block;

import baguchan.frostrealm.entity.brain.YetiAi;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class StarDustCrystalBlock extends Block {
	public StarDustCrystalBlock(Properties properties) {
		super(properties);
	}

	@Override
	public BlockState playerWillDestroy(Level p_49852_, BlockPos p_49853_, BlockState p_49854_, Player p_49855_) {
		super.playerWillDestroy(p_49852_, p_49853_, p_49854_, p_49855_);
		if (p_49852_ instanceof ServerLevel serverLevel) {
			YetiAi.angerNearbyYeti(serverLevel, p_49855_, true);
		}
		return p_49854_;
	}
}
