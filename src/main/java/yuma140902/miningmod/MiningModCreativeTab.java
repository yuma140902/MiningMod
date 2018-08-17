package yuma140902.miningmod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MiningModCreativeTab extends CreativeTabs {
	public MiningModCreativeTab() {
		super(MiningMod.MOD_ID);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return new ItemStack(Blocks.cobblestone);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {return null;}
	
}
