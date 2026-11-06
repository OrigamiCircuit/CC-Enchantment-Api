
package com.origamicircuit.ccenchantmentapi.registries;

import com.origamicircuit.ccenchantmentapi.CCEnchantmentAPI;
import com.origamicircuit.ccenchantmentapi.blockentities.AnalyzerBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
            ForgeRegistries.BLOCK_ENTITY_TYPES,
            CCEnchantmentAPI.MOD_ID);

    public static final RegistryObject<BlockEntityType<AnalyzerBlockEntity>> ANALYZER = BLOCK_ENTITIES
            .register("analyzer", () -> BlockEntityType.Builder.of(
                    AnalyzerBlockEntity::new,
                    ModBlocks.ANALYZER.get()).build(null));

    public static void register(IEventBus modEventBus) {
        BLOCK_ENTITIES.register(modEventBus);
    }
}
