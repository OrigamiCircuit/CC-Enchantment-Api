package com.origamicircuit.ccenchantmentapi.api;

import java.util.List;

import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.lua.IComputerSystem;
import dan200.computercraft.api.lua.ILuaAPI;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.LuaFunction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class ComputerAPI implements ILuaAPI {

    private ComputerAPI(IComputerSystem computer) {
    }

    public static void register() {
        ComputerCraftAPI.registerAPIFactory(ComputerAPI::new);
    }

    @Override
    public String[] getNames() {
        return new String[] { "enchantments" };
    }

    @SuppressWarnings({ "deprecation", "removal" })
    private ItemStack createItemStack(String itemId) {
        ResourceLocation location = new ResourceLocation(itemId);
        Item item = BuiltInRegistries.ITEM.get(location);

        if (item == null)
            return ItemStack.EMPTY;

        return new ItemStack(item, 1);
    }

    @LuaFunction
    public boolean isRegistered(String id) {
        return EnchantmentAPI.isRegistered(id);
    }

    @LuaFunction
    public List<String> listEnchantments() {
        return EnchantmentAPI.listEnchantments();
    }

    @LuaFunction
    public String getEnchantmentNameKey(String id) {
        return EnchantmentAPI.getEnchantmentNameKey(id);
    }

    @LuaFunction
    public String getEnchantmentName(String id) {
        return EnchantmentAPI.getEnchantmentName(id);
    }

    @LuaFunction
    public String getEnchantmentDescriptionKey(String id) throws LuaException {
        return EnchantmentAPI.getEnchantmentDescriptionKey(id);
    }

    @LuaFunction
    public String getEnchantmentDescription(String id) throws LuaException {
        return EnchantmentAPI.getEnchantmentDescription(id);
    }

    @LuaFunction
    public int getMinLevel(String id) {
        return EnchantmentAPI.getMinLevel(id);
    }

    @LuaFunction
    public int getMaxLevel(String id) {
        return EnchantmentAPI.getMaxLevel(id);
    }

    @LuaFunction
    public String getRarity(String id) {
        return EnchantmentAPI.getRarity(id);
    }

    @LuaFunction
    public boolean isTreasure(String id) {
        return EnchantmentAPI.isTreasure(id);
    }

    @LuaFunction
    public boolean isCurse(String id) {
        return EnchantmentAPI.isCurse(id);
    }

    @LuaFunction
    public boolean isDiscoverable(String id) {
        return EnchantmentAPI.isDiscoverable(id);
    }

    @LuaFunction
    public boolean isTradeable(String id) {
        return EnchantmentAPI.isTradable(id);
    }

    @LuaFunction
    public boolean isBookable(String id) {
        return EnchantmentAPI.isBookable(id);
    }

    @LuaFunction
    public String getCategory(String id) {
        return EnchantmentAPI.getCategory(id);
    }

    @LuaFunction
    public List<String> listCategories() {
        return EnchantmentAPI.listCategories();
    }

    @LuaFunction
    public List<String> listEnchantmentsByCategory(String category) {
        return EnchantmentAPI.listEnchantmentsByCategory(category);
    }

    @LuaFunction
    public boolean canCombine(String idA, String idB) {
        return EnchantmentAPI.canCombine(idA, idB);
    }

    @LuaFunction
    public Object[] getPowerRange(String id, int level) {
        return EnchantmentAPI.getPowerRange(id, level);
    }

    @LuaFunction
    public Object[] getGrindstoneXP(String id, int level) {
        return EnchantmentAPI.getGrindstoneXP(id, level);
    }

    @LuaFunction
    public int getEnchantability(String itemId) {
        return EnchantmentAPI.getEnchantability(createItemStack(itemId));
    }

    @LuaFunction
    public boolean canEnchant(String enchantmentId, String itemId) {
        return EnchantmentAPI.canEnchant(enchantmentId, createItemStack(itemId));
    }

    @LuaFunction
    public boolean canApplyAtEnchantingTable(String enchantmentId, String itemId) {
        return EnchantmentAPI.canApplyAtEnchantingTable(enchantmentId, createItemStack(itemId));
    }

    @LuaFunction
    public List<String> listEnchantmentsForItemAtEnchantingTable(String itemId) {
        return EnchantmentAPI.listEnchantmentsForItemAtEnchantingTable(createItemStack(itemId));
    }

    @LuaFunction
    public List<String> listEnchantmentsForItem(String itemId) {
        return EnchantmentAPI.listEnchantmentsForItem(createItemStack(itemId));
    }
}
