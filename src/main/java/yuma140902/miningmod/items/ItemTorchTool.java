package yuma140902.miningmod.items;

import java.util.Set;
import cpw.mods.fml.common.registry.GameData;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import yuma140902.miningmod.blocks.IRegisterable;

public abstract class ItemTorchTool extends ItemTool implements IRegisterable{

	
	protected ItemTorchTool(float p_i45333_1_, ToolMaterial p_i45333_2_, Set p_i45333_3_) {
		super(p_i45333_1_, p_i45333_2_, p_i45333_3_);
	}

	private boolean isTorch(Item item) {
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
	
	private int getTorchInInventorySlots(EntityPlayer player) {
		for(int i = 0; i <= 35; ++i) { //インベントリはホットバーも含めて36個。ホットバーの一番左が0である。
			ItemStack itemStack = player.inventory.getStackInSlot(i);
			if(itemStack != null && isTorch(itemStack.getItem())) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
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
