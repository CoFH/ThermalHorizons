package cofh.thermal.horizons.init;

import cofh.thermal.horizons.world.gen.feature.tree.RubberTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.AxeItem;

import static cofh.lib.util.constants.Constants.ID_THERMAL_HORIZONS;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.util.RegistrationHelper.registerBlock;
import static cofh.thermal.core.util.RegistrationHelper.registerWoodBlockSet;
import static cofh.thermal.lib.common.ThermalIDs.*;
import static net.minecraft.block.AbstractBlock.Properties.create;

public class THorzBlocks {

    private THorzBlocks() {

    }

    public static void register() {

        registerWoodBlocks();
    }

    public static void setup() {

        FireBlock fire = (FireBlock) Blocks.FIRE;

        fire.setFireInfo(BLOCKS.get(ID_ELASTICA_LEAVES), 30, 60);

        ComposterBlock.registerCompostable(0.3F, ITEMS.get(ID_ELASTICA_SAPLING));
        ComposterBlock.registerCompostable(0.3F, ITEMS.get(ID_ELASTICA_LEAVES));
    }

    private static void registerWoodBlocks() {

        registerBlock(ID_ELASTICA_LOG, () -> Blocks.createLogBlock(MaterialColor.GREEN_TERRACOTTA, MaterialColor.QUARTZ), ID_THERMAL_HORIZONS);
        registerBlock(ID_STRIPPED_ELASTICA_LOG, () -> Blocks.createLogBlock(MaterialColor.GREEN_TERRACOTTA, MaterialColor.GREEN_TERRACOTTA), ID_THERMAL_HORIZONS);
        registerBlock(ID_ELASTICA_WOOD, () -> new RotatedPillarBlock(create(Material.WOOD, MaterialColor.QUARTZ).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), ID_THERMAL_HORIZONS);
        registerBlock(ID_STRIPPED_ELASTICA_WOOD, () -> new RotatedPillarBlock(create(Material.WOOD, MaterialColor.GREEN_TERRACOTTA).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), ID_THERMAL_HORIZONS);
        registerBlock(ID_ELASTICA_SAPLING, () -> new SaplingBlock(new RubberTree(), create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)), ID_THERMAL_HORIZONS);
        registerBlock(ID_ELASTICA_LEAVES, Blocks::createLeavesBlock, ID_THERMAL_HORIZONS);

        registerWoodBlockSet("elastica", Material.WOOD, MaterialColor.GREEN_TERRACOTTA, 1.5F, 2.5F, SoundType.WOOD, ID_THERMAL_HORIZONS);
    }

}
