package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class CanyonEdgeSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    public CanyonEdgeSB(Codec<SurfaceBuilderConfig> config) {
        super(config);
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        for (int yPos = startHeight + 100; yPos >= seaLevel - 3; --yPos) {
            mutable.setPos(xPos, yPos, zPos);
            if (yPos >= seaLevel - 1)
                chunkIn.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
        }

        for (int y = seaLevel - 1; y >= seaLevel - 20; y--) {
            mutable.setPos(xPos, y, zPos);
            if (chunkIn.getBlockState(mutable).isAir()) {
                chunkIn.setBlockState(mutable, Blocks.WATER.getDefaultState(), false);
                chunkIn.getFluidsToBeTicked().scheduleTick(mutable, Fluids.WATER, 0);
            }
        }
        SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState()));
    }
}