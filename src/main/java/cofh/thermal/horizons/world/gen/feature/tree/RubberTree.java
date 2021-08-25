package cofh.thermal.horizons.world.gen.feature.tree;

import cofh.thermal.horizons.world.gen.feature.THorzFeatures;
import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class RubberTree extends BigTree {

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {

        return THorzFeatures.RUBBER_TREE;
    }

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getHugeTreeFeature(Random rand) {

        return THorzFeatures.MEGA_RUBBER_TREE;
    }

}