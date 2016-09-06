package nl.makertim.bikemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class BikeItem extends Item {

	public BikeItem() {
		this.setCreativeTab(CreativeTabs.TRANSPORTATION);
	}

	public EnumActionResult onItemUse(ItemStack itemstack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float v0, float v1, float v2) {
		if (facing == EnumFacing.DOWN) {
			return EnumActionResult.FAIL;
		} else {
			boolean isWalkthoughAble = world.getBlockState(pos).getBlock().isReplaceable(world, pos);
			BlockPos placeLocation = isWalkthoughAble ? pos : pos.offset(facing);
			if (!player.canPlayerEdit(placeLocation, facing, itemstack)) {
				return EnumActionResult.FAIL;
			} else {
				double x = (double) placeLocation.getX();
				double y = (double) placeLocation.getY();
				double z = (double) placeLocation.getZ();
				List entitiesNear = world.getEntitiesWithinAABBExcludingEntity(null,
					new AxisAlignedBB(x, y, z, x + 1.0D, y + 2.0D, z + 1.0D));
				if (!entitiesNear.isEmpty()) {
					return EnumActionResult.FAIL;
				} else {
					if (!world.isRemote) {
						world.setBlockToAir(placeLocation);
						BikeEntity bike = new BikeEntity(world);
						EntityArmorStand lvt_21_1_ = new EntityArmorStand(world, x + 0.5D, y, z + 0.5D);
						float lvt_22_1_ = (float) MathHelper
								.floor_float((MathHelper.wrapDegrees(player.rotationYaw - 180.0F) + 22.5F) / 45.0F)
								* 45.0F;
						lvt_21_1_.setLocationAndAngles(x + 0.5D, y, z + 0.5D, lvt_22_1_, 0.0F);
						// this.applyRandomRotations(lvt_21_1_, world.rand);
						ItemMonsterPlacer.applyItemEntityDataToEntity(world, player, itemstack, lvt_21_1_);
						world.spawnEntityInWorld(lvt_21_1_);
						world.playSound((EntityPlayer) null, lvt_21_1_.posX, lvt_21_1_.posY, lvt_21_1_.posZ,
							SoundEvents.ENTITY_ARMORSTAND_PLACE, SoundCategory.BLOCKS, 0.75F, 0.8F);
					}

					--itemstack.stackSize;
					return EnumActionResult.SUCCESS;
				}
			}
		}
	}
}
