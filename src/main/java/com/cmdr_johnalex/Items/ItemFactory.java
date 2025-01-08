package com.cmdr_johnalex.Items;

import com.cmdr_johnalex.Utils.Rand;

public class ItemFactory
{
    // NOTE: This needs to be updated every time a new item is added.
    // TODO: Implement a way to automatically add new items.
    private static final Class<? extends Item>[] ItemClasses = new Class[]
    {
        //TestItem.class,
        GlovesOfCombat.class,
        GoldenRing.class,
        PendantOfProtection.class,
        RingOfEvasion.class,
        RuffledPuffyHat.class,
        TopazOfTyler.class,
        TressymFeather.class,
        UsedFlare.class
    };

    public static Item CreateRandomItem()
    {
        int index = Rand.Range(0, ItemClasses.length - 1);
        try
        {
            return ItemClasses[index].getDeclaredConstructor().newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
