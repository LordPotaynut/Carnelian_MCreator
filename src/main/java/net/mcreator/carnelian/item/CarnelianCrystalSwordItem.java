
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
public class CarnelianCrystalSwordItem extends CarnelianModElements.ModElement {
	@ObjectHolder("carnelian:carnelian_crystal_sword")
	public static final Item block = null;
	public CarnelianCrystalSwordItem(CarnelianModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1024;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 16;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CarnelianShardItem.block, (int) (1)),
						new ItemStack(CarnelianCrystalItem.block, (int) (1)));
			}
		}, 3, -2.4f, new Item.Properties().group(MagicCraftItemGroup.tab)) {
		}.setRegistryName("carnelian_crystal_sword"));
	}
}
