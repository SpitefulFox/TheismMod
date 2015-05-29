package fox.spiteful.theism.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.theism.api.ReligionHandler;
import fox.spiteful.theism.deities.Pantheon;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemHolyBook extends Item{

    private String domain;
    private IIcon icon;
    private String iconFile;

    public ItemHolyBook(String type, String pic){
        super();
        domain = type;
        iconFile = pic;
        setUnlocalizedName("HolyBook." + domain);
        maxStackSize = 1;
        GameRegistry.registerItem(this, "HolyBook" + domain);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister ir) {
        this.icon = ir.registerIcon("theism:" + iconFile);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int par1) {
        return this.icon;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if(player.isSneaking()) {
            if (!world.isRemote) {
                if(ReligionHandler.getReligion(player).equals("")) {
                    ReligionHandler.setReligion(player, domain);
                    if(!Pantheon.gods.containsKey(domain)){
                        ReligionHandler.setFavor(player, 100);
                    }
                    player.addChatMessage(new ChatComponentText("You are now a follower of " + ReligionHandler.pantheon.get(domain).getName() + "!"));
                }
            }
            player.swingItem();
        }
        return stack;
    }
}
