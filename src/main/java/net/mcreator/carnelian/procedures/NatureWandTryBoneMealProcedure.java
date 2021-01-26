package net.mcreator.carnelian.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.carnelian.CarnelianModElements;
import net.mcreator.carnelian.CarnelianMod;

import java.util.Random;
import java.util.Map;

@CarnelianModElements.ModElement.Tag
public class NatureWandTryBoneMealProcedure extends CarnelianModElements.ModElement {
	public NatureWandTryBoneMealProcedure(CarnelianModElements instance) {
		super(instance, 55);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CarnelianMod.LOGGER.warn("Failed to load dependency entity for procedure NatureWandTryBoneMeal!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CarnelianMod.LOGGER.warn("Failed to load dependency x for procedure NatureWandTryBoneMeal!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CarnelianMod.LOGGER.warn("Failed to load dependency y for procedure NatureWandTryBoneMeal!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CarnelianMod.LOGGER.warn("Failed to load dependency z for procedure NatureWandTryBoneMeal!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CarnelianMod.LOGGER.warn("Failed to load dependency world for procedure NatureWandTryBoneMeal!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DIRT.getDefaultState().getBlock())) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.GRASS_BLOCK.getDefaultState(), 3);
			if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
				{
					ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
		} else {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			if (world instanceof World) {
				if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) y, (int) z)) || BoneMealItem
						.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) y, (int) z), (Direction) null)) {
					if (!world.isRemote())
						((World) world).playEvent(2005, new BlockPos((int) x, (int) y, (int) z), 0);
				}
			}
			if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
				{
					ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
		}
	}
}
