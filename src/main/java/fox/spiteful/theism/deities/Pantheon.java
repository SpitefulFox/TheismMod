package fox.spiteful.theism.deities;

import fox.spiteful.theism.api.ReligionHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import java.util.LinkedHashMap;
import java.util.Random;

public class Pantheon {

    public static LinkedHashMap<String, String> gods = new LinkedHashMap<String, String>();
    public static Random randy = new Random();

    public static void deify(){

        ReligionHandler.registerDeity("fire", new GodFire());
    }

    public static void discoverGod(String domain, String name){
        World world = MinecraftServer.getServer().worldServers[0];
        PantheonNetwork panth = (PantheonNetwork)world.loadItemData(PantheonNetwork.class, "pantheon");
        if(panth == null){
            panth = new PantheonNetwork("pantheon");
            world.setItemData("pantheon", panth);
        }
        gods.put(domain, name);
        panth.gods = gods;
        panth.markDirty();
    }
}
