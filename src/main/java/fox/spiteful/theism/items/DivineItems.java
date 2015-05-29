package fox.spiteful.theism.items;

import net.minecraft.item.Item;

public class DivineItems {

    public static Item prayerBeads;
    public static Item fireBook;

    public static void itemize(){
        prayerBeads = new ItemPrayerBeads();
        fireBook = new ItemHolyBook("fire", "firetablets");
    }
}
