package micdoodle8.mods.galacticraft.core.blocks;

import java.util.List;
import java.util.Random;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Copyright 2012-2013, micdoodle8
 * 
 * All rights reserved.
 * 
 */
public class GCCoreBlock extends Block
{
    Icon[] iconBuffer;

    protected GCCoreBlock(int id, String assetName)
    {
        super(id, Material.rock);
        this.setHardness(1.0F);
        this.setTextureName(GalacticraftCore.TEXTURE_PREFIX + assetName);
        this.setUnlocalizedName(assetName);
    }

    @Override
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return GalacticraftCore.galacticraftTab;
    }

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        this.iconBuffer = new Icon[7];
        this.iconBuffer[0] = iconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "deco_aluminium_2");
        this.iconBuffer[1] = iconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "deco_aluminium_4");
        this.iconBuffer[2] = iconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "deco_aluminium_1");
        this.iconBuffer[3] = iconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "deco_aluminium_4");
        this.iconBuffer[4] = iconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "oreCopper");
        this.iconBuffer[5] = iconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "oreTin");
        this.iconBuffer[6] = iconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "oreAluminum");
    }

    @Override
    public Icon getIcon(int side, int meta)
    {
        switch (meta)
        {
        case 3:
            switch (side)
            {
            case 0:
                return this.iconBuffer[1];
            case 1:
                return this.iconBuffer[0];
            default:
                return this.iconBuffer[2];
            }
        case 4:
            return this.iconBuffer[3];
        case 5:
            return this.iconBuffer[4];
        case 6:
            return this.iconBuffer[5];
        case 7:
            return this.iconBuffer[6];
        default:
            return meta < this.iconBuffer.length ? this.iconBuffer[meta] : this.iconBuffer[0];
        }
    }

    @Override
    public int idDropped(int meta, Random random, int par3)
    {
        switch (meta)
        {
        default:
            return this.blockID;
        }
    }

    @Override
    public int damageDropped(int meta)
    {
        switch (meta)
        {
        default:
            return meta;
        }
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random)
    {
        switch (meta)
        {
        default:
            return 1;
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 3; var4 < 8; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}
