package cofh.thermal.horizons.init;

import cofh.lib.item.impl.SignItemCoFH;
import net.minecraft.item.Item;

import static cofh.lib.util.constants.Constants.ID_THERMAL_HORIZONS;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.util.RegistrationHelper.registerItem;
import static cofh.thermal.lib.common.ThermalItemGroups.THERMAL_BLOCKS;

public class THorzItems {

    private THorzItems() {

    }

    public static void register() {

        registerItem("rubberwood_sign", () -> new SignItemCoFH(new Item.Properties().stacksTo(16).tab(THERMAL_BLOCKS), BLOCKS.get("rubberwood_sign"), BLOCKS.get("rubberwood_wall_sign")).setModId(ID_THERMAL_HORIZONS));
    }

}
