package com.cmdr_johnalex;

import java.util.ArrayList;

import com.cmdr_johnalex.Utils.Pair;

// TODO: Implement Item class. Do it somewhere else.
class Item
{
}

class PlayerData
{
    String Name;
    int Age;
    Pair<String, String> Pronouns;
    int MaxHealth;
    int Health;

    int Strength; // STR. Attack Damage/Chance
    int Dexterity; // DEX. Defense Chance
    int Charisma; // CHA. Persuasion/Retreat Chance

    // TODO: When getting stats, loop through all equipped items and add their bonus stats to the player's stats.
    ArrayList<Item> Inventory;
}

public class Player
{
    PlayerData Data;

    public void Initialize()
    {
        Data = new PlayerData();
        Data.Name = "John";
        Data.Age = 25;
        Data.Pronouns = new Pair<>("he", "him");
        Data.Health = Data.MaxHealth;

        Data.Strength = 10;
        Data.Dexterity = 10;
        Data.Charisma = 10;

        Data.Inventory = new ArrayList<Item>();
    }

    public void Shutdown()
    {
    }
}
