
package net.mcreator.carnelian.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.carnelian.itemgroup.MagicCraftItemGroup;
import net.mcreator.carnelian.CarnelianModElements;

@CarnelianModElements.ModElement.Tag
public class MusicDiscWaterItem extends CarnelianModElements.ModElement {
	@ObjectHolder("carnelian:music_disc_water")
	public static final Item block = null;
	public MusicDiscWaterItem(CarnelianModElements instance) {
		super(instance, 153);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, CarnelianModElements.sounds.get(new ResourceLocation("carnelian:music_disc_water")),
					new Item.Properties().group(MagicCraftItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("music_disc_water");
		}
	}
}
