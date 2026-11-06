package com.origamicircuit.ccenchantmentapi.registries;

import com.origamicircuit.ccenchantmentapi.CCEnchantmentAPI;
import com.origamicircuit.ccenchantmentapi.upgrades.AnalyzerTurtleUpgrade;

import dan200.computercraft.api.turtle.TurtleUpgradeSerialiser;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegisterEvent;

public class ModTurtleUpgrades {

    public static final TurtleUpgradeSerialiser<AnalyzerTurtleUpgrade> ANALYZER = TurtleUpgradeSerialiser
            .simpleWithCustomItem(AnalyzerTurtleUpgrade::new);

    @SuppressWarnings("removal")
    public static void register(RegisterEvent event) {
        event.register(
                TurtleUpgradeSerialiser.registryId(),
                new ResourceLocation(CCEnchantmentAPI.MOD_ID, "analyzer"),
                () -> ANALYZER);
    }
}