/*
 * MIT License
 *
 * Copyright (c) 2020 Ridanisaurus
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software").toString(), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.ridanisaurus.emendatusenigmatica.datagen;

import com.ridanisaurus.emendatusenigmatica.registries.FluidHandler;
import com.ridanisaurus.emendatusenigmatica.registries.ItemHandler;
import com.ridanisaurus.emendatusenigmatica.util.Materials;
import com.ridanisaurus.emendatusenigmatica.util.ProcessedMaterials;
import com.ridanisaurus.emendatusenigmatica.util.Reference;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Arrays;
import java.util.List;

import net.minecraft.data.TagsProvider.Builder;

public class ItemTagsGen extends ItemTagsProvider {

  public ItemTagsGen(DataGenerator gen, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
    super(gen, blockTagProvider, Reference.MOD_ID, existingFileHelper);
  }

  @Override
  protected void addTags() {
    // Forge Tags
    Builder<Item> forgeBlocks = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "storage_blocks").toString()));
    Builder<Item> forgeIngots = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "ingots").toString()));
    Builder<Item> forgeGems = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "gems").toString()));
    Builder<Item> forgeNuggets = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "nuggets").toString()));
    Builder<Item> forgeDusts = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "dusts").toString()));
    Builder<Item> forgePlates = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "plates").toString()));
    Builder<Item> forgeGears = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "gears").toString()));
    Builder<Item> forgeRods = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "rods").toString()));
    Builder<Item> forgeChunks = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "chunks").toString()));
    Builder<Item> forgeClusters = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "clusters").toString()));
    Builder<Item> forgeOres = tag(ItemTags.createOptional(new ResourceLocation(Reference.FORGE_TAG, "ores")));
    Builder<Item> forgeBuckets = tag(ItemTags.createOptional(new ResourceLocation(Reference.FORGE_TAG, "buckets")));

    Builder<Item> mekaClumps = tag(ItemTags.bind(new ResourceLocation(Reference.MEKANISM, "clumps").toString()));
    Builder<Item> mekaCrystals = tag(ItemTags.bind(new ResourceLocation(Reference.MEKANISM, "crystals").toString()));
    Builder<Item> mekaDirtyDusts = tag(ItemTags.bind(new ResourceLocation(Reference.MEKANISM, "dirty_dusts").toString()));
    Builder<Item> mekaShards = tag(ItemTags.bind(new ResourceLocation(Reference.MEKANISM, "shards").toString()));

    Builder<Item> createCrushed = tag(ItemTags.bind(new ResourceLocation(Reference.CREATE, "crushed_ores").toString()));

    Builder<Item> bloodMagicFragment = tag(ItemTags.bind(new ResourceLocation(Reference.BLOOD_MAGIC, "fragments").toString()));
    Builder<Item> bloodMagicGravel = tag(ItemTags.bind(new ResourceLocation(Reference.BLOOD_MAGIC, "gravels").toString()));

    Builder<Item> beaconIngots = tag(ItemTags.bind(new ResourceLocation(Reference.MINECRAFT_TAG, "beacon_payment_items").toString()));

    // Storage Block Items
    ItemHandler.backingItemTable.row(ProcessedMaterials.STORAGE_BLOCK).forEach((mat, storageBlock) -> {
      forgeBlocks.add(storageBlock.get());
      Builder<Item> blockTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "storage_blocks/" + mat.id).toString()));
      blockTag.add(storageBlock.get());
    });

    // Ingots
    ItemHandler.backingItemTable.row(ProcessedMaterials.INGOT).forEach((mat, ingot) -> {
      forgeIngots.add(ingot.get());
      beaconIngots.add(ingot.get());
      Builder<Item> ingotTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "ingots/" + mat.id).toString()));
      ingotTag.add(ingot.get());
    });

    // Gems
    ItemHandler.backingItemTable.row(ProcessedMaterials.GEM).forEach((mat, gem) -> {
      if (!mat.id.equals("arcane")) {
        forgeGems.add(gem.get());
        Builder<Item> gemTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "gems/" + mat.id).toString()));
        gemTag.add(gem.get());
      }
    });

    // Nuggets
    ItemHandler.backingItemTable.row(ProcessedMaterials.NUGGET).forEach((mat, nugget) -> {
      forgeNuggets.add(nugget.get());
      Builder<Item> nuggetTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "nuggets/" + mat.id).toString()));
      nuggetTag.add(nugget.get());
    });

    // Dusts
    ItemHandler.backingItemTable.row(ProcessedMaterials.DUST).forEach((mat, dust) -> {
      forgeDusts.add(dust.get());
      Builder<Item> dustTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "dusts/" + mat.id).toString()));
      dustTag.add(dust.get());
    });

    // Plates
    ItemHandler.backingItemTable.row(ProcessedMaterials.PLATE).forEach((mat, plate) -> {
      forgePlates.add(plate.get());
      Builder<Item> plateTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "plates/" + mat.id).toString()));
      plateTag.add(plate.get());
    });

    // Gears
    ItemHandler.backingItemTable.row(ProcessedMaterials.GEAR).forEach((mat, gear) -> {
      forgeGears.add(gear.get());
      Builder<Item> gearTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "gears/" + mat.id).toString()));
      gearTag.add(gear.get());
    });

    // Rods
    ItemHandler.backingItemTable.row(ProcessedMaterials.ROD).forEach((mat, rod) -> {
      forgeRods.add(rod.get());
      Builder<Item> rodTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "rods/" + mat.id).toString()));
      Builder<Item> allMetalTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "rods/all_metal").toString()));
      rodTag.add(rod.get());
      allMetalTag.add(rod.get());
    });

    // Chunks
    ItemHandler.backingItemTable.row(ProcessedMaterials.CHUNK).forEach((mat, chunk) -> {
      forgeChunks.add(chunk.get());
      Builder<Item> chunkTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "chunks/" + mat.id).toString()));
      chunkTag.add(chunk.get());
    });

    // Clusters
    ItemHandler.backingItemTable.row(ProcessedMaterials.CLUSTER).forEach((mat, cluster) -> {
      forgeClusters.add(cluster.get());
      Builder<Item> clusterTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "clusters/" + mat.id).toString()));
      Builder<Item> oreClusterTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "ores_cluster/" + mat.id).toString()));
      clusterTag.add(cluster.get());
      oreClusterTag.add(cluster.get());
    });

    // Clumps
    ItemHandler.backingItemTable.row(ProcessedMaterials.CLUMP).forEach((mat, clump) -> {
      mekaClumps.add(clump.get());
      Builder<Item> clumpTag = tag(ItemTags.bind(new ResourceLocation(Reference.MEKANISM, "clumps/" + mat.id).toString()));
      clumpTag.add(clump.get());
    });

    // Crystals
    ItemHandler.backingItemTable.row(ProcessedMaterials.CRYSTAL).forEach((mat, crystal) -> {
      mekaCrystals.add(crystal.get());
      Builder<Item> crystalTag = tag(ItemTags.bind(new ResourceLocation(Reference.MEKANISM, "crystals/" + mat.id).toString()));
      crystalTag.add(crystal.get());
    });

    // Dirty Dusts
    ItemHandler.backingItemTable.row(ProcessedMaterials.DIRTY_DUST).forEach((mat, dirty_dust) -> {
      mekaDirtyDusts.add(dirty_dust.get());
      Builder<Item> dirtyDustTag = tag(ItemTags.bind(new ResourceLocation(Reference.MEKANISM, "dirty_dusts/" + mat.id).toString()));
      dirtyDustTag.add(dirty_dust.get());
    });

    // Shards
    ItemHandler.backingItemTable.row(ProcessedMaterials.SHARD).forEach((mat, shard) -> {
      mekaShards.add(shard.get());
      Builder<Item> shardTag = tag(ItemTags.bind(new ResourceLocation(Reference.MEKANISM, "shards/" + mat.id).toString()));
      shardTag.add(shard.get());
    });

    // Crushed
    ItemHandler.backingItemTable.row(ProcessedMaterials.CRUSHED).forEach((mat, crushed) -> {
      createCrushed.add(crushed.get());
      Builder<Item> crushedTag = tag(ItemTags.bind(new ResourceLocation(Reference.CREATE, "crushed_ores/" + mat.id).toString()));
      crushedTag.add(crushed.get());
    });

    // Fragment
    ItemHandler.backingItemTable.row(ProcessedMaterials.FRAGMENT).forEach((mat, fragment) -> {
      bloodMagicFragment.add(fragment.get());
      Builder<Item> fragmentTag = tag(ItemTags.bind(new ResourceLocation(Reference.BLOOD_MAGIC, "fragments/" + mat.id).toString()));
      fragmentTag.add(fragment.get());
    });

    // Gravel
    ItemHandler.backingItemTable.row(ProcessedMaterials.GRAVEL).forEach((mat, gravel) -> {
      bloodMagicGravel.add(gravel.get());
      Builder<Item> gravelTag = tag(ItemTags.bind(new ResourceLocation(Reference.BLOOD_MAGIC, "gravels/" + mat.id).toString()));
      gravelTag.add(gravel.get());
    });

    // Fluid Buckets
    FluidHandler.fluidBucketByMaterial.forEach((mat, fluid) -> {
      forgeBuckets.add(fluid.get());
      Builder<Item> bucketTag = tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "buckets/" + mat).toString()));
      bucketTag.add(fluid.get());
    });

    // Ore Items

    ItemHandler.backingOreItemTable.values().forEach(s -> forgeOres.add(s.get()));
    for (Materials material : Materials.values()) {
      List<String> toCreate = Arrays.asList(material.type);
      if (material.oreBlock != null && toCreate.contains("Ore")) {
        Builder<Item> oreTag = tag(ItemTags.createOptional(new ResourceLocation(Reference.FORGE_TAG, "ores/" + material.id)));
        ItemHandler.backingOreItemTable.column(material).values().forEach(s -> oreTag.add(s.get()));
        forgeOres.add(ItemHandler.backingItemTable.get(ProcessedMaterials.CHUNK, material).get());
        oreTag.add(ItemHandler.backingItemTable.get(ProcessedMaterials.CHUNK, material).get());
      }
      if (material.oreBlock != null && toCreate.contains("Ore") && material.id.equals("arcane")) {
        Builder<Item> oreTag = tag(ItemTags.createOptional(new ResourceLocation(Reference.FORGE_TAG, "ores/mana")));
        ItemHandler.backingOreItemTable.column(material).values().forEach(s -> oreTag.add(s.get()));
        oreTag.add(ItemHandler.backingItemTable.get(ProcessedMaterials.CHUNK, material).get());
      }
    }

    // Piglin Loved
    tag(ItemTags.bind(new ResourceLocation(Reference.MINECRAFT_TAG, "piglin_loved").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.CHUNK, Materials.GOLD).get())
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.DUST, Materials.GOLD).get())
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.PLATE, Materials.GOLD).get())
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEAR, Materials.GOLD).get())
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.ROD, Materials.GOLD).get());

    // Silicon
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "silicon").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.SILICON).get());

    // Bitumen
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "bitumen").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.BITUMEN).get());

    // Coke
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "coal_coke").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.COKE).get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "gems/coal_coke").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.COKE).get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "dusts/coal_coke").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.DUST, Materials.COKE).get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "storage_blocks/coal_coke").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.STORAGE_BLOCK, Materials.COKE).get());

    // Dusts
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "dusts").toString()))
            .add(ItemHandler.DUST_CHARCOAL.get())
            .add(ItemHandler.DUST_OBSIDIAN.get())
            .add(ItemHandler.DUST_ENDER.get())
            .add(ItemHandler.DUST_GRAPHITE.get())
            .add(ItemHandler.DUST_LITHIUM.get())
            .add(ItemHandler.DUST_WOOD.get());

    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "dusts/charcoal").toString()))
            .add(ItemHandler.DUST_CHARCOAL.get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "dusts/obsidian").toString()))
            .add(ItemHandler.DUST_OBSIDIAN.get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "dusts/ender").toString()))
            .add(ItemHandler.DUST_ENDER.get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "dusts/graphite").toString()))
            .add(ItemHandler.DUST_GRAPHITE.get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "dusts/lithium").toString()))
            .add(ItemHandler.DUST_LITHIUM.get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "dusts/wood").toString()))
            .add(ItemHandler.DUST_WOOD.get());

    // Mana
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "gems/mana").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.ARCANE).get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "gems").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.ARCANE).get());

    // Potassium Nitrate Compact
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "dusts/niter").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.DUST, Materials.POTASSIUM_NITRATE).get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "gems/niter").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.POTASSIUM_NITRATE).get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "storage_blocks/niter").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.STORAGE_BLOCK, Materials.POTASSIUM_NITRATE).get());

    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "dusts/saltpeter").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.DUST, Materials.POTASSIUM_NITRATE).get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "gems/saltpeter").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.POTASSIUM_NITRATE).get());
    tag(ItemTags.bind(new ResourceLocation(Reference.FORGE_TAG, "storage_blocks/saltpeter").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.STORAGE_BLOCK, Materials.POTASSIUM_NITRATE).get());


    // AE2 Additional Tags
    tag(ItemTags.bind(new ResourceLocation(Reference.AE2_TAG, "dusts/quartz").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.DUST, Materials.CERTUS_QUARTZ).get())
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.DUST, Materials.QUARTZ).get());

    tag(ItemTags.bind(new ResourceLocation(Reference.AE2_TAG, "dusts/certus_quartz").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.DUST, Materials.CERTUS_QUARTZ).get());

    tag(ItemTags.bind(new ResourceLocation(Reference.AE2_TAG, "dusts/nether_quartz").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.DUST, Materials.QUARTZ).get());

    tag(ItemTags.bind(new ResourceLocation(Reference.AE2_TAG, "dusts/fluix").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.DUST, Materials.FLUIX).get());

    tag(ItemTags.bind(new ResourceLocation(Reference.AE2_TAG, "crystals/certus_quartz").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.CERTUS_QUARTZ).get());

    tag(ItemTags.bind(new ResourceLocation(Reference.AE2_TAG, "crystals/charged_certus_quartz").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.CHARGED_CERTUS_QUARTZ).get());

    tag(ItemTags.bind(new ResourceLocation(Reference.AE2_TAG, "crystals/quartz").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.CERTUS_QUARTZ).get())
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.CHARGED_CERTUS_QUARTZ).get());

    tag(ItemTags.bind(new ResourceLocation(Reference.AE2_TAG, "crystals/certus").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.CERTUS_QUARTZ).get())
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.CHARGED_CERTUS_QUARTZ).get());

    tag(ItemTags.bind(new ResourceLocation(Reference.AE2_TAG, "crystals/fluix").toString()))
            .add(ItemHandler.backingItemTable.get(ProcessedMaterials.GEM, Materials.FLUIX).get());
  }
}