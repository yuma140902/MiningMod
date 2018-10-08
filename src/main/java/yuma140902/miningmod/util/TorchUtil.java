package yuma140902.miningmod.util;

import cpw.mods.fml.common.registry.GameData;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class TorchUtil {
	private TorchUtil() {}
	
	public static boolean isTorch(Item item) {
		String[] torchNameList =
			{
				"minecraft:torch"
			};
		for(int i = 0; i < torchNameList.length; ++i) {
			if(torchNameList[i].equals(GameData.getItemRegistry().getNameForObject(item))) {
				return true;
			}
		}
		return false;
	}
	
	public static int getTorchInInventorySlots(EntityPlayer player) {
		for(int i = 0; i <= 35; ++i) { //インベントリはホットバーも含めて36個。ホットバーの一番左が0である。
			ItemStack itemStack = player.inventory.getStackInSlot(i);
			if(itemStack != null && isTorch(itemStack.getItem())) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		if(!world.isRemote) {
			int torchSlot = getTorchInInventorySlots(player);
			if(torchSlot < 0) { return false; }
			
			ItemStack torchItemStack = player.inventory.getStackInSlot(torchSlot);
			boolean result = Item.getItemFromBlock(Blocks.torch).onItemUse(torchItemStack, player, world, x, y, z, side, par8, par9, par10);
			player.onUpdate();
			player.addStat(StatList.objectUseStats[Block.getIdFromBlock(Blocks.torch)], 1);
			
			return result;
		}
		
		return false;
	}
}
