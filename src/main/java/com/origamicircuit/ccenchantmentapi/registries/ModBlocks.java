package com.origamicircuit.ccenchantmentapi.registries;

import com.origamicircuit.ccenchantmentapi.CCEnchantmentAPI;
import com.origamicircuit.ccenchantmentapi.blocks.AnalyzerBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            CCEnchantmentAPI.MOD_ID);

    public static final RegistryObject<Block> ANALYZER = BLOCKS.register("analyzer",
            () -> new AnalyzerBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(3.5F)
                    .requiresCorrectToolForDrops()));

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
