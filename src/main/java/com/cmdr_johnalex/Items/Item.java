package com.cmdr_johnalex.Items;

/**
 * The Item class represents an item that can be found in the game.
 */
public abstract class Item
{
    public final String Name;
    public final String Description;
    public final String Article;
    public final int Value;

    // Stat modifiers. 0 is no change, while positive is a bonus and negative is a penalty.
    public final int Strength;
    public final int Dexterity;
    public final int Charisma;

    /**
     * Initializes the item with the given values.
     *
     * @param name The name of the item.
     * @param description The description of the item.
     * @param article The article of the item.
     * @param value The value of the item.
     */
    public Item(String name, String description, String article, int value)
    {
        Name = name;
        Description = description;
        Article = article;
        Value = value;
        Strength = 0;
        Dexterity = 0;
        Charisma = 0;
    }

    /**
     * Initializes the item with the given values.
     *
     * @param name The name of the item.
     * @param description The description of the item.
     * @param article The article of the item.
     * @param value The value of the item.
     * @param strength The strength modifier of the item.
     * @param dexterity The dexterity modifier of the item.
     * @param charisma The charisma modifier of the item.
     */
    public Item(String name, String description, String article, int value, int strength, int dexterity, int charisma)
    {
        Name = name;
        Description = description;
        Article = article;
        Value = value;
        Strength = strength;
        Dexterity = dexterity;
        Charisma = charisma;
    }
}
