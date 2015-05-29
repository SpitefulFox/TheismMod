package fox.spiteful.theism;

import cpw.mods.fml.common.event.*;
import fox.spiteful.theism.deities.Pantheon;
import fox.spiteful.theism.deities.PantheonNetwork;
import fox.spiteful.theism.items.DivineItems;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;

@Mod(modid = "Theism", name = "Theism")
public class Theism {
    @Instance("Theism")
    public static Theism instance;

    @EventHandler
    public void separation(FMLPreInitializationEvent event) {
        instance = this;
        Config.configurate(event.getSuggestedConfigurationFile());
        Pantheon.deify();
        DivineItems.itemize();
    }

    @EventHandler
    public void liminal(FMLInitializationEvent event) {
        //MinecraftForge.EVENT_BUS.register(new FMEventHandler());
    }

    @EventHandler
    public void aggregation(FMLPostInitializationEvent event) {

    }

    @EventHandler
    public void genesis(FMLServerStartingEvent event){
        World world = event.getServer().worldServers[0];
        PantheonNetwork panth = (PantheonNetwork)world.loadItemData(PantheonNetwork.class, "pantheon");
        if(panth == null){
            panth = new PantheonNetwork("pantheon");
            world.setItemData("pantheon", panth);
        }
        else {
            Pantheon.gods.putAll(panth.gods);
        }
    }

}