package nl.makertim.bikemod.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import nl.makertim.bikemod.BikeEntity;
import nl.makertim.bikemod.BikeRender;
import nl.makertim.bikemod.Bikes;
import nl.makertim.bikemod.ModInfo;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		super.preInit();
		OBJLoader.INSTANCE.addDomain(ModInfo.MOD_ID);
		ModelLoader.setCustomModelResourceLocation(Bikes.item, 0,
			new ModelResourceLocation(new ResourceLocation(ModInfo.MOD_ID, "bike"), "inventory"));
	}

	@Override
	public void registerEntity() {
		super.registerEntity();
		RenderingRegistry.registerEntityRenderingHandler(BikeEntity.class, new BikeRender.Factory());
	}

	@Override
	public void registerItems() {
		super.registerItems();
	}
}
