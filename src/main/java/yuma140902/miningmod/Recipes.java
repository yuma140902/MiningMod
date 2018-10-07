package yuma140902.miningmod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
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
		
		
		//== ここから圧縮ツール ==//
		for(int meta = 0; meta < COBBLESTONE_MAX; ++meta) {
			ItemStack output = new ItemStack(Items.stone_pickaxe, 1, 0);
			output.addEnchantment(Enchantment.efficiency, (int) ((meta + 1) * MiningMod.INSTANCE.compressToolEfficiencyFactor));
			output.addEnchantment(Enchantment.unbreaking, (int) ((meta + 1) * MiningMod.INSTANCE.compressToolUnbreakableFactor));
			output.setStackDisplayName(StatCollector.translateToLocal("text.stonepickaxe." + meta + ".stackname"));
			GameRegistry.addRecipe(output,
					"###",
					" | ",
					" | ",
					'#', new ItemStack(MiningMod.compressCobblestoneBlock, 1, meta),
					'|', Items.stick
					);
		}
		
		for(int meta = 0; meta < COBBLESTONE_MAX; ++meta) {
			ItemStack output = new ItemStack(Items.stone_shovel, 1, 0);
			output.addEnchantment(Enchantment.efficiency, (int) ((meta + 1) * MiningMod.INSTANCE.compressToolEfficiencyFactor));
			output.addEnchantment(Enchantment.unbreaking, (int) ((meta + 1) * MiningMod.INSTANCE.compressToolUnbreakableFactor));
			output.setStackDisplayName(StatCollector.translateToLocal("text.stoneshovel." + meta + ".stackname"));
			GameRegistry.addRecipe(output,
					"#",
					"|",
					"|",
					'#', new ItemStack(MiningMod.compressCobblestoneBlock, 1, meta),
					'|', Items.stick
					);
		}
		
		for(int meta = 0; meta < COBBLESTONE_MAX; ++meta) {
			ItemStack output = new ItemStack(Items.stone_axe, 1, 0);
			output.addEnchantment(Enchantment.efficiency, (int) ((meta + 1) * MiningMod.INSTANCE.compressToolEfficiencyFactor));
			output.addEnchantment(Enchantment.unbreaking, (int) ((meta + 1) * MiningMod.INSTANCE.compressToolUnbreakableFactor));
			output.setStackDisplayName(StatCollector.translateToLocal("text.stoneaxe." + meta + ".stackname"));
			GameRegistry.addRecipe(output,
					"##",
					"#|",
					" |",
					'#', new ItemStack(MiningMod.compressCobblestoneBlock, 1, meta),
					'|', Items.stick
					);
		}
		
		for(int meta = 0; meta < COBBLESTONE_MAX; ++meta) {
			ItemStack output = new ItemStack(Items.stone_sword, 1, 0);
			output.addEnchantment(Enchantment.looting, (int) ((meta + 1) * MiningMod.INSTANCE.compressToolLootingFactor));
			output.addEnchantment(Enchantment.unbreaking, (int) ((meta + 1) * MiningMod.INSTANCE.compressToolUnbreakableFactor));
			output.setStackDisplayName(StatCollector.translateToLocal("text.stonesword." + meta + ".stackname"));
			GameRegistry.addRecipe(output,
					"#",
					"#",
					"|",
					'#', new ItemStack(MiningMod.compressCobblestoneBlock, 1, meta),
					'|', Items.stick
					);
		}
		
		for(int meta = 0; meta < COBBLESTONE_MAX; ++meta) {
			ItemStack output = new ItemStack(Items.stone_hoe, 1, 0);
			output.addEnchantment(Enchantment.unbreaking, (int) ((meta + 1) * MiningMod.INSTANCE.compressToolUnbreakableFactor));
			output.setStackDisplayName(StatCollector.translateToLocal("text.stonehoe." + meta + ".stackname"));
			GameRegistry.addRecipe(output,
					"##",
					" |",
					" |",
					'#', new ItemStack(MiningMod.compressCobblestoneBlock, 1, meta),
					'|', Items.stick
					);
		}
		
		final int
				PLANK_META_OAK = 0,
				PLANK_META_ACACIA = 4,
				PLANK_META_BIRCH = 2,
				PLANK_META_DARKOAK = 5,
				PLANK_META_JUNGLE = 3,
				PLANK_META_SPRUCE = 1;
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.acacia_stairs, 2, 0),
				" #",
				"##",
				'#', new ItemStack(Blocks.planks, 1, PLANK_META_ACACIA)
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.birch_stairs, 2, 0),
				" #",
				"##",
				'#', new ItemStack(Blocks.planks, 1, PLANK_META_BIRCH)
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.dark_oak_stairs, 2, 0),
				" #",
				"##",
				'#', new ItemStack(Blocks.planks, 1, PLANK_META_DARKOAK)
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.jungle_stairs, 2, 0),
				" #",
				"##",
				'#', new ItemStack(Blocks.planks, 1, PLANK_META_JUNGLE)
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.spruce_stairs, 2, 0),
				" #",
				"##",
				'#', new ItemStack(Blocks.planks, 1, PLANK_META_SPRUCE)
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.oak_stairs, 2, 0),
				" #",
				"##",
				'#', new ItemStack(Blocks.planks, 1, PLANK_META_OAK)
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.brick_stairs, 2, 0),
				" #",
				"##",
				'#', Blocks.brick_block
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.sandstone_stairs, 2, 0),
				" #",
				"##",
				'#', Blocks.sandstone
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.stone_brick_stairs, 2, 0),
				" #",
				"##",
				'#', Blocks.stonebrick
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.stone_stairs, 2, 0),
				" #",
				"##",
				'#', Blocks.cobblestone
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.nether_brick_stairs, 2, 0),
				" #",
				"##",
				'#', Blocks.nether_brick
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.quartz_stairs, 2, 0),
				" #",
				"##",
				'#', Blocks.quartz_block
				);
		
		final int
			META_SMOOTH_DOUBLE_STONE_SLAB = 8,
			META_SMOOTH_DOUBLE_SANDSTONE_SLAB = 9,
			META_SMOOTH_DOUBLE_NETHERQUARTZ_SLAB = 15,
			META_DOUBLE_STONE_SLAB = 0,
			META_SANDSTONE_SLAB = 1,
			META_NETHERQUARTZ_SLAB = 7;
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.double_stone_slab, 1, META_DOUBLE_STONE_SLAB),
				"#",
				"#",
				'#', Blocks.stone_slab
				);
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(Blocks.double_stone_slab, 1, META_DOUBLE_STONE_SLAB),
				new ItemStack(Blocks.double_stone_slab, 1, META_SMOOTH_DOUBLE_STONE_SLAB)
				);
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(Blocks.double_stone_slab, 1, META_SMOOTH_DOUBLE_STONE_SLAB),
				new ItemStack(Blocks.double_stone_slab, 1, META_DOUBLE_STONE_SLAB)
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.double_stone_slab, 1, META_SMOOTH_DOUBLE_SANDSTONE_SLAB),
				" #",
				"# ",
				'#', new ItemStack(Blocks.stone_slab, 1, META_SANDSTONE_SLAB)
				);
		
		GameRegistry.addRecipe(
				new ItemStack(Blocks.double_stone_slab, 1, META_SMOOTH_DOUBLE_NETHERQUARTZ_SLAB),
				" #",
				"# ",
				'#', new ItemStack(Blocks.stone_slab, 1, META_NETHERQUARTZ_SLAB)
				);
	}
}
