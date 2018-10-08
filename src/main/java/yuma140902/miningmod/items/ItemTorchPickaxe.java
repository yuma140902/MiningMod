package yuma140902.miningmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import yuma140902.miningmod.MiningMod;
import yuma140902.miningmod.blocks.IRegisterable;
import yuma140902.miningmod.util.TorchUtil;

public class ItemTorchPickaxe extends ItemPickaxe implements IRegisterable {
	
	public ItemTorchPickaxe(ToolMaterial toolMaterial) {
		super(toolMaterial);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float f1, float f2, float f3) {
		return TorchUtil.onItemUse(itemStack, player, world, x, y, z, side, f1, f2, 	f3);
	}

	@Override
	public void register() {
		String materialName = toolMaterial.toString().toLowerCase();
		if(materialName.equals("emerald")) { materialName = "diamond"; }
		
		String iconString;
		switch (toolMaterial) {
			case WOOD:
				iconString = "wood_pickaxe";
				break;
			case STONE:
				iconString = "stone_pickaxe";
				break;
			case IRON:
				iconString = "iron_pickaxe";
				break;
			case GOLD:
				iconString = "gold_pickaxe";
				break;
			case EMERALD:
				iconString = "diamond_pickaxe";
				break;
			default:
				iconString = MiningMod.MOD_ID + ":no_texture";
				break;
		}
		
		this.setCreativeTab(MiningMod.MOD_CREATIVETAB);
		this.setUnlocalizedName(MiningMod.MOD_ID + "." + materialName + "_pickaxe");
		this.setTextureName(iconString);
		GameRegistry.registerItem(this, materialName + "_pickaxe");
	}
	
}
