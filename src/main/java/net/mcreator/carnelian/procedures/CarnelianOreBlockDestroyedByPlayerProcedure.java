package net.mcreator.carnelian.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;

import net.mcreator.carnelian.item.CarnelianShardItem;
import net.mcreator.carnelian.item.CarnelianCrystalItem;
import net.mcreator.carnelian.block.CarnelianOreBlock;
import net.mcreator.carnelian.CarnelianModElements;
import net.mcreator.carnelian.CarnelianMod;

import java.util.Map;

@CarnelianModElements.ModElement.Tag
public class CarnelianOreBlockDestroyedByPlayerProcedure extends CarnelianModElements.ModElement {
	public CarnelianOreBlockDestroyedByPlayerProcedure(CarnelianModElements instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CarnelianMod.LOGGER.warn("Failed to load dependency entity for procedure CarnelianOreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CarnelianMod.LOGGER.warn("Failed to load dependency x for procedure CarnelianOreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CarnelianMod.LOGGER.warn("Failed to load dependency y for procedure CarnelianOreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CarnelianMod.LOGGER.warn("Failed to load dependency z for procedure CarnelianOreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CarnelianMod.LOGGER.warn("Failed to load dependency world for procedure CarnelianOreBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack HeldTool = ItemStack.EMPTY;
		HeldTool = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
		if (((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))
				&& ((HeldTool).getItem() instanceof PickaxeItem))) {
			if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, (HeldTool)) != 0))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
							new ItemStack(CarnelianOreBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (((HeldTool).getItem().canHarvestBlock(Blocks.OBSIDIAN.getDefaultState()))) {
				for (int index0 = 0; index0 < (int) ((Math
						.ceil((Math.random() * (EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, (HeldTool))))) + 1)); index0++) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
								new ItemStack(CarnelianCrystalItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).addEntity(
							new ExperienceOrbEntity(((World) world), (x + 0.5), (y + 0.5), (z + 0.5), (int) Math.round(((Math.random() * 4) + 1))));
				}
			} else {
				for (int index1 = 0; index1 < (int) ((Math
						.ceil((Math.random() * (EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, (HeldTool))))) + 1)); index1++) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
								new ItemStack(CarnelianShardItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).addEntity(
							new ExperienceOrbEntity(((World) world), (x + 0.5), (y + 0.5), (z + 0.5), (int) Math.round(((Math.random() * 2) + 1))));
				}
			}
		}
	}
}
