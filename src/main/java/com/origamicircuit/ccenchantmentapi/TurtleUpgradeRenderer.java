package com.origamicircuit.ccenchantmentapi;

import com.origamicircuit.ccenchantmentapi.registries.ModTurtleUpgrades;

import dan200.computercraft.api.client.turtle.RegisterTurtleModellersEvent;
import dan200.computercraft.api.client.turtle.TurtleUpgradeModeller;

import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CCEnchantmentAPI.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TurtleUpgradeRenderer {

    @SuppressWarnings("removal")
    @SubscribeEvent
    public static void register(RegisterTurtleModellersEvent event) {
        event.register(
                ModTurtleUpgrades.ANALYZER,
                TurtleUpgradeModeller.sided(
                        new ResourceLocation(CCEnchantmentAPI.MOD_ID, "block/analyzer_turtle_left"),
                        new ResourceLocation(CCEnchantmentAPI.MOD_ID, "block/analyzer_turtle_right")));
    }
}