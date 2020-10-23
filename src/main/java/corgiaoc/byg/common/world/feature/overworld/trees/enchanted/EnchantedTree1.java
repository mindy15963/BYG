package corgiaoc.byg.common.world.feature.overworld.trees.enchanted;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class EnchantedTree1 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public EnchantedTree1(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = 13 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 20, 5, 5, isSapling)) {
                return false;
            } else {
                buildTrunkBase(changedBlocks, worldIn, config, rand, boundsIn, mainmutable.setPos(pos).toImmutable());
                mainmutable.setPos(pos);

                for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
                    placeTrunk(config, rand, changedBlocks, worldIn, mainmutable, boundsIn);

                    mainmutable.move(Direction.UP);
                }
                mainmutable.setPos(pos);

                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 9, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 8, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 8, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 8, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 7, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 7, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 7, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 7, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 7, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 7, 2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 6, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 6, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 6, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 6, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 6, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 6, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 5, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 5, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 5, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 5, 2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 5, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 5, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 5, 4), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 4, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, -2), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 4, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 4, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 4, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 4, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 4, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 4, 4), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 4, 5), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 3, -3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 3, -1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 3, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 3, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 3, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 3, 4), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 5), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 2, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 2, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 2, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 2, 5), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 1, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, 3), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight, 1), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 8, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 8, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 8, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 7, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 7, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 6, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 6, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 6, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 6, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 6, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 6, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 5, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 5, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 5, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 4, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 4, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-4, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(5, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 4, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 4, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 4, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 4, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 4, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 4, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 4, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 4, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 4, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 4, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 4, 6), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 3, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 3, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-4, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(5, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 3, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 3, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 3, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 6), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 2, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-4, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(5, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 2, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 2, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 2, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 2, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 2, 6), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 1, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 1, 5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight + 1, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight + 2, 1), boundsIn);
            }
        }
        return true;
    }
}