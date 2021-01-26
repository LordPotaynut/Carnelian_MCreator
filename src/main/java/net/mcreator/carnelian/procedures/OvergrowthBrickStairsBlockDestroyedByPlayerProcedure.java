package net.mcreator.carnelian.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.carnelian.block.OvergrowthBrickStairsBlock;
import net.mcreator.carnelian.CarnelianModElements;
import net.mcreator.carnelian.CarnelianMod;

import java.util.Map;

@CarnelianModElements.ModElement.Tag
public class OvergrowthBrickStairsBlockDestroyedByPlayerProcedure extends CarnelianModElements.ModElement {
	public OvergrowthBrickStairsBlockDestroyedByPlayerProcedure(CarnelianModElements instance) {
		super(instance, 99);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CarnelianMod.LOGGER.warn("Failed to load dependency entity for procedure OvergrowthBrickStairsBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CarnelianMod.LOGGER.warn("Failed to load dependency x for procedure OvergrowthBrickStairsBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CarnelianMod.LOGGER.warn("Failed to load dependency y for procedure OvergrowthBrickStairsBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CarnelianMod.LOGGER.warn("Failed to load dependency z for procedure OvergrowthBrickStairsBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CarnelianMod.LOGGER.warn("Failed to load dependency world for procedure OvergrowthBrickStairsBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))
				&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() instanceof PickaxeItem))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
						new ItemStack(OvergrowthBrickStairsBlock.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
