package com.cmdr_johnalex;

import java.util.ArrayList;

import com.cmdr_johnalex.Items.Item;
import com.cmdr_johnalex.Utils.Pair;
import com.cmdr_johnalex.Utils.Input;

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
        // Maps from maxDamage at 0 DEX to 0 damage at dexterityForMinDamage.
        // The damage is then clamped between 0 and maxDamage so that you don't get more than maxDamage damage, or get negative damage if your DEX is above dexterityForMinDamage.
        int maxDamage = 50;
        int dexterityForMinDamage = 30;
        int damage = Math.clamp(-(maxDamage/dexterityForMinDamage) * Data.Dexterity + maxDamage, 0, maxDamage);
        Data.Health -= damage;
    }

    public void Heal()
    {
        Data.Health = Data.MaxHealth;
    }

    public void DisplayInventory()
    {
        // Display all items in the player's inventory with a number. Player can select the number to view that item's description.
        System.out.println("Inventory:");
        for (int i = 0; i < Data.Inventory.size(); i++)
        {
            System.out.println("  " + (i + 1) + ". " + Data.Inventory.get(i).Name);
        }

        System.out.println("0. Exit");

        System.out.println("\nSelect a number for the item you wish to view, or press 0 to exit.");
        int input = Input.GetInt();
        System.out.println();

        if (input == 0)
        {
            System.out.println("Closing your bag...");
        }
        else if (input > 0 && input <= Data.Inventory.size())
        {
            Item currentItem = Data.Inventory.get(input - 1);
            System.out.println(currentItem.Name + ":");
            System.out.println("  " + currentItem.Description);
            System.out.println("  " + "You believe this item would be worth " + currentItem.Value + " gold.");
        }
        else
        {
            System.out.println("Invalid input. Closing your bag...");
        }
    }
}
