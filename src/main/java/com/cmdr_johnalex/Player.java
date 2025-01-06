package com.cmdr_johnalex;

import java.util.ArrayList;

import com.cmdr_johnalex.Items.Item;
import com.cmdr_johnalex.Utils.Pair;

enum Direction
{
    North,
    East,
    South,
    West
}

class PlayerData
{
    String Name;
    int Age;
    Pair<String, String> Pronouns;
    final int MaxHealth = 100;
    int Health;

    int Strength; // STR. Attack Damage/Chance
    int Dexterity; // DEX. Defense Chance
    int Charisma; // CHA. Persuasion/Retreat Chance

    Pair<Integer, Integer> Location;

    int Gold;
    // TODO: When getting stats, loop through all equipped items and add their bonus stats to the player's stats.
    ArrayList<Item> Inventory;
}

public class Player
{
    PlayerData Data;

    public void Initialize()
    {
        Data = new PlayerData();
        Data.Name = "Erin";
        Data.Age = 25;
        Data.Pronouns = new Pair<>("they", "them");
        Data.Health = Data.MaxHealth;

        Data.Strength = 10;
        Data.Dexterity = 10;
        Data.Charisma = 10;

        Data.Location = new Pair<>(0, 0);

        Data.Gold = 0;
        Data.Inventory = new ArrayList<Item>();
    }

    public void Shutdown()
    {
    }

    // Moves the player in the given direction. Returns true if the player was able to move, false otherwise.
    public Boolean Move(Direction direction)
    {
        switch (direction)
        {
        case North:
            if (Data.Location.second > 0)
            {
                Data.Location.second--;
                return true;
            }
            break;
        case East:
            if (Data.Location.first < Settings.GetMapWidth() - 1)
            {
                Data.Location.first++;
                return true;
            }
            break;
        case South:
            if (Data.Location.second < Settings.GetMapHeight() - 1)
            {
                Data.Location.second++;
                return true;
            }
            break;
        case West:
            if (Data.Location.first > 0)
            {
                Data.Location.first--;
                return true;
            }
            break;
        }

        return false;
    }
}
