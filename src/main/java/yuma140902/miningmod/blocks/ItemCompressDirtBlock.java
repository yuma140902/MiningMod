package yuma140902.miningmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemCompressDirtBlock extends ItemBlockWithMetadata {
	public ItemCompressDirtBlock(Block block) {
		super(block, block);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return this.getUnlocalizedName() + "." + itemStack.getItemDamage();
	}
}
