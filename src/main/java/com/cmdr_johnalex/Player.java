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

    ArrayList<Item> Inventory;
}

public class Player
{
    // TODO: Make this private and use getters/setters.
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

    public void AddItem(Item item)
    {
        Data.Inventory.add(item);
    }

    public void RemoveItem(Item item)
    {
        Data.Inventory.remove(item);
    }

    public void AddGold(int amount)
    {
        Data.Gold += amount;
    }

    public void RemoveGold(int amount)
    {
        Data.Gold -= amount;
    }

    // Returns the player's total strength, including bonuses from items.
    public int GetStrength()
    {
        int bonus = Data.Strength;
        for (Item item : Data.Inventory)
        {
            bonus += item.Strength;
        }
        return bonus;
    }

    // Returns the player's total dexterity, including bonuses from items.
    public int GetDexterity()
    {
        int bonus = Data.Dexterity;
        for (Item item : Data.Inventory)
        {
            bonus += item.Dexterity;
        }
        return bonus;
    }

    // Returns the player's total charisma, including bonuses from items.
    public int GetCharisma()
    {
        int bonus = Data.Charisma;
        for (Item item : Data.Inventory)
        {
            bonus += item.Charisma;
        }
        return bonus;
    }

    public void TakeTrapDamage()
    {
        // Linear mapping of damage based on the player's stats.
        // Maps from 10 damage at 0 DEX to 0 damage at 50 DEX.
        // The damage is then clamped between 0 and 10 so that you don't get more than 10 damage, or get negative damage if your DEX is above 50.
        int damage = Math.clamp(-(1/5) * Data.Dexterity + 10, 0, 10);
        Data.Health -= damage;
    }

    public void Heal()
    {
        Data.Health = Data.MaxHealth;
    }
}
