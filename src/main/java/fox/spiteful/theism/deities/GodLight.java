package fox.spiteful.theism.deities;

import net.minecraft.entity.player.EntityPlayer;

public class GodLight {
    public final String[] names = {
            "Aten", "Nuggan", "Pholtus", "Om"
    };

    public String getDomain(){
        return "light";
    }

    public String getName(){
        if(Pantheon.gods.get("light") == null)
            Pantheon.discoverGod("light", names[Pantheon.randy.nextInt(names.length)]);
        return Pantheon.gods.get("light");
    }

    public void smite(EntityPlayer player){

    }

    public void answerPrayer(EntityPlayer player){

    }
}