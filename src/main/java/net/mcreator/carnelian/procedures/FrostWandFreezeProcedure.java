package net.mcreator.carnelian.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.carnelian.CarnelianModElements;
import net.mcreator.carnelian.CarnelianMod;

import java.util.Random;
import java.util.Map;

@CarnelianModElements.ModElement.Tag
public class FrostWandFreezeProcedure extends CarnelianModElements.ModElement {
	public FrostWandFreezeProcedure(CarnelianModElements instance) {
		super(instance, 12);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CarnelianMod.LOGGER.warn("Failed to load dependency entity for procedure FrostWandFreeze!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				CarnelianMod.LOGGER.warn("Failed to load dependency itemstack for procedure FrostWandFreeze!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CarnelianMod.LOGGER.warn("Failed to load dependency world for procedure FrostWandFreeze!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		double BlockYCoordinates = 0;
		boolean BlockHasAir = false;
		BlockHasAir = (boolean) (false);
		if (((world.getBlockState(new BlockPos(
				(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
				(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
				(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
								.getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
			BlockYCoordinates = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY());
			for (int index0 = 0; index0 < (int) (3); index0++) {
				if ((!(world
						.isAirBlock(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
										(int) ((BlockYCoordinates) + 1),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
														entity.getLook(1f).z * 3),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))))) {
					BlockYCoordinates = (double) ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) + 1);
				} else {
					BlockHasAir = (boolean) (true);
					break;
				}
			}
			if (((BlockHasAir) == (true))) {
				{
					BlockPos _bp = new BlockPos(
							(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
							(int) (BlockYCoordinates),
							(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()));
					BlockState _bs = Blocks.FROSTED_ICE.getDefaultState();
					world.setBlockState(_bp, _bs, 3);
				}
				if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
					{
						ItemStack _ist = (itemstack);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
			}
		}
		if (((world.getBlockState(new BlockPos(
				(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
				(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
				(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
								.getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
			BlockYCoordinates = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY());
			for (int index1 = 0; index1 < (int) (3); index1++) {
				if ((!(world
						.isAirBlock(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
										(int) ((BlockYCoordinates) + 1),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
														entity.getLook(1f).z * 3),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))))) {
					BlockYCoordinates = (double) ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) + 1);
				} else {
					BlockHasAir = (boolean) (true);
					break;
				}
			}
			if (((BlockHasAir) == (true))) {
				{
					BlockPos _bp = new BlockPos(
							(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
							(int) (BlockYCoordinates),
							(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()));
					BlockState _bs = Blocks.OBSIDIAN.getDefaultState();
					world.setBlockState(_bp, _bs, 3);
				}
				if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
					{
						ItemStack _ist = (itemstack);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
			}
		}
	}
}
