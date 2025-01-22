package com.cmdr_johnalex;

import java.util.ArrayList;

import com.cmdr_johnalex.Items.Item;
import com.cmdr_johnalex.Utils.Input;
import com.cmdr_johnalex.Utils.Pair;

/**
 * Enum for the four cardinal directions.
 */
enum Direction
{
    North,
    East,
    South,
    West
}

/**
 * The PlayerData class represents the player's data.
 */
class PlayerData
{
    String Name;
    final int MaxHealth = 100;
    int Health;

    int Strength; // STR. Attack Damage/Chance
    int Dexterity; // DEX. Defense Chance
    int Charisma; // CHA. Persuasion/Retreat Chance

    Pair<Integer, Integer> Location;

    int Gold;

    ArrayList<Item> Inventory;
}

/**
 * The Player class represents the player character in the game.
 */
public class Player
{
    // TODO: Make this private and use getters/setters.
    PlayerData Data;

    /**
     * Initializes the player with default values.
     */
    public void Initialize()
    {
        Data = new PlayerData();
        Data.Name = "Erin";
        Data.Health = Data.MaxHealth;

        Data.Strength = 10;
        Data.Dexterity = 10;
        Data.Charisma = 10;

        Data.Location = new Pair<>(0, 0);

        Data.Gold = 0;
        Data.Inventory = new ArrayList<Item>();
    }

    /**
     * Shuts down the player.
     */
    public void Shutdown()
    {
    }

    /**
     * Attempts to move the player in the specified direction.
     *
     * @param direction The direction to move.
     * @return True if the player successfully moved, false if they hit a wall.
     */
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

    /**
     * Adds an item to the player's inventory.
     *
     * @param item The item to add.
     */
    public void AddItem(Item item)
    {
        Data.Inventory.add(item);
    }

    /**
     * Removes an item from the player's inventory.
     *
     * @param item The item to remove.
     */
    public void RemoveItem(Item item)
    {
        Data.Inventory.remove(item);
    }

    /**
     * Adds gold to the player's inventory.
     *
     * @param amount The amount of gold to add.
     */
    public void AddGold(int amount)
    {
        Data.Gold += amount;
    }

    /**
     *Removes gold from the player's inventory.

     @param amount The amount of gold to remove.
     */
    public void RemoveGold(int amount)
    {
        Data.Gold -= amount;
    }

    /**
     * Returns the player's total strength. Includes any modifying items.
     *
     * @returns The player's total strength.
     */
    public int GetStrength()
    {
        int bonus = Data.Strength;
        for (Item item : Data.Inventory)
        {
            bonus += item.Strength;
        }
        return bonus;
    }

    /**
     * Returns the player's total dexterity. Includes any modifying items.
     *
     * @returns The player's total dexterity.
     */
    public int GetDexterity()
    {
        int bonus = Data.Dexterity;
        for (Item item : Data.Inventory)
        {
            bonus += item.Dexterity;
        }
        return bonus;
    }

    /**
     * Returns the player's total charisma. Includes any modifying items.
     *
     * @returns The player's total charisma.
     */
    public int GetCharisma()
    {
        int bonus = Data.Charisma;
        for (Item item : Data.Inventory)
        {
            bonus += item.Charisma;
        }
        return bonus;
    }

    /**
     * Gives the player trap damage.
     */
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

    /**
     * Heals the player fully.
     */
    public void Heal()
    {
        Data.Health = Data.MaxHealth;
    }

    /**
     * Displays the player's inventory and handles any interactions.
     */
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
