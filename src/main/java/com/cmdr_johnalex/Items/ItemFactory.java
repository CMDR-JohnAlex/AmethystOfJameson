package com.cmdr_johnalex.Items;

import java.util.Arrays;
import java.util.List;

import com.cmdr_johnalex.Utils.Rand;

/**
 * The ItemFactory class provides a way to create random items.
 */
public class ItemFactory
{
    // NOTE: This needs to be updated every time a new item is added.
    // TODO: Implement a way to automatically add new items.
    private static final List<Class<? extends Item>> ItemClasses = Arrays.asList(
        //TestItem.class,
        AncientBook.class,
        CrystalBallNegative.class,
        CrystalBallPositive.class,
        CursedAmulet.class,
        GlovesOfCombat.class,
        GoldenRing.class,
        HauntedRing.class,
        IronShield.class,
        ModelShip.class,
        PendantOfProtection.class,
        RingOfEvasion.class,
        RuffledPuffyHat.class,
        SilverSword.class,
        TopazOfTyler.class,
        TressymFeather.class,
        UsedFlare.class
    );

    /**
     * Creates a random item.
     *
     * @return A random item that is derived from the Item class.
     */
    public static Item CreateRandomItem()
    {
        int index = Rand.Range(0, ItemClasses.size() - 1);
        try
        {
            return ItemClasses.get(index).getDeclaredConstructor().newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
