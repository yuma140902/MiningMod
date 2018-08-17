package yuma140902.miningmod.blocks;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import yuma140902.miningmod.MiningMod;

public class CompressCobblestoneBlock extends Block {
	public static final int MAX = 16;

	public CompressCobblestoneBlock() {
		super(Material.rock);
		this.setCreativeTab(MiningMod.MOD_CREATIVETAB);
		this.setHardness(2.0F);
		this.setResistance(30.0F);
		this.setStepSound(Block.soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
		this.setLightLevel(0.0F);
	}
	
	private IIcon[] iicon = new IIcon[MAX];
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		for(int i = 0; i < MAX; ++i) {
			this.iicon[i] = register.registerIcon(getTextureName() + "-" + i);
		}
	}
	
	//向きがsideでメタデータがmetaのアイコン(テクスチャ)を得るためのメソッドをオーバーライド
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return iicon[meta];
	}
	
	//クリエイティブタブにデータ値違いのものを追加する処理
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list) {
		for(int i = 0; i < MAX; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
}
