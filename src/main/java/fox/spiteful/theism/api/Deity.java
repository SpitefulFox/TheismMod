package fox.spiteful.theism.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public abstract class Deity {

    public abstract String getDomain();

    public abstract String getName();

    public void onUpdate(EntityPlayer player){}

    public abstract void smite(EntityPlayer player);

    public abstract void answerPrayer(EntityPlayer player);

    public void onGetHurt(LivingHurtEvent event, EntityPlayer player){}

}
