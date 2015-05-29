package fox.spiteful.theism.deities;

import fox.spiteful.theism.api.Deity;
import net.minecraft.entity.player.EntityPlayer;

public class GodFire extends Deity{
    public final String[] names = {
        "Kagutsuchi", "Prometheus", "Imix", "Vulcan", "Surtr", "Kossuth"
    };

    public String getDomain(){
        return "fire";
    }

    public String getName(){
        if(Pantheon.gods.get("fire") == null)
            Pantheon.discoverGod("fire", names[Pantheon.randy.nextInt(names.length)]);
        return Pantheon.gods.get("fire");
    }

    public void smite(EntityPlayer player){

    }

    public void answerPrayer(EntityPlayer player){

    }
}
