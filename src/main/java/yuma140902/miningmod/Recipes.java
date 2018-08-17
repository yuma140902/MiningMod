package yuma140902.miningmod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import yuma140902.miningmod.blocks.CompressCobblestoneBlock;

public final class Recipes {
	private Recipes() {}
	public static void register() {
		final int MAX = CompressCobblestoneBlock.MAX;
		
		ItemStack[] compressCobblestoneBlockTmp1 = new ItemStack[MAX];
		for(int i = 0; i < MAX; ++i) {
			compressCobblestoneBlockTmp1[i] = new ItemStack(MiningMod.compressCobblestoneBlock, 1, i);
		}
		
		GameRegistry.addShapelessRecipe(compressCobblestoneBlockTmp1[0],
				Blocks.cobblestone,
				Blocks.cobblestone,
				Blocks.cobblestone,
				Blocks.cobblestone);
		
		for(int i = 1; i < MAX; ++i) {
			GameRegistry.addShapelessRecipe(compressCobblestoneBlockTmp1[i],
					compressCobblestoneBlockTmp1[i-1],
					compressCobblestoneBlockTmp1[i-1],
					compressCobblestoneBlockTmp1[i-1],
					compressCobblestoneBlockTmp1[i-1]
					);
		}
		
		
		
		ItemStack[] compressCobblestoneBlockTmp4 = new ItemStack[MAX];
		for(int i = 0; i < MAX; ++i) {
			compressCobblestoneBlockTmp4[i]= new ItemStack(MiningMod.compressCobblestoneBlock, 4, i); 
		}
		
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 4), 
				compressCobblestoneBlockTmp4[0]);
		
		for(int i = MAX - 1; i >= 1; --i) {
			GameRegistry.addShapelessRecipe(compressCobblestoneBlockTmp4[i-1], 
					compressCobblestoneBlockTmp4[i]);
		}
	}
}
