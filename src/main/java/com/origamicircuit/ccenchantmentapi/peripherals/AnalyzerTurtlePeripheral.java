package com.origamicircuit.ccenchantmentapi.peripherals;

import com.origamicircuit.ccenchantmentapi.api.EnchantmentAPI;

import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.turtle.ITurtleAccess;
import net.minecraft.world.item.ItemStack;
import java.util.List;

public class AnalyzerTurtlePeripheral implements IPeripheral {

    private final ITurtleAccess turtle;

    public AnalyzerTurtlePeripheral(ITurtleAccess turtle) {
        this.turtle = turtle;
    }

    @Override
    public String getType() {
        return "analyzer";
    }

    @Override
    public boolean equals(IPeripheral other) {
        return this == other;
    }

    private ItemStack getSelectedItem() {
        return turtle.getInventory().getItem(turtle.getSelectedSlot());
    }

    @LuaFunction(mainThread = true)
    public Object[] getGrindstoneXP() {
        return EnchantmentAPI.getGrindstoneXP(getSelectedItem());
    }

    @LuaFunction(mainThread = true)
    public int getEnchantability() {
        return EnchantmentAPI.getEnchantability(getSelectedItem());
    }

    @LuaFunction(mainThread = true)
    public int getRepairCount() {
        return EnchantmentAPI.getRepairCount(getSelectedItem());
    }

    @LuaFunction(mainThread = true)
    public boolean canEnchant(String enchantmentId) {
        return EnchantmentAPI.canEnchant(enchantmentId, getSelectedItem());
    }

    @LuaFunction(mainThread = true)
    public boolean canApplyAtEnchantingTable(String enchantmentId) {
        return EnchantmentAPI.canApplyAtEnchantingTable(enchantmentId, getSelectedItem());
    }

    @LuaFunction(mainThread = true)
    public List<String> listEnchantmentsForItemAtEnchantingTable() {
        return EnchantmentAPI.listEnchantmentsForItemAtEnchantingTable(getSelectedItem());
    }

    @LuaFunction(mainThread = true)
    public List<String> listEnchantmentsForItem() {
        return EnchantmentAPI.listEnchantmentsForItem(getSelectedItem());
    }
}