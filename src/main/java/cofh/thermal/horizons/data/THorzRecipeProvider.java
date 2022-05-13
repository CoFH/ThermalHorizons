package cofh.thermal.horizons.data;

import cofh.lib.data.RecipeProviderCoFH;
import cofh.thermal.lib.common.ThermalFlags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.ITEMS;

public class THorzRecipeProvider extends RecipeProviderCoFH {

    public THorzRecipeProvider(DataGenerator generatorIn) {

        super(generatorIn, ID_THERMAL);
        manager = ThermalFlags.manager();
    }

    @Override
    public String getName() {

        return "Thermal Horizons: Recipes";
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        var reg = ITEMS;

    }

}
