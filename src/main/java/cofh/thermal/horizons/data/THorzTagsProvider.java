package cofh.thermal.horizons.data;

import cofh.lib.util.references.BlockTagsCoFH;
import cofh.lib.util.references.ItemTagsCoFH;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.lib.common.ThermalIDs.*;

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
                    BLOCKS.get("elastica_leaves")
            );
            tag(BlockTags.LOGS).add(
                    BLOCKS.get(ID_ELASTICA_LOG)
            );
            tag(BlockTags.SAPLINGS).add(
                    BLOCKS.get("elastica_sapling")
            );

            tag(BlockTags.DOORS).add(
                    BLOCKS.get("elastica_door")
            );
            tag(BlockTags.FENCES).add(
                    BLOCKS.get("elastica_fence")
            );
            tag(BlockTags.FENCE_GATES).add(
                    BLOCKS.get("elastica_fence_gate")
            );
            tag(BlockTags.PLANKS).add(
                    BLOCKS.get("elastica_planks")
            );
            tag(BlockTags.SLABS).add(
                    BLOCKS.get("elastica_slab")
            );
            tag(BlockTags.STAIRS).add(
                    BLOCKS.get("elastica_stairs")
            );

            tag(BlockTags.WOODEN_DOORS).add(
                    BLOCKS.get("elastica_door")
            );
            tag(BlockTags.WOODEN_FENCES).add(
                    BLOCKS.get("elastica_fence")
            );
            tag(BlockTags.WOODEN_SLABS).add(
                    BLOCKS.get("elastica_slab")
            );
            tag(BlockTags.WOODEN_STAIRS).add(
                    BLOCKS.get("elastica_stairs")
            );

            tag(BlockTags.NON_FLAMMABLE_WOOD).add(
                    BLOCKS.get("elastica_door"),
                    BLOCKS.get("elastica_fence"),
                    BLOCKS.get("elastica_fence_gate"),
                    BLOCKS.get(ID_ELASTICA_LOG),
                    BLOCKS.get("elastica_planks"),
                    BLOCKS.get("elastica_slab"),
                    BLOCKS.get("elastica_stairs"),
                    BLOCKS.get(ID_ELASTICA_WOOD),
                    BLOCKS.get(ID_STRIPPED_ELASTICA_LOG),
                    BLOCKS.get(ID_STRIPPED_ELASTICA_WOOD)
            );

            tag(BlockTagsCoFH.LOGS_ELASTICA).add(
                    BLOCKS.get(ID_ELASTICA_LOG),
                    BLOCKS.get(ID_ELASTICA_WOOD),
                    BLOCKS.get(ID_STRIPPED_ELASTICA_LOG),
                    BLOCKS.get(ID_STRIPPED_ELASTICA_WOOD)
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

            copy(BlockTagsCoFH.LOGS_ELASTICA, ItemTagsCoFH.LOGS_ELASTICA);
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
