package fox.spiteful.theism.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import java.util.LinkedHashMap;

public class ReligionHandler {
    public static LinkedHashMap<String, Deity> pantheon = new LinkedHashMap<String, Deity>();

    public static void registerDeity(String domain, Deity god){
        pantheon.put(domain, god);
    }

    public static int getFavor(EntityPlayer player){

        FaithNetwork faith = getData(player);
        return faith.favor;
    }

    public static void setFavor(EntityPlayer player, int favor){
        FaithNetwork faith = getData(player);
        faith.favor = favor;
        faith.markDirty();
    }

    public static String getReligion(EntityPlayer player){
        FaithNetwork faith = getData(player);
        //if(!pantheon.containsKey(faith.domain)) {
            //faith.domain = "";
            //faith.markDirty();
        //}
        return faith.domain;
    }

    public static void setReligion(EntityPlayer player, String religion){
        FaithNetwork faith = getData(player);
        faith.domain = religion;
        faith.markDirty();
    }

    private static FaithNetwork getData(EntityPlayer player){
        World world = MinecraftServer.getServer().worldServers[0];
        FaithNetwork faith = (FaithNetwork)world.loadItemData(FaithNetwork.class, player.getDisplayName() + "_faith");

        if(faith == null){
            faith = new FaithNetwork(player.getDisplayName());
            world.setItemData(player.getDisplayName() + "_faith", faith);
        }

        return faith;
    }

}