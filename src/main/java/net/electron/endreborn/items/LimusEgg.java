package net.electron.endreborn.items;

import net.electron.endreborn.EndReborn;
import net.electron.endreborn.mobs.Mobs;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

public class LimusEgg extends LimusEggBase {
    public LimusEgg() {
        super(Mobs.LIMUS, new Item.Settings().group(EndReborn.END_GROUP));
    }

}
