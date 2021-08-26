package cofh.thermal.horizons;

import cofh.thermal.horizons.init.THorzBlocks;
import cofh.thermal.horizons.world.gen.feature.THorzFeatures;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.AxeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.HashMap;
import java.util.Map;

import static cofh.lib.util.constants.Constants.ID_THERMAL_HORIZONS;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.lib.common.ThermalIDs.*;

@Mod(ID_THERMAL_HORIZONS)
public class ThermalHorizons {

    public ThermalHorizons() {

        setFeatureFlags();

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        THorzBlocks.register();
    }

    private void setFeatureFlags() {

    }

    // region INITIALIZATION
    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {

            Map<Block, Block> axeMap = new HashMap<>(AxeItem.BLOCK_STRIPPING_MAP.size() + 2);
            axeMap.putAll(AxeItem.BLOCK_STRIPPING_MAP);
            axeMap.put(BLOCKS.get(ID_ELASTICA_LOG), BLOCKS.get(ID_STRIPPED_ELASTICA_LOG));
            axeMap.put(BLOCKS.get(ID_ELASTICA_WOOD), BLOCKS.get(ID_STRIPPED_ELASTICA_WOOD));
            AxeItem.BLOCK_STRIPPING_MAP = axeMap;
        });
        event.enqueueWork(THorzBlocks::setup);
        event.enqueueWork(THorzFeatures::setup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        registerRenderLayers();
    }
    // endregion

    // region HELPERS
    private void registerRenderLayers() {

        RenderType cutout = RenderType.getCutout();

        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_ELASTICA_SAPLING), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get("elastica_door"), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get("elastica_trapdoor"), cutout);
    }
    // endregion
}
