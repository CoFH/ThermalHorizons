package cofh.thermal.horizons.data;

import cofh.lib.util.references.CoFHTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.horizons.init.THorzIDs.*;

public class THorzTagsProvider {

    public static class Block extends BlockTagsProvider {

        public Block(DataGenerator gen, ExistingFileHelper existingFileHelper) {

            super(gen, ID_THERMAL, existingFileHelper);
        }

        @Override
        public String getName() {

            return "Thermal Horizons: Block Tags";
        }

        @Override
        protected void addTags() {

            tag(BlockTags.LEAVES).add(
                    BLOCKS.get("rubberwood_leaves")
            );
            tag(BlockTags.LOGS).add(
                    BLOCKS.get(ID_RUBBERWOOD_LOG)
            );
            tag(BlockTags.SAPLINGS).add(
                    BLOCKS.get("rubberwood_sapling")
            );

            tag(BlockTags.DOORS).add(
                    BLOCKS.get("rubberwood_door")
            );
            tag(BlockTags.FENCES).add(
                    BLOCKS.get("rubberwood_fence")
            );
            tag(BlockTags.FENCE_GATES).add(
                    BLOCKS.get("rubberwood_fence_gate")
            );
            tag(BlockTags.PLANKS).add(
                    BLOCKS.get("rubberwood_planks")
            );
            tag(BlockTags.SLABS).add(
                    BLOCKS.get("rubberwood_slab")
            );
            tag(BlockTags.STAIRS).add(
                    BLOCKS.get("rubberwood_stairs")
            );

            tag(BlockTags.WOODEN_DOORS).add(
                    BLOCKS.get("rubberwood_door")
            );
            tag(BlockTags.WOODEN_FENCES).add(
                    BLOCKS.get("rubberwood_fence")
            );
            tag(BlockTags.WOODEN_SLABS).add(
                    BLOCKS.get("rubberwood_slab")
            );
            tag(BlockTags.WOODEN_STAIRS).add(
                    BLOCKS.get("rubberwood_stairs")
            );

            tag(BlockTags.NON_FLAMMABLE_WOOD).add(
                    BLOCKS.get("rubberwood_door"),
                    BLOCKS.get("rubberwood_fence"),
                    BLOCKS.get("rubberwood_fence_gate"),
                    BLOCKS.get(ID_RUBBERWOOD_LOG),
                    BLOCKS.get("rubberwood_planks"),
                    BLOCKS.get("rubberwood_slab"),
                    BLOCKS.get("rubberwood_stairs"),
                    BLOCKS.get(ID_RUBBERWOOD_WOOD),
                    BLOCKS.get(ID_STRIPPED_RUBBERWOOD_LOG),
                    BLOCKS.get(ID_STRIPPED_RUBBERWOOD_WOOD)
            );

            tag(CoFHTags.Blocks.LOGS_RUBBERWOOD).add(
                    BLOCKS.get(ID_RUBBERWOOD_LOG),
                    BLOCKS.get(ID_RUBBERWOOD_WOOD),
                    BLOCKS.get(ID_STRIPPED_RUBBERWOOD_LOG),
                    BLOCKS.get(ID_STRIPPED_RUBBERWOOD_WOOD)
            );
        }

    }

    public static class Item extends ItemTagsProvider {

        public Item(DataGenerator gen, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {

            super(gen, blockTagProvider, ID_THERMAL, existingFileHelper);
        }

        @Override
        public String getName() {

            return "Thermal Horizons: Item Tags";
        }

        @Override
        protected void addTags() {

            copy(CoFHTags.Blocks.LOGS_RUBBERWOOD, CoFHTags.Items.LOGS_RUBBERWOOD);
        }

    }

    public static class Fluid extends FluidTagsProvider {

        public Fluid(DataGenerator gen, ExistingFileHelper existingFileHelper) {

            super(gen, ID_THERMAL, existingFileHelper);
        }

        @Override
        public String getName() {

            return "Thermal Horizons: Fluid Tags";
        }

        @Override
        protected void addTags() {

        }

    }

}
