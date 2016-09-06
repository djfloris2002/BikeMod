package nl.makertim.bikemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IJumpingMount;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BikeEntity extends Entity implements IJumpingMount {

	public BikeEntity(World world) {
		super(world);
	}

	public BikeEntity(World world, double x, double y, double z) {
		this(world);
		setPosition(x, y, z);
	}

	@Override
	protected void entityInit() {

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbtTagCompound) {

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbtTagCompound) {

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void setJumpPower(int i) {
	}

	@Override
	public boolean canJump() {
		return false;
	}

	@Override
	public void handleStartJump(int i) {
	}

	@Override
	public void handleStopJump() {
	}
}
