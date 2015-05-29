package fox.spiteful.theism.deities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

import java.util.LinkedHashMap;

public class PantheonNetwork extends WorldSavedData {
    public LinkedHashMap<String, String> gods;

    public PantheonNetwork(String key){
        super(key);
        gods = new LinkedHashMap<String, String>();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        int total = nbttagcompound.getInteger("total");
        for (int count = 0;count < total;count++) {
            gods.put(nbttagcompound.getString("domain" + count), nbttagcompound.getString("name" + count));
        }
    }
    @Override
    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.setInteger("total", gods.size());
        int count = 0;
        for(String domain : gods.keySet()){
            nbttagcompound.setString("domain" + count, domain);
            nbttagcompound.setString("name" + count, gods.get(domain));
            count++;
        }
    }
}
