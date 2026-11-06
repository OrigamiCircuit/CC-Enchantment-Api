package com.origamicircuit.ccenchantmentapi;

import com.origamicircuit.ccenchantmentapi.api.ComputerAPI;
import com.origamicircuit.ccenchantmentapi.peripherals.AnalyzerBlockPeripheral;
import com.origamicircuit.ccenchantmentapi.registries.ModBlockEntities;
import com.origamicircuit.ccenchantmentapi.registries.ModBlocks;
import com.origamicircuit.ccenchantmentapi.registries.ModItems;
import com.origamicircuit.ccenchantmentapi.registries.ModTurtleUpgrades;

import dan200.computercraft.api.ComputerCraftAPI;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CCEnchantmentAPI.MOD_ID)
public class CCEnchantmentAPI {

    public static final String MOD_ID = "cc_enchantment_api";
    @SuppressWarnings("removal")
    private static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

    public CCEnchantmentAPI() {
        ModItems.register(MOD_EVENT_BUS);
        ModBlocks.register(MOD_EVENT_BUS);
        ModBlockEntities.register(MOD_EVENT_BUS);
        MOD_EVENT_BUS.addListener(ModTurtleUpgrades::register);
        ComputerCraftAPI.registerGenericSource(new AnalyzerBlockPeripheral());
        ComputerAPI.register();
    }
}
