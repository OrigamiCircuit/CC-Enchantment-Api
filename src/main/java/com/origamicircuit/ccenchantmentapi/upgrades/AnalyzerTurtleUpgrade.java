package com.origamicircuit.ccenchantmentapi.upgrades;

import com.origamicircuit.ccenchantmentapi.peripherals.AnalyzerTurtlePeripheral;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.turtle.AbstractTurtleUpgrade;
import dan200.computercraft.api.turtle.ITurtleAccess;
import dan200.computercraft.api.turtle.TurtleSide;
import dan200.computercraft.api.turtle.TurtleUpgradeType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class AnalyzerTurtleUpgrade extends AbstractTurtleUpgrade {

    public AnalyzerTurtleUpgrade(ResourceLocation id, ItemStack stack) {
        super(id, TurtleUpgradeType.PERIPHERAL, stack);
    }

    @Override
    public IPeripheral createPeripheral(ITurtleAccess turtle, TurtleSide side) {
        return new AnalyzerTurtlePeripheral(turtle);
    }
}