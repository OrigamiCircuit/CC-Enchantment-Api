
package com.origamicircuit.ccenchantmentapi.peripherals;

import com.origamicircuit.ccenchantmentapi.CCEnchantmentAPI;
import com.origamicircuit.ccenchantmentapi.api.EnchantmentAPI;
import com.origamicircuit.ccenchantmentapi.blockentities.AnalyzerBlockEntity;

import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.GenericPeripheral;
import java.util.List;

public class AnalyzerBlockPeripheral implements GenericPeripheral {
    private AnalyzerBlockPeripheral() {
    }

    public static void register() {
        ComputerCraftAPI.registerGenericSource(new AnalyzerBlockPeripheral());
    }

    @Override
    public String id() {
        return CCEnchantmentAPI.MOD_ID + ":analyzer";
    }

    @LuaFunction(mainThread = true)
    public Object[] getGrindstoneXP(AnalyzerBlockEntity analyzer) {
        return EnchantmentAPI.getGrindstoneXP(analyzer.getItem());
    }

    @LuaFunction(mainThread = true)
    public int getEnchantability(AnalyzerBlockEntity analyzer) {
        return EnchantmentAPI.getEnchantability(analyzer.getItem());
    }

    @LuaFunction(mainThread = true)
    public int getRepairCount(AnalyzerBlockEntity analyzer) {
        return EnchantmentAPI.getRepairCount(analyzer.getItem());
    }

    @LuaFunction(mainThread = true)
    public boolean canEnchant(AnalyzerBlockEntity analyzer, String enchantmentId) {
        return EnchantmentAPI.canEnchant(enchantmentId, analyzer.getItem());
    }

    @LuaFunction(mainThread = true)
    public boolean canApplyAtEnchantingTable(AnalyzerBlockEntity analyzer, String enchantmentId) {
        return EnchantmentAPI.canApplyAtEnchantingTable(enchantmentId, analyzer.getItem());
    }

    @LuaFunction(mainThread = true)
    public List<String> listEnchantmentsForItemAtEnchantingTable(AnalyzerBlockEntity analyzer) {
        return EnchantmentAPI.listEnchantmentsForItemAtEnchantingTable(analyzer.getItem());
    }

    @LuaFunction(mainThread = true)
    public List<String> listEnchantmentsForItem(AnalyzerBlockEntity analyzer) {
        return EnchantmentAPI.listEnchantmentsForItem(analyzer.getItem());
    }

}
