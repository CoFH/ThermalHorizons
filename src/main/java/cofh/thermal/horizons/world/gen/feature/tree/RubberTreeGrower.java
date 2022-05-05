package cofh.thermal.horizons.world.gen.feature.tree;

import cofh.thermal.horizons.world.gen.feature.THorzFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class RubberTreeGrower extends AbstractMegaTreeGrower {

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random randomIn, boolean largeHive) {

        return THorzFeatures.RUBBERWOOD_TREE;
    }

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(Random rand) {

        return THorzFeatures.MEGA_RUBBERWOOD_TREE;
    }

}