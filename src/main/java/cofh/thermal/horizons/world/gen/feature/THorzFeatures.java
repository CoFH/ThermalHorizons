package cofh.thermal.horizons.world.gen.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.horizons.init.THorzIDs.ID_RUBBERWOOD_LEAVES;
import static cofh.thermal.horizons.init.THorzIDs.ID_RUBBERWOOD_LOG;

public class THorzFeatures {

    private THorzFeatures() {

    }

    public static void setup() {

        RUBBERWOOD_TREE = FeatureUtils.register("rubberwood_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BLOCKS.get(ID_RUBBERWOOD_LOG)),
                new StraightTrunkPlacer(3, 2, 0),
                BlockStateProvider.simple(BLOCKS.get(ID_RUBBERWOOD_LEAVES)),
                new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                new TwoLayersFeatureSize(1, 0, 1))
                .ignoreVines()
                .build());

        MEGA_RUBBERWOOD_TREE = FeatureUtils.register("mega_rubberwood_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BLOCKS.get(ID_RUBBERWOOD_LOG)),
                new MegaJungleTrunkPlacer(7, 2, 2),
                BlockStateProvider.simple(BLOCKS.get(ID_RUBBERWOOD_LEAVES)),
                new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(1, 1, 2))
                .ignoreVines()
                .build());
    }

    public static Holder<ConfiguredFeature<TreeConfiguration, ?>> RUBBERWOOD_TREE;
    public static Holder<ConfiguredFeature<TreeConfiguration, ?>> MEGA_RUBBERWOOD_TREE;

}
