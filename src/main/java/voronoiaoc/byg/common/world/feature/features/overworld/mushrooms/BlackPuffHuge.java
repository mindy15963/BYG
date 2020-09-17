package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import voronoiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class BlackPuffHuge extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public BlackPuffHuge(Codec<BYGMushroomFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);int randTreeHeight = 2 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.add(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 2, 0));
                this.treeBranch(worldIn, mainmutable.add(0, 2, -1));
                this.treeBranch(worldIn, mainmutable.add(-1, 2, 0));
                this.treeBranch(worldIn, mainmutable.add(1, 2, 0));
                this.treeBranch(worldIn, mainmutable.add(0, 2, 1));
                this.treeBranch(worldIn, mainmutable.add(0, 3, -2));
                this.treeBranch(worldIn, mainmutable.add(-2, 3, 0));
                this.treeBranch(worldIn, mainmutable.add(2, 3, 0));
                this.treeBranch(worldIn, mainmutable.add(0, 3, 2));
                this.leafs(worldIn, mainmutable.add(-1, 3, -1));
                this.leafs(worldIn, mainmutable.add(0, 3, -1));
                this.leafs(worldIn, mainmutable.add(1, 3, -1));
                this.leafs(worldIn, mainmutable.add(-1, 3, 0));
                this.leafs(worldIn, mainmutable.add(0, 3, 0));
                this.leafs(worldIn, mainmutable.add(1, 3, 0));
                this.leafs(worldIn, mainmutable.add(-1, 3, 1));
                this.leafs(worldIn, mainmutable.add(0, 3, 1));
                this.leafs(worldIn, mainmutable.add(1, 3, 1));
                this.leafs(worldIn, mainmutable.add(-1, 4, -1));
                this.leafs(worldIn, mainmutable.add(0, 4, -1));
                this.leafs(worldIn, mainmutable.add(1, 4, -1));
                this.leafs(worldIn, mainmutable.add(-1, 4, 0));
                this.leafs(worldIn, mainmutable.add(0, 4, 0));
                this.leafs(worldIn, mainmutable.add(1, 4, 0));
                this.leafs(worldIn, mainmutable.add(-1, 4, 1));
                this.leafs(worldIn, mainmutable.add(0, 4, 1));
                this.leafs(worldIn, mainmutable.add(1, 4, 1));
                this.leafs(worldIn, mainmutable.add(0, 5, -1));
                this.leafs(worldIn, mainmutable.add(-1, 5, 0));
                this.leafs(worldIn, mainmutable.add(0, 5, 0));
                this.leafs(worldIn, mainmutable.add(1, 5, 0));
                this.leafs(worldIn, mainmutable.add(0, 5, 1));
                this.leafs(worldIn, mainmutable.add(0, 6, -1));
                this.leafs(worldIn, mainmutable.add(-1, 6, 0));
                this.leafs(worldIn, mainmutable.add(0, 6, 0));
                this.leafs(worldIn, mainmutable.add(1, 6, 0));
                this.leafs(worldIn, mainmutable.add(0, 6, 1));
                this.leafs(worldIn, mainmutable.add(-1, 7, 0));
                this.leafs(worldIn, mainmutable.add(0, 7, 0));
                this.leafs(worldIn, mainmutable.add(1, 7, 0));
                this.leafs(worldIn, mainmutable.add(0, 8, 0));
                this.leafs(worldIn, mainmutable.add(0, 9, 0));
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.BROWN_MUSHROOM_STEM.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.BROWN_MUSHROOM_STEM.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.PUFF_MUSHROOM_BLOCK.getDefaultState(), boundingBox);
        }
    }


    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 0;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canLogPlaceHere(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}