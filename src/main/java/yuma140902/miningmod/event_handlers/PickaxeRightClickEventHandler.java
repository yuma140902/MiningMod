package yuma140902.miningmod.event_handlers;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameData;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class PickaxeRightClickEventHandler {
	
	public static final int EVENT_FACE_TOP = 1;
	public static final int EVENT_FACE_BOTTOM = 0;
	public static final int EVENT_FACE_EAST = 5;
	public static final int EVENT_FACE_WEST = 4;
	public static final int EVENT_FACE_NORTH = 3;
	public static final int EVENT_FACE_SOUTH = 2;
	
	public static final int TORCH_META_ZERO = 0;
	public static final int TORCH_META_EAST = 1;
	public static final int TORCH_META_WEST = 2;
	public static final int TORCH_META_NORTH = 3;
	public static final int TORCH_META_SOUTH = 4;
	public static final int TORCH_META_TOP = 5;
	
	private boolean isPickaxe(Item item) {
		String[] pickaxeNameList =
			{ 
				"minecraft:wooden_pickaxe", 
				"minecraft:stone_pickaxe", 
				"minecraft:iron_pickaxe", 
				"minecraft:golden_pickaxe", 
				"minecraft:diamond_pickaxe"
			};
		for(int i = 0; i < pickaxeNameList.length; ++i){
			if(pickaxeNameList[i].equals(GameData.getItemRegistry().getNameForObject(item))) {
				return true;
			}
		}
		return false;
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
	
	@SubscribeEvent(receiveCanceled = true, priority = EventPriority.LOW)
	public void onPlayerClicked(PlayerInteractEvent event) {
		if(event.action != Action.RIGHT_CLICK_BLOCK /*ブロックに向かって右クリックしたのではないとき*/
		|| event.entityPlayer.getHeldItem() == null
		|| !isPickaxe(event.entityPlayer.getHeldItem().getItem()) /*ツルハシを持っていないとき*/) {
			event.setResult(Result.DEFAULT); //何もしない
			return;
		}
		int slot = getTorchInInventorySlots(event.entityPlayer);
		if(slot < 0) {
			event.entityPlayer.addChatComponentMessage(new ChatComponentText("松明がありません"));
			event.setResult(Result.DEFAULT);
			return;
		}
		ItemStack itemStack = event.entityPlayer.inventory.getStackInSlot(slot);
		int clickedBlockX = event.x;
		int clickedBlockY = event.y;
		int clickedBlockZ = event.z;
		Block clickedBlock = event.world.getBlock(clickedBlockX, clickedBlockY, clickedBlockZ);
		int x = event.x;
		int y = event.y;
		int z = event.z;
		switch (event.face) {
			case EVENT_FACE_BOTTOM:
				y -= 1;
				break;
			case EVENT_FACE_TOP:
				y += 1;
				break;
			case EVENT_FACE_SOUTH:
				z -= 1;
				break;
			case EVENT_FACE_NORTH:
				z += 1;
				break;
			case EVENT_FACE_WEST:
				x -= 1;
				break;
			case EVENT_FACE_EAST:
				x += 1;
				break;
		}
		
		if(event.world.getBlock(x, y, z).isReplaceable(event.world, x, y, z)) {
			boolean hasPlacedTorch = true;
			
			if(event.face == EVENT_FACE_TOP
					&& (event.world.isSideSolid(clickedBlockX, clickedBlockY, clickedBlockZ, ForgeDirection.UP)
							|| clickedBlock.canPlaceTorchOnTop(event.world, clickedBlockX, clickedBlockY, clickedBlockZ))) {
				event.world.setBlock(x, y, z, Blocks.torch, TORCH_META_TOP, 3);
			}
			else if(event.face == EVENT_FACE_BOTTOM
					&& event.world.isSideSolid(clickedBlockX, clickedBlockY, clickedBlockZ, ForgeDirection.DOWN)) {
				event.world.setBlock(x, y, z, Blocks.torch);  //BlockTorchのonBlockPlaced()メソッドによって適切な向きにされる
			}
			else if(event.face == EVENT_FACE_EAST
					&& event.world.isSideSolid(clickedBlockX, clickedBlockY, clickedBlockZ, ForgeDirection.EAST)) {
				event.world.setBlock(x, y, z, Blocks.torch, TORCH_META_EAST, 3);
			}
			else if(event.face == EVENT_FACE_WEST
					&& event.world.isSideSolid(clickedBlockX, clickedBlockY, clickedBlockZ, ForgeDirection.WEST)) {
				event.world.setBlock(x, y, z, Blocks.torch, TORCH_META_WEST, 3);
			}
			else if(event.face == EVENT_FACE_NORTH
					&& event.world.isSideSolid(clickedBlockX, clickedBlockY, clickedBlockZ, ForgeDirection.NORTH)) {
				event.world.setBlock(x, y, z, Blocks.torch, TORCH_META_NORTH, 3);
			}
			else if(event.face == EVENT_FACE_SOUTH
					&& event.world.isSideSolid(clickedBlockX, clickedBlockY, clickedBlockZ, ForgeDirection.SOUTH)) {
				event.world.setBlock(x, y, z, Blocks.torch, TORCH_META_SOUTH, 3);
			}
			else if(Blocks.torch.canPlaceBlockAt(event.world, x, y, z)){ //右クリックした向きと実際に設置できる向きが違う場合。
				event.world.setBlock(x, y, z, Blocks.torch);  //BlockTorchのonBlockPlaced()メソッドによって適切な向きにされる
			}
			else {
				hasPlacedTorch = false;
			}
			
			if(hasPlacedTorch) {
				itemStack.stackSize -= 1; //松明を消費
			
				event.setResult(Result.DENY);
				return;
			}
		}

		event.setResult(Result.DEFAULT);
		return;
		
	}
}
