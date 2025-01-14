package baguchan.frostrealm.world.gen.feature;

import baguchan.frostrealm.registry.FrostBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class BigRockFeature extends Feature<BlockStateConfiguration> {
	public BigRockFeature(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}


	public boolean place(FeaturePlaceContext<BlockStateConfiguration> p_159471_) {
		BlockPos blockpos = p_159471_.origin();
		WorldGenLevel worldgenlevel = p_159471_.level();
		RandomSource random = p_159471_.random();

		BlockStateConfiguration blockstateconfiguration;
        for (blockstateconfiguration = p_159471_.config(); blockpos.getY() > worldgenlevel.getMinY() + 3; blockpos = blockpos.below()) {
			if (!worldgenlevel.isEmptyBlock(blockpos.below())) {
				BlockState blockstate = worldgenlevel.getBlockState(blockpos.below());
				if (isGrass(blockstate)) {
					break;
				}
			}
		}

        if (blockpos.getY() <= worldgenlevel.getMinY() + 3) {
			return false;
		} else {
			int i = random.nextInt(2) + 2;
			int i2 = random.nextInt(2) + 2;
			int i3 = Mth.clamp(random.nextInt(i), 3, i);
			float f = (float) (i2 + i + i2) * 0.35F + 0.5F;
			for (BlockPos blockpos1 : BlockPos.betweenClosed(blockpos.offset(-i2, -i, -i2), blockpos.offset(i2, i, i2))) {
				if (blockpos1.distSqr(blockpos) <= (double) (f * f)) {
					worldgenlevel.setBlock(blockpos1.below(i3), blockstateconfiguration.state, 2);
				}

			}

			return true;
		}
	}

	public static boolean isGrass(BlockState p_159760_) {
		return p_159760_.is(FrostBlocks.FROZEN_GRASS_BLOCK.get());
	}
}