
package net.mcreator.carnelian.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.carnelian.itemgroup.MagicCraftItemGroup;
import net.mcreator.carnelian.CarnelianModElements;

import java.util.List;
import java.util.Collections;

@CarnelianModElements.ModElement.Tag
public class SmoothCarnelianStoneBlock extends CarnelianModElements.ModElement {
	@ObjectHolder("carnelian:smooth_carnelian_stone")
	public static final Block block = null;
	public SmoothCarnelianStoneBlock(CarnelianModElements instance) {
		super(instance, 82);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(MagicCraftItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2f, 6f).setLightLevel(s -> 0).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("smooth_carnelian_stone");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 0));
		}
	}
}
