package cofh.thermal.horizons.world.gen.feature;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.JungleFoliagePlacer;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.trunkplacer.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.lib.common.ThermalIDs.ID_RUBBERWOOD_LEAVES;
import static cofh.thermal.lib.common.ThermalIDs.ID_RUBBERWOOD_LOG;

public class THorzFeatures {

    private THorzFeatures() {

    }

    public static void setup() {

        RUBBERWOOD_TREE = register("rubberwood_tree",
                Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(BLOCKS.get(ID_RUBBERWOOD_LOG).defaultBlockState()),
                        new SimpleBlockStateProvider(BLOCKS.get(ID_RUBBERWOOD_LEAVES).defaultBlockState()),
                        new AcaciaFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0)),
                        new StraightTrunkPlacer(3, 2, 0),
                        new TwoLayerFeature(1, 0, 1)))
                        .ignoreVines()
                        .build()));

        MEGA_RUBBERWOOD_TREE = register("mega_rubberwood_tree",
                Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(BLOCKS.get(ID_RUBBERWOOD_LOG).defaultBlockState()),
                        new SimpleBlockStateProvider(BLOCKS.get(ID_RUBBERWOOD_LEAVES).defaultBlockState()),
                        new JungleFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 2),
                        new MegaJungleTrunkPlacer(7, 2, 2),
                        new TwoLayerFeature(1, 1, 2)))
                        .ignoreVines()
                        .build()));
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {

        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(ID_THERMAL, key), configuredFeature);
    }

    private static DepthAverageConfig depthRange(int base, int spread) {

        return new DepthAverageConfig(base, spread);
    }

    private static TopSolidRangeConfig topRange(int min, int max) {

        return new TopSolidRangeConfig(min, min, max);
    }

    public static ConfiguredFeature<BaseTreeFeatureConfig, ?> RUBBERWOOD_TREE;
    public static ConfiguredFeature<BaseTreeFeatureConfig, ?> MEGA_RUBBERWOOD_TREE;

}
