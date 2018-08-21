package yuma140902.miningmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import yuma140902.miningmod.blocks.CompressCobblestoneBlock;
import yuma140902.miningmod.blocks.CompressDirtBlock;
import yuma140902.miningmod.blocks.ItemCompressCobblestoneBlock;
import yuma140902.miningmod.blocks.ItemCompressDirtBlock;
import yuma140902.miningmod.event_handlers.PickaxeRightClickEventHandler;

@Mod(modid = MiningMod.MOD_ID, useMetadata = true)
public class MiningMod {
	//see: http://forum.minecraftuser.jp/viewtopic.php?f=39&t=32601
	@Mod.Metadata
	public static ModMetadata modMetadata;
	
	public static final String MOD_ID = "miningmod";
	public static final String MOD_NAME = "MiningMod";
	public static final String MOD_VERSION = "MC1.7.10_1.2.1";
	
	private void loadMeta(ModMetadata modMetadata) {
		modMetadata.modId = MOD_ID;
		modMetadata.name = MOD_NAME;
		modMetadata.version = MOD_VERSION;
		modMetadata.authorList.add("yuma140902");
		modMetadata.description = "最大42億倍までの圧縮丸石、圧縮土と、それを使ったレシピを追加します";
		modMetadata.url = "https://github.com/yuma140902/miningmod";
		modMetadata.autogenerated = false;
	}
	
	public static final MiningModCreativeTab MOD_CREATIVETAB = new MiningModCreativeTab();
	
	@Mod.Instance(MOD_ID)
	public static MiningMod INSTANCE;
	
	public static Block compressCobblestoneBlock;
	public static Block compressDirtBlock;
	
	public static PickaxeRightClickEventHandler miningModEventHandler;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		loadMeta(modMetadata);
		
		MyBlocks.register();
		MyItems.register();
		
		compressCobblestoneBlock = new CompressCobblestoneBlock()
		    .setBlockName("blockCompressCobblestone")
		    .setBlockTextureName(MiningMod.MOD_ID + ":" + "compress_cobblestone");
		GameRegistry.registerBlock(compressCobblestoneBlock, ItemCompressCobblestoneBlock.class, "blockCompressCobbleStone");
		
		compressDirtBlock = new CompressDirtBlock()
				.setBlockName("blockCompressDirt")
				.setBlockTextureName(MOD_ID + ":" + "compress_dirt");
		GameRegistry.registerBlock(compressDirtBlock, ItemCompressDirtBlock.class, "blockCompressDirt");

		//see: https://www.tntmodders.com/tutorial/event-1710/
		//see: http://minecraftjp.info/modding/index.php/Minecraft_Forge_Event%E3%82%B7%E3%82%B9%E3%83%86%E3%83%A0%E6%A6%82%E8%A6%81
		miningModEventHandler = new PickaxeRightClickEventHandler();
		MinecraftForge.EVENT_BUS.register(miningModEventHandler);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Recipes.register();
	}
}
