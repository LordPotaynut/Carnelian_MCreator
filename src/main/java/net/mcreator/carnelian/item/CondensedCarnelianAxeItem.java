
package net.mcreator.carnelian.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.carnelian.itemgroup.MagicCraftItemGroup;
import net.mcreator.carnelian.CarnelianModElements;

@CarnelianModElements.ModElement.Tag
public class CondensedCarnelianAxeItem extends CarnelianModElements.ModElement {
	@ObjectHolder("carnelian:condensed_carnelian_axe")
	public static final Item block = null;
	public CondensedCarnelianAxeItem(CarnelianModElements instance) {
		super(instance, 34);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2048;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 8f;
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
		}, 1, -3f, new Item.Properties().group(MagicCraftItemGroup.tab)) {
		}.setRegistryName("condensed_carnelian_axe"));
	}
}
