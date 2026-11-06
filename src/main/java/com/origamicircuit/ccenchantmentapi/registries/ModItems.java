
package com.origamicircuit.ccenchantmentapi.registries;

import com.origamicircuit.ccenchantmentapi.CCEnchantmentAPI;
import com.origamicircuit.ccenchantmentapi.items.AnalyzerBlockItem;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
                        ForgeRegistries.ITEMS,
                        CCEnchantmentAPI.MOD_ID);

        public static final RegistryObject<Item> ANALYZER = ITEMS.register("analyzer", () -> new AnalyzerBlockItem(
                        ModBlocks.ANALYZER.get(),
                        new Item.Properties()));

        public static void register(IEventBus modEventBus) {
                ITEMS.register(modEventBus);
                modEventBus.addListener(ModItems::addToCreativeTab);
        }

        @SuppressWarnings("removal")
        public static void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
                if (event.getTabKey().location().equals(
                                new ResourceLocation("computercraft", "tab"))) {
                }
        }
}
