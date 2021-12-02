package cofh.thermal.horizons.init;

import cofh.thermal.horizons.world.gen.feature.tree.RubberTree;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.AxeItem;
import net.minecraft.tileentity.TileEntityType;

import java.util.HashMap;
import java.util.Map;

import static cofh.lib.util.constants.Constants.ID_THERMAL_HORIZONS;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.util.RegistrationHelper.*;
import static cofh.thermal.horizons.ThermalHorizons.RUBBERWOOD;
import static cofh.thermal.horizons.init.THorzIDs.*;
import static net.minecraft.block.AbstractBlock.Properties.of;

public class THorzBlocks {

    private THorzBlocks() {

    }

    public static void register() {

        registerWoodBlocks();
    }

    public static void setup() {

        FireBlock fire = (FireBlock) Blocks.FIRE;

        fire.setFlammable(BLOCKS.get(ID_RUBBERWOOD_LEAVES), 30, 60);

        ComposterBlock.add(0.3F, ITEMS.get(ID_RUBBERWOOD_SAPLING));
        ComposterBlock.add(0.3F, ITEMS.get(ID_RUBBERWOOD_LEAVES));


        // AXE STRIPPING
        {
            Map<Block, Block> axeMap = new HashMap<>(AxeItem.STRIPABLES.size() + 2);
            axeMap.putAll(AxeItem.STRIPABLES);
            axeMap.put(BLOCKS.get(ID_RUBBERWOOD_LOG), BLOCKS.get(ID_STRIPPED_RUBBERWOOD_LOG));
            axeMap.put(BLOCKS.get(ID_RUBBERWOOD_WOOD), BLOCKS.get(ID_STRIPPED_RUBBERWOOD_WOOD));
            AxeItem.STRIPABLES = axeMap;
        }
        // SIGN TILE STUFF
        {
            ImmutableSet.Builder<Block> builder = ImmutableSet.builder();
            builder.addAll(TileEntityType.SIGN.validBlocks);
            builder.add(BLOCKS.get("rubberwood_sign"));
            builder.add(BLOCKS.get("rubberwood_wall_sign"));
            TileEntityType.SIGN.validBlocks = builder.build();
        }
    }

    private static void registerWoodBlocks() {

        registerBlock(ID_RUBBERWOOD_LOG, () -> Blocks.log(MaterialColor.TERRACOTTA_GREEN, MaterialColor.QUARTZ), ID_THERMAL_HORIZONS);
        registerBlock(ID_STRIPPED_RUBBERWOOD_LOG, () -> Blocks.log(MaterialColor.TERRACOTTA_GREEN, MaterialColor.TERRACOTTA_GREEN), ID_THERMAL_HORIZONS);
        registerBlock(ID_RUBBERWOOD_WOOD, () -> new RotatedPillarBlock(of(Material.WOOD, MaterialColor.QUARTZ).strength(2.0F).sound(SoundType.WOOD)), ID_THERMAL_HORIZONS);
        registerBlock(ID_STRIPPED_RUBBERWOOD_WOOD, () -> new RotatedPillarBlock(of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).strength(2.0F).sound(SoundType.WOOD)), ID_THERMAL_HORIZONS);
        registerBlock(ID_RUBBERWOOD_SAPLING, () -> new SaplingBlock(new RubberTree(), of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)), ID_THERMAL_HORIZONS);
        registerBlock(ID_RUBBERWOOD_LEAVES, Blocks::leaves, ID_THERMAL_HORIZONS);

        registerWoodBlockSet("rubberwood", Material.WOOD, MaterialColor.TERRACOTTA_GREEN, 1.5F, 2.5F, SoundType.WOOD, ID_THERMAL_HORIZONS);

        registerBlockOnly("rubberwood_sign", () -> new StandingSignBlock(of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), RUBBERWOOD));
        registerBlockOnly("rubberwood_wall_sign", () -> new WallSignBlock(of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(BLOCKS.getSup("rubberwood_sign")), RUBBERWOOD));
    }

}
