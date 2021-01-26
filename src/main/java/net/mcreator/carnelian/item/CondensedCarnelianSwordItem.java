
package net.mcreator.carnelian.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.carnelian.itemgroup.MagicCraftItemGroup;
import net.mcreator.carnelian.CarnelianModElements;

@CarnelianModElements.ModElement.Tag
public class CondensedCarnelianSwordItem extends CarnelianModElements.ModElement {
	@ObjectHolder("carnelian:condensed_carnelian_sword")
	public static final Item block = null;
	public CondensedCarnelianSwordItem(CarnelianModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
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
		}, 3, -2.4f, new Item.Properties().group(MagicCraftItemGroup.tab)) {
		}.setRegistryName("condensed_carnelian_sword"));
	}
}
