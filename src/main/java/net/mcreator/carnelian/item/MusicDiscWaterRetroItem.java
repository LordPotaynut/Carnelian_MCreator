
package net.mcreator.carnelian.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.carnelian.itemgroup.MagicCraftItemGroup;
import net.mcreator.carnelian.CarnelianModElements;

@CarnelianModElements.ModElement.Tag
public class MusicDiscWaterRetroItem extends CarnelianModElements.ModElement {
	@ObjectHolder("carnelian:music_disc_water_retro")
	public static final Item block = null;
	public MusicDiscWaterRetroItem(CarnelianModElements instance) {
		super(instance, 155);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, CarnelianModElements.sounds.get(new ResourceLocation("carnelian:music_disc_water_retro")),
					new Item.Properties().group(MagicCraftItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("music_disc_water_retro");
		}
	}
}
