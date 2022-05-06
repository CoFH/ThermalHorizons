package cofh.thermal.horizons.event;

import cofh.thermal.core.config.ThermalCoreConfig;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.constants.Constants.ID_THERMAL_HORIZONS;
import static cofh.lib.util.helpers.ItemHelper.cloneStack;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.horizons.init.THorzIDs.ID_RUBBERWOOD_SAPLING;

@Mod.EventBusSubscriber (modid = ID_THERMAL_HORIZONS)
public class THorzCommonSetupEvents {

    private THorzCommonSetupEvents() {

    }

    //    @SubscribeEvent
    //    public static void setupVillagerTrades(final VillagerTradesEvent event) {
    //
    //        if (!ThermalConfig.enableVillagerTrades.get()) {
    //            return;
    //        }
    //    }

    @SubscribeEvent
    public static void setupWandererTrades(final WandererTradesEvent event) {

        if (!ThermalCoreConfig.enableWandererTrades) {
            return;
        }
        event.getRareTrades().add(new BasicItemListing(cloneStack(Items.EMERALD, 8), cloneStack(ITEMS.get(ID_RUBBERWOOD_SAPLING)), 8, 1, 0.05F));
    }

}
