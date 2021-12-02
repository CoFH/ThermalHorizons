package cofh.thermal.horizons.event;

import cofh.thermal.lib.common.ThermalConfig;
import net.minecraft.item.Items;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.constants.Constants.ID_THERMAL_HORIZONS;
import static cofh.lib.util.helpers.ItemHelper.cloneStack;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.horizons.init.THorzIDs.ID_RUBBERWOOD_SAPLING;

@Mod.EventBusSubscriber(modid = ID_THERMAL_HORIZONS)
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

        if (!ThermalConfig.enableWandererTrades.get()) {
            return;
        }
        event.getRareTrades().add(new BasicTrade(cloneStack(Items.EMERALD, 8), cloneStack(ITEMS.get(ID_RUBBERWOOD_SAPLING)), 8, 1, 0.05F));
    }

}
