package cofh.thermal.horizons.data;

import cofh.lib.data.LootTableProviderCoFH;
import net.minecraft.data.DataGenerator;

import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;

public class THorzLootTableProvider extends LootTableProviderCoFH {

    public THorzLootTableProvider(DataGenerator gen) {

        super(gen);
    }

    @Override
    public String getName() {

        return "Thermal Horizons: Loot Tables";
    }

    @Override
    protected void addTables() {

        var regBlocks = BLOCKS;
        var regItems = ITEMS;

    }

}
