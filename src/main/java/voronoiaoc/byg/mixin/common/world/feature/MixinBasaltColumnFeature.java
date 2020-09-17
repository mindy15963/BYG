package voronoiaoc.byg.mixin.common.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.BasaltColumnFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BasaltColumnFeature.class)
public class MixinBasaltColumnFeature {

    @Inject(at = @At("HEAD"), method = "func_236247_a_(Lnet/minecraft/world/IWorld;ILnet/minecraft/util/math/BlockPos;)Z", cancellable = true)
    private static void injectWater(IWorld world, int topY, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (world.getDimensionType() == DimensionType.OVERWORLD_TYPE) {
            cir.cancel();
            BlockState blockstate = world.getBlockState(pos);
            cir.setReturnValue(blockstate.isAir() || blockstate.isIn(Blocks.WATER) || blockstate.isIn(Blocks.LAVA) && pos.getY() <= topY);
        }
    }
}