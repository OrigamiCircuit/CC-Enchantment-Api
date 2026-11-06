package com.origamicircuit.ccenchantmentapi.blocks;

import com.origamicircuit.ccenchantmentapi.blockentities.AnalyzerBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;

public class AnalyzerBlock extends Block implements EntityBlock {

    public AnalyzerBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(
            BlockPos position,
            BlockState state) {
        return new AnalyzerBlockEntity(position, state);
    }

    @Override
    public InteractionResult use(
            BlockState state,
            Level level,
            BlockPos position,
            Player player,
            InteractionHand hand,
            BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        // Find the block entity.
        BlockEntity blockEntity = level.getBlockEntity(position);

        if (!(blockEntity instanceof AnalyzerBlockEntity analyzer)) {
            return InteractionResult.PASS;
        }

        // Get the inventory capability.
        IItemHandler inventory = analyzer
                .getCapability(ForgeCapabilities.ITEM_HANDLER)
                .orElse(null);

        if (inventory == null) {
            return InteractionResult.PASS;
        }

        // Get the player's held item.
        ItemStack held = player.getItemInHand(hand);

        // Extract the existing item.
        ItemStack previous = inventory.extractItem(0, 1, false);

        // Insert the held stack.
        if (!held.isEmpty()) {
            ItemStack remainder = inventory.insertItem(0, held, false);

            // Update the player's hand with the remainder.
            player.setItemInHand(hand, remainder);
        }

        // Return the previous item.
        if (!previous.isEmpty()) {

            // Use the hand if it is empty.
            if (player.getItemInHand(hand).isEmpty()) {
                player.setItemInHand(hand, previous);
            }

            // Otherwise, attempt to insert it into the inventory.
            else if (!player.getInventory().add(previous)) {

                // Drop it into the world if the inventory is full.
                Containers.dropItemStack(
                        level,
                        position.getX() + 0.5,
                        position.getY() + 1.0,
                        position.getZ() + 0.5,
                        previous);
            }
        }

        return InteractionResult.CONSUME;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(
            BlockState state,
            Level level,
            BlockPos position,
            BlockState newState,
            boolean isMoving) {

        if (state.is(newState.getBlock()) || level.isClientSide) {
            super.onRemove(state, level, position, newState, isMoving);
            return;
        }

        BlockEntity blockEntity = level.getBlockEntity(position);
        if (blockEntity == null) {
            super.onRemove(state, level, position, newState, isMoving);
            return;
        }

        IItemHandler inventory = blockEntity
                .getCapability(ForgeCapabilities.ITEM_HANDLER)
                .orElse(null);

        if (inventory == null) {
            super.onRemove(state, level, position, newState, isMoving);
            return;
        }

        ItemStack contents = inventory.extractItem(0, 1, false);
        if (contents.isEmpty()) {
            super.onRemove(state, level, position, newState, isMoving);
            return;
        }

        Containers.dropItemStack(
                level,
                position.getX() + 0.5,
                position.getY() + 0.5,
                position.getZ() + 0.5,
                contents);

        super.onRemove(state, level, position, newState, isMoving);
    }
}
