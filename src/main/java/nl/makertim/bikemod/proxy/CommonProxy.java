package nl.makertim.bikemod.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.makertim.bikemod.BikeEntity;
import nl.makertim.bikemod.BikeItem;
import nl.makertim.bikemod.Bikes;

public class CommonProxy {

	public void preInit() {
	}

	public void registerItems() {
		Bikes.item = new BikeItem();
		GameRegistry.register(Bikes.item);
	}

	public void registerEntity() {
		EntityRegistry.registerModEntity(BikeEntity.class, "bike", 2304, Bikes.instance, 20, 20, true);
	}

	public void registerRender(FMLPostInitializationEvent event) {
	}
}
