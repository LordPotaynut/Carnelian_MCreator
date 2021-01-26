
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
public class CarnelianShardAxeItem extends CarnelianModElements.ModElement {
	@ObjectHolder("carnelian:carnelian_shard_axe")
	public static final Item block = null;
	public CarnelianShardAxeItem(CarnelianModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 512;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CarnelianShardItem.block, (int) (1)),
						new ItemStack(CarnelianCrystalItem.block, (int) (1)));
			}
		}, 1, -3.1f, new Item.Properties().group(MagicCraftItemGroup.tab)) {
		}.setRegistryName("carnelian_shard_axe"));
	}
}
