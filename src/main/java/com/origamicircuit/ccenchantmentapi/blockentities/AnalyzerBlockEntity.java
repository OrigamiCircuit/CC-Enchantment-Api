
package com.origamicircuit.ccenchantmentapi.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import org.jetbrains.annotations.Nullable;

import com.origamicircuit.ccenchantmentapi.registries.ModBlockEntities;

public class AnalyzerBlockEntity extends BlockEntity {

    private final ItemStackHandler inventory = new ItemStackHandler(1) {

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public int getSlotLimit(int slot) {
            return 1;
        }
    };

    private LazyOptional<IItemHandler> inventoryCapability = LazyOptional.empty();

    public AnalyzerBlockEntity(
            BlockPos position,
            BlockState state) {
        super(ModBlockEntities.ANALYZER.get(), position, state);
    }

    public ItemStack getItem() {
        return inventory.getStackInSlot(0);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        inventoryCapability = LazyOptional.of(() -> inventory);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        inventoryCapability.invalidate();
    }

    @Override
    public <T> LazyOptional<T> getCapability(
            Capability<T> capability,
            @Nullable Direction side) {
        if (capability == ForgeCapabilities.ITEM_HANDLER) {
            return inventoryCapability.cast();
        }

        return super.getCapability(capability, side);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Inventory", inventory.serializeNBT());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        inventory.deserializeNBT(tag.getCompound("Inventory"));
    }
}
