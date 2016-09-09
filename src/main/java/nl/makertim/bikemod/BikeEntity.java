package nl.makertim.bikemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IJumpingMount;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BikeEntity extends Entity implements IJumpingMount, IWorldNameable {

	private static final DataParameter<Float> DIRECTION = EntityDataManager.createKey(BikeEntity.class,
		DataSerializers.FLOAT);

	public BikeEntity(World world) {
		super(world);
		setEntityBoundingBox(new AxisAlignedBB(0, 0, 0, 1, 1, 1));
	}

	public BikeEntity(World world, double x, double y, double z) {
		this(world);
		setPosition(x, y, z);
	}

	@Override
	protected void entityInit() {
		dataManager.register(DIRECTION, Float.valueOf(0.0F));
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
