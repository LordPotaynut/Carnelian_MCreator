
package net.mcreator.carnelian.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.carnelian.block.CarnelianBlockBlock;
import net.mcreator.carnelian.CarnelianModElements;

@CarnelianModElements.ModElement.Tag
public class MagicCraftItemGroup extends CarnelianModElements.ModElement {
	public MagicCraftItemGroup(CarnelianModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmagic_craft") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CarnelianBlockBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
