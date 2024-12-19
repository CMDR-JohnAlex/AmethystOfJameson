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
    PlayerData data;

    public void Initialize()
    {
        data = new PlayerData();
        data.Name = "John";
        data.Age = 25;
        data.Pronouns = new Pair<>("he", "him");
        data.Health = data.MaxHealth;

        data.Strength = 10;
        data.Dexterity = 10;
        data.Charisma = 10;

        data.Inventory = new ArrayList<Item>();
    }

    public void Shutdown()
    {
    }
}
