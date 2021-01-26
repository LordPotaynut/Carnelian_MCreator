
package net.mcreator.carnelian.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.carnelian.itemgroup.MagicCraftItemGroup;
import net.mcreator.carnelian.CarnelianModElements;

@CarnelianModElements.ModElement.Tag
public class RockCandyRedItem extends CarnelianModElements.ModElement {
	@ObjectHolder("carnelian:rock_candy_red")
	public static final Item block = null;
	public RockCandyRedItem(CarnelianModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(MagicCraftItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.4f).build()));
			setRegistryName("rock_candy_red");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 16;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
