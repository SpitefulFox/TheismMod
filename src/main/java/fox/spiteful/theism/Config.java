package fox.spiteful.theism;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

import java.io.File;

public class Config {

    public static void configurate(File targ){
        Configuration conf = new Configuration(targ);

        try {

        }
        catch(Exception e){
            Lumberjack.log(Level.ERROR, e, "Theism was unable to load its config file!");
        }

    }
}
