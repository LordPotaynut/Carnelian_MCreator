
package net.mcreator.carnelian.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.FluidState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.carnelian.procedures.SmoothOvergrowthStoneBlockDestroyedByPlayerProcedure;
import net.mcreator.carnelian.itemgroup.MagicCraftItemGroup;
import net.mcreator.carnelian.CarnelianModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@CarnelianModElements.ModElement.Tag
public class SmoothOvergrowthStoneBlock extends CarnelianModElements.ModElement {
	@ObjectHolder("carnelian:smooth_overgrowth_stone")
	public static final Block block = null;
	public SmoothOvergrowthStoneBlock(CarnelianModElements instance) {
		super(instance, 86);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(MagicCraftItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2f, 6f).setLightLevel(s -> 0).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("smooth_overgrowth_stone");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 0));
		}

		@Override
		public boolean removedByPlayer(BlockState state, World world, BlockPos pos, PlayerEntity entity, boolean willHarvest, FluidState fluid) {
			boolean retval = super.removedByPlayer(state, world, pos, entity, willHarvest, fluid);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SmoothOvergrowthStoneBlockDestroyedByPlayerProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
