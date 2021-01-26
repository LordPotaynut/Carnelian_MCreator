
package net.mcreator.carnelian.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.carnelian.itemgroup.MagicCraftItemGroup;
import net.mcreator.carnelian.CarnelianModElements;

@CarnelianModElements.ModElement.Tag
public class CondensedCarnelianHoeItem extends CarnelianModElements.ModElement {
	@ObjectHolder("carnelian:condensed_carnelian_hoe")
	public static final Item block = null;
	public CondensedCarnelianHoeItem(CarnelianModElements instance) {
		super(instance, 35);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 2048;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 18;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CondensedCarnelianItem.block, (int) (1)));
			}
		}, 0, -3f, new Item.Properties().group(MagicCraftItemGroup.tab)) {
		}.setRegistryName("condensed_carnelian_hoe"));
	}
}
