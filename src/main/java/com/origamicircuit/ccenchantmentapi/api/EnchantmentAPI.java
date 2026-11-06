package com.origamicircuit.ccenchantmentapi.api;

import java.util.ArrayList;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.List;
import java.util.Map;

import dan200.computercraft.api.lua.LuaException;

public final class EnchantmentAPI {
    private EnchantmentAPI() {
    }

    public static boolean isRegistered(String id) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        return location != null && ForgeRegistries.ENCHANTMENTS.containsKey(location);
    }

    public static List<String> listEnchantments() {
        List<String> enchantments = new ArrayList<>();

        for (ResourceLocation id : ForgeRegistries.ENCHANTMENTS.getKeys()) {
            enchantments.add(id.toString());
        }

        return enchantments;
    }

    public static String getEnchantmentNameKey(String id) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;

        return enchantment.getDescriptionId();
    }

    public static String getEnchantmentName(String id) {
        String key = getEnchantmentNameKey(id);

        if (key == null)
            return null;

        return Component.translatable(key).getString();
    }

    public static String getEnchantmentDescriptionKey(String id) throws LuaException {
        if (!ModList.get().isLoaded("enchdesc")) {
            throw new LuaException("Enchantment Descriptions is not installed.");
        }

        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;

        return "enchantment." + location.getNamespace()
                + "." + location.getPath() + ".desc";
    }

    public static String getEnchantmentDescription(
            String id) throws LuaException {
        String key = getEnchantmentDescriptionKey(id);

        if (key == null)
            return null;

        return Component.translatable(key).getString();
    }

    public static Integer getMinLevel(String id) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;

        return enchantment.getMinLevel();
    }

    public static Integer getMaxLevel(String id) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;

        return enchantment.getMaxLevel();
    }

    public static String getRarity(String id) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;

        return enchantment.getRarity().name();
    }

    public static Boolean isTreasure(String id) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;

        return enchantment.isTreasureOnly();
    }

    public static Boolean isCurse(String id) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;

        return enchantment.isCurse();
    }

    public static Boolean isDiscoverable(String id) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;

        return enchantment.isDiscoverable();
    }

    public static Boolean isTradable(String id) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;

        return enchantment.isTradeable();
    }

    public static Boolean isBookable(String id) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;

        return enchantment.isAllowedOnBooks();
    }

    public static String getCategory(String id) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;

        return enchantment.category.name();
    }

    public static List<String> listCategories() {
        List<String> categories = new ArrayList<>();

        for (EnchantmentCategory category : EnchantmentCategory.values()) {
            categories.add(category.name());
        }

        return categories;
    }

    public static List<String> listEnchantmentsByCategory(String category) {
        List<String> enchantments = new ArrayList<>();

        EnchantmentCategory enchantmentCategory;

        try {
            enchantmentCategory = EnchantmentCategory.valueOf(category);
        } catch (IllegalArgumentException exception) {
            return enchantments;
        }

        for (Map.Entry<ResourceKey<Enchantment>, Enchantment> entry : ForgeRegistries.ENCHANTMENTS.getEntries()) {

            if (entry.getValue().category == enchantmentCategory) {
                enchantments.add(entry.getKey().location().toString());
            }
        }

        return enchantments;
    }

    public static Boolean canCombine(String idA, String idB) {
        ResourceLocation locationA = ResourceLocation.tryParse(idA);
        Enchantment enchantmentA = ForgeRegistries.ENCHANTMENTS.getValue(locationA);

        if (enchantmentA == null)
            return null;

        ResourceLocation locationB = ResourceLocation.tryParse(idB);
        Enchantment enchantmentB = ForgeRegistries.ENCHANTMENTS.getValue(locationB);

        if (enchantmentB == null)
            return null;

        return enchantmentA.isCompatibleWith(enchantmentB);
    }

    public static Object[] getPowerRange(String id, int level) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;

        return new Object[] {
                enchantment.getMinCost(level),
                enchantment.getMaxCost(level)
        };
    }

    public static Object[] getGrindstoneXP(String id, int level) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return null;
        if (enchantment.isCurse())
            return new Object[] { 0, 0 };

        int maximum = enchantment.getMinCost(level);
        int minimum = maximum / 2;

        return new Object[] { minimum, maximum };
    }

    public static Object[] getGrindstoneXP(ItemStack item) {
        int maximum = 0;

        for (Map.Entry<Enchantment, Integer> entry : EnchantmentHelper.getEnchantments(item).entrySet()) {

            Enchantment enchantment = entry.getKey();

            if (enchantment.isCurse())
                continue;

            maximum += enchantment.getMinCost(entry.getValue());
        }

        int minimum = (maximum + 1) / 2;

        return new Object[] { minimum, maximum };
    }

    public static int getEnchantability(ItemStack item) {
        return item.getEnchantmentValue();
    }

    public static int getRepairCount(ItemStack item) {
        return item.getTag() == null ? 0 : item.getTag().getInt("RepairCost");
    }

    public static boolean canEnchant(String id, ItemStack item) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return false;

        return enchantment.canEnchant(item);
    }

    public static boolean canApplyAtEnchantingTable(String id, ItemStack item) {
        ResourceLocation location = ResourceLocation.tryParse(id);
        Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(location);

        if (enchantment == null)
            return false;

        return enchantment.canApplyAtEnchantingTable(item);
    }

    public static List<String> listEnchantmentsForItemAtEnchantingTable(ItemStack item) {
        List<String> enchantments = new ArrayList<>();

        for (Map.Entry<ResourceKey<Enchantment>, Enchantment> entry : ForgeRegistries.ENCHANTMENTS.getEntries()) {

            Enchantment enchantment = entry.getValue();

            if (enchantment.canApplyAtEnchantingTable(item)) {
                enchantments.add(entry.getKey().location().toString());
            }
        }

        return enchantments;
    }

    public static List<String> listEnchantmentsForItem(ItemStack item) {
        List<String> enchantments = new ArrayList<>();

        for (Map.Entry<ResourceKey<Enchantment>, Enchantment> entry : ForgeRegistries.ENCHANTMENTS.getEntries()) {

            Enchantment enchantment = entry.getValue();

            if (enchantment.canEnchant(item)) {
                enchantments.add(entry.getKey().location().toString());
            }
        }

        return enchantments;
    }
}
