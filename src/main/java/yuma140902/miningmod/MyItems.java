package yuma140902.miningmod;

import net.minecraft.item.Item.ToolMaterial;
import yuma140902.miningmod.blocks.IRegisterable;
import yuma140902.miningmod.items.ItemTorchPickaxe;

public class MyItems {
	private MyItems() {}
	
	public static void register() {
		((IRegisterable) torchWoodenPickaxe).register();
		((IRegisterable) torchStonePickaxe).register();
		((IRegisterable) torchIronPickaxe).register();
		((IRegisterable) torchGoldenPickaxe).register();
		((IRegisterable) torchDiamondPickaxe).register();
	}
		
	
	public static final ItemTorchPickaxe torchWoodenPickaxe = new ItemTorchPickaxe(ToolMaterial.WOOD);
	public static final ItemTorchPickaxe torchStonePickaxe = new ItemTorchPickaxe(ToolMaterial.STONE);
	public static final ItemTorchPickaxe torchIronPickaxe = new ItemTorchPickaxe(ToolMaterial.IRON);
	public static final ItemTorchPickaxe torchGoldenPickaxe = new ItemTorchPickaxe(ToolMaterial.GOLD);
	public static final ItemTorchPickaxe torchDiamondPickaxe = new ItemTorchPickaxe(ToolMaterial.EMERALD);
}
