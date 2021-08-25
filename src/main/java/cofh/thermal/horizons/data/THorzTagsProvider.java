package cofh.thermal.horizons.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;

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
        protected void registerTags() {

            getOrCreateBuilder(BlockTags.LEAVES).add(
                    BLOCKS.get("elastica_leaves")
            );
            getOrCreateBuilder(BlockTags.LOGS).add(
                    BLOCKS.get("elastica_log")
            );
            getOrCreateBuilder(BlockTags.SAPLINGS).add(
                    BLOCKS.get("elastica_sapling")
            );

            getOrCreateBuilder(BlockTags.DOORS).add(
                    BLOCKS.get("elastica_door")
            );
            getOrCreateBuilder(BlockTags.FENCES).add(
                    BLOCKS.get("elastica_fence")
            );
            getOrCreateBuilder(BlockTags.FENCE_GATES).add(
                    BLOCKS.get("elastica_fence_gate")
            );
            getOrCreateBuilder(BlockTags.PLANKS).add(
                    BLOCKS.get("elastica_planks")
            );
            getOrCreateBuilder(BlockTags.SLABS).add(
                    BLOCKS.get("elastica_slab")
            );
            getOrCreateBuilder(BlockTags.STAIRS).add(
                    BLOCKS.get("elastica_stairs")
            );

            getOrCreateBuilder(BlockTags.WOODEN_DOORS).add(
                    BLOCKS.get("elastica_door")
            );
            getOrCreateBuilder(BlockTags.WOODEN_FENCES).add(
                    BLOCKS.get("elastica_fence")
            );
            getOrCreateBuilder(BlockTags.WOODEN_SLABS).add(
                    BLOCKS.get("elastica_slab")
            );
            getOrCreateBuilder(BlockTags.WOODEN_STAIRS).add(
                    BLOCKS.get("elastica_stairs")
            );

            getOrCreateBuilder(BlockTags.NON_FLAMMABLE_WOOD).add(
                    BLOCKS.get("elastica_door"),
                    BLOCKS.get("elastica_fence"),
                    BLOCKS.get("elastica_fence_gate"),
                    BLOCKS.get("elastica_log"),
                    BLOCKS.get("elastica_planks"),
                    BLOCKS.get("elastica_slab"),
                    BLOCKS.get("elastica_stairs"),
                    BLOCKS.get("elastica_wood"),
                    BLOCKS.get("stripped_elastica_log"),
                    BLOCKS.get("stripped_elastica_wood")
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
        protected void registerTags() {

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
        protected void registerTags() {

        }

    }

}
