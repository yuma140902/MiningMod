package yuma140902.miningmod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import yuma140902.miningmod.blocks.CompressCobblestoneBlock;
import yuma140902.miningmod.blocks.CompressDirtBlock;

public final class Recipes {
	private Recipes() {}
	public static void register() {
		final int COBBLESTONE_MAX = CompressCobblestoneBlock.MAX;
		
		ItemStack[] compressCobblestoneBlockTmp1 = new ItemStack[COBBLESTONE_MAX];
		for(int i = 0; i < COBBLESTONE_MAX; ++i) {
			compressCobblestoneBlockTmp1[i] = new ItemStack(MiningMod.compressCobblestoneBlock, 1, i);
		}
		
		GameRegistry.addShapelessRecipe(compressCobblestoneBlockTmp1[0],
				Blocks.cobblestone,
				Blocks.cobblestone,
				Blocks.cobblestone,
				Blocks.cobblestone);
		
		for(int i = 1; i < COBBLESTONE_MAX; ++i) {
			GameRegistry.addShapelessRecipe(compressCobblestoneBlockTmp1[i],
					compressCobblestoneBlockTmp1[i-1],
					compressCobblestoneBlockTmp1[i-1],
					compressCobblestoneBlockTmp1[i-1],
					compressCobblestoneBlockTmp1[i-1]
					);
		}
		
		
		
		ItemStack[] compressCobblestoneBlockTmp4 = new ItemStack[COBBLESTONE_MAX];
		for(int i = 0; i < COBBLESTONE_MAX; ++i) {
			compressCobblestoneBlockTmp4[i]= new ItemStack(MiningMod.compressCobblestoneBlock, 4, i); 
		}
		
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 4), 
				compressCobblestoneBlockTmp4[0]);
		
		for(int i = COBBLESTONE_MAX - 1; i >= 1; --i) {
			GameRegistry.addShapelessRecipe(compressCobblestoneBlockTmp4[i-1], 
					compressCobblestoneBlockTmp4[i]);
		}
		
		
		
		final int DIRT_MAX = CompressDirtBlock.MAX;
		
		ItemStack[] compressDirtBlockTmp1 = new ItemStack[DIRT_MAX];
		for(int i = 0; i < DIRT_MAX; ++i) {
			compressDirtBlockTmp1[i] = new ItemStack(MiningMod.compressDirtBlock, 1, i);
		}
		
		GameRegistry.addShapelessRecipe(compressDirtBlockTmp1[0],
				Blocks.dirt,
				Blocks.dirt,
				Blocks.dirt,
				Blocks.dirt);
		
		for(int i = 1; i < DIRT_MAX; ++i) {
			GameRegistry.addShapelessRecipe(compressDirtBlockTmp1[i],
					compressDirtBlockTmp1[i-1],
					compressDirtBlockTmp1[i-1],
					compressDirtBlockTmp1[i-1],
					compressDirtBlockTmp1[i-1]
					);
		}
		
		
		
		ItemStack[] compressDirtBlockTmp4 = new ItemStack[DIRT_MAX];
		for(int i = 0; i < DIRT_MAX; ++i) {
			compressDirtBlockTmp4[i]= new ItemStack(MiningMod.compressDirtBlock, 4, i); 
		}
		
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.dirt, 4), 
				compressDirtBlockTmp4[0]);
		
		for(int i = DIRT_MAX - 1; i >= 1; --i) {
			GameRegistry.addShapelessRecipe(compressDirtBlockTmp4[i-1], 
					compressDirtBlockTmp4[i]);
		}
	}
}
