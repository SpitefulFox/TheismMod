package fox.spiteful.theism.api;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

public class FaithNetwork extends WorldSavedData {
    public int favor;
    public String domain;

    public FaithNetwork(String key){
        super(key);
        favor = 0;
        domain = "";
    }

    @Override
    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        favor = nbttagcompound.getInteger("favor");
        domain = nbttagcompound.getString("domain");
    }
    @Override
    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.setInteger("favor", favor);
        nbttagcompound.setString("domain", domain);
    }
}
