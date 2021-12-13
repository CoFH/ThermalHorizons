package cofh.thermal.horizons;

import cofh.thermal.horizons.init.THorzBlocks;
import cofh.thermal.horizons.init.THorzItems;
import cofh.thermal.horizons.world.gen.feature.THorzFeatures;
import net.minecraft.block.WoodType;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static cofh.lib.util.constants.Constants.ID_THERMAL_HORIZONS;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.horizons.init.THorzIDs.ID_RUBBERWOOD_SAPLING;

@Mod (ID_THERMAL_HORIZONS)
public class ThermalHorizons {

    public ThermalHorizons() {

        setFeatureFlags();

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        THorzBlocks.register();
        THorzItems.register();
    }

    private void setFeatureFlags() {

    }

    public static final WoodType RUBBERWOOD = WoodType.create("thermal:rubberwood");

    // region INITIALIZATION
    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(THorzBlocks::setup);
        event.enqueueWork(THorzFeatures::setup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        this.registerRenderLayers();

        event.enqueueWork(() -> {
            // WOOD TYPES
            Atlases.addWoodType(RUBBERWOOD);
        });
    }
    // endregion

    // region HELPERS
    private void registerRenderLayers() {

        RenderType cutout = RenderType.cutout();

        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_RUBBERWOOD_SAPLING), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get("rubberwood_door"), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get("rubberwood_trapdoor"), cutout);
    }
    // endregion
}
