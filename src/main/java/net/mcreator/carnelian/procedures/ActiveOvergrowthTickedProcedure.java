package net.mcreator.carnelian.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;
import net.minecraft.block.Blocks;

import net.mcreator.carnelian.CarnelianModElements;
import net.mcreator.carnelian.CarnelianMod;

import java.util.Map;

@CarnelianModElements.ModElement.Tag
public class ActiveOvergrowthTickedProcedure extends CarnelianModElements.ModElement {
	public ActiveOvergrowthTickedProcedure(CarnelianModElements instance) {
		super(instance, 177);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CarnelianMod.LOGGER.warn("Failed to load dependency x for procedure ActiveOvergrowthTicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CarnelianMod.LOGGER.warn("Failed to load dependency y for procedure ActiveOvergrowthTicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CarnelianMod.LOGGER.warn("Failed to load dependency z for procedure ActiveOvergrowthTicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CarnelianMod.LOGGER.warn("Failed to load dependency world for procedure ActiveOvergrowthTicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double randNumber = 0;
		ItemStack blockAbove = ItemStack.EMPTY;
		randNumber = (double) (Math.random() * 8.99);
		if (((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.PLANTS)
				&& (Math.random() >= 0.66))
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK.getDefaultState()
						.getBlock()))) {
			if (world instanceof World) {
				if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) (y + 1), (int) z))
						|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) (y + 1), (int) z),
								(Direction) null)) {
					if (!world.isRemote())
						((World) world).playEvent(2005, new BlockPos((int) x, (int) (y + 1), (int) z), 0);
				}
			}
		} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.FARMLAND.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock()))) {
			if (world instanceof World) {
				if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world,
						new BlockPos((int) ((x - 1) + (Math.floor((randNumber)) % 3)), (int) (y + 2),
								(int) ((z - 1) + Math.floor(((randNumber) / 3)))))
						|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world,
								new BlockPos((int) ((x - 1) + (Math.floor((randNumber)) % 3)), (int) (y + 2),
										(int) ((z - 1) + Math.floor(((randNumber) / 3)))),
								(Direction) null)) {
					if (!world.isRemote())
						((World) world).playEvent(2005, new BlockPos((int) ((x - 1) + (Math.floor((randNumber)) % 3)), (int) (y + 2),
								(int) ((z - 1) + Math.floor(((randNumber) / 3)))), 0);
				}
			}
		}
	}
}
