package com.cmdr_johnalex.Items;

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
