
package net.mcreator.carnelian.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.carnelian.itemgroup.MagicCraftItemGroup;
import net.mcreator.carnelian.CarnelianModElements;

@CarnelianModElements.ModElement.Tag
public class CarnelianShardShovelItem extends CarnelianModElements.ModElement {
	@ObjectHolder("carnelian:carnelian_shard_shovel")
	public static final Item block = null;
	public CarnelianShardShovelItem(CarnelianModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 512;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 2f;
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
		}, 1, -3f, new Item.Properties().group(MagicCraftItemGroup.tab)) {
		}.setRegistryName("carnelian_shard_shovel"));
	}
}
