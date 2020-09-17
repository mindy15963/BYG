package voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.Tags;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class WeepingRoots extends Feature<NoFeatureConfig> {
    public WeepingRoots(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {

        if (!worldIn.isAirBlock(pos)) {
            return false;
        } else if (!worldIn.isAirBlock(pos) || !worldIn.getBlockState(pos.up()).getBlock().isIn(Tags.Blocks.STONE) || !worldIn.getBlockState(pos.up()).getBlock().isIn(Tags.Blocks.NETHERRACK) && !(worldIn.getDimensionType() == DimensionType.OVERWORLD_TYPE)) {
            return false;
        } else {

            worldIn.setBlockState(pos, BYGBlockList.WEEPING_ROOTS.getDefaultState(), 10);

            return true;
        }
    }
}