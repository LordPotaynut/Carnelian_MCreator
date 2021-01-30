package net.mcreator.carnelian.procedures;

@CarnelianModElements.ModElement.Tag
public class WoodShurikenRemoveOneOfStackProcedure extends CarnelianModElements.ModElement {

	public WoodShurikenRemoveOneOfStackProcedure(CarnelianModElements instance) {
		super(instance, 184);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CarnelianMod.LOGGER.warn("Failed to load dependency entity for procedure WoodShurikenRemoveOneOfStack!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				CarnelianMod.LOGGER.warn("Failed to load dependency itemstack for procedure WoodShurikenRemoveOneOfStack!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");

		if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
			((itemstack)).shrink((int) 1);
		}

	}

}
