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

public class ItemPrayerBeads extends Item{

    private IIcon icon;

    public ItemPrayerBeads(){
        super();
        setUnlocalizedName("PrayerBeads");
        maxStackSize = 1;
        GameRegistry.registerItem(this, "PrayerBeads");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister ir) {
        this.icon = ir.registerIcon("theism:prayerbeads");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int par1) {
        return this.icon;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            String religion = ReligionHandler.getReligion(player);
            if(!religion.equals("")) {
                int favor = ReligionHandler.getFavor(player);
                String god = ReligionHandler.pantheon.get(religion).getName();
                player.addChatMessage(new ChatComponentText("You have " + favor + " favor with " + god));
            }
            else
                player.addChatMessage(new ChatComponentText("You don't pray to gods."));
        }
        player.swingItem();
        return stack;
    }
}
