
package net.mcreator.carnelian.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.carnelian.itemgroup.MagicCraftItemGroup;
import net.mcreator.carnelian.CarnelianModElements;

@CarnelianModElements.ModElement.Tag
public class CarnelianCrystalPickaxeItem extends CarnelianModElements.ModElement {
	@ObjectHolder("carnelian:carnelian_crystal_pickaxe")
	public static final Item block = null;
	public CarnelianCrystalPickaxeItem(CarnelianModElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
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
		}, 1, -3f, new Item.Properties().group(MagicCraftItemGroup.tab)) {
		}.setRegistryName("carnelian_crystal_pickaxe"));
	}
}
