package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.Simple2BlockProviderConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;

import java.util.Random;

public class ConfigurableIceAndSnow extends ChunkCoordinatesFeature<Simple2BlockProviderConfig> {
    public ConfigurableIceAndSnow(Codec<Simple2BlockProviderConfig> config) {
        super(config);
    }

    @Override
    public boolean generate(ISeedReader world, Random random, IChunk chunkIn, int x, int z, Simple2BlockProviderConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        BlockPos.Mutable mutable2 = new BlockPos.Mutable();

        int height = world.getHeight(Heightmap.Type.MOTION_BLOCKING, x, z);
        mutable.setPos(x, height, z);
        mutable2.setPos(mutable).move(Direction.DOWN, 1);
        Biome biome = world.getBiome(mutable);
        if (biome.doesWaterFreeze(world, mutable2, false)) {
            chunkIn.setBlockState(mutable2, config.getBlockProvider().getBlockState(random, mutable2), false);
        }

        if (biome.doesSnowGenerate(world, mutable)) {
            chunkIn.setBlockState(mutable, config.getBlockProvider2().getBlockState(random, mutable), false);
            BlockState blockstate = world.getBlockState(mutable2);
            if (blockstate.hasProperty(BlockStateProperties.SNOWY)) {
                if (blockstate.get(BlockStateProperties.SNOWY) && world.getBlockState(mutable2.offset(Direction.UP)).getBlock() == Blocks.SNOW) {
                    chunkIn.setBlockState(mutable2, blockstate.with(BlockStateProperties.SNOWY, true), false);
                }
            }
        }

        return true;
    }
}