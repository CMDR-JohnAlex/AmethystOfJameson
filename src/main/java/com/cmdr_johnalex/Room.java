package com.cmdr_johnalex;

import com.cmdr_johnalex.Items.Amethyst;
import com.cmdr_johnalex.Items.Item;
import com.cmdr_johnalex.Items.ItemFactory;
import com.cmdr_johnalex.Utils.FileManager;
import com.cmdr_johnalex.Utils.Rand;

// Enum representing the different room types.
enum RoomType
{
    Empty,
    Gold,
    Item,
    Trap,
    Healing,
    Monster;

    /**
     * Returns a string of the room type for the map to display.
     *
     * @return A string formatted for a map to display.
     */
    public String ToMapString()
    {
        switch (this)
        {
        case Empty:
            return " EMPTY ";
        case Gold:
            return " GOLD  ";
        case Item:
            return " ITEM  ";
        case Trap:
            return " TRAP  ";
        case Healing:
            return "HEALING";
        case Monster:
            return "MONSTER";
        default:
            return "       ";
        }
    }
}

/**
 * The Room class represents a single room in the game map.
 * Each room has a type, description, and content.
 * The content can range from different items, gold, traps, or nothing.
 */
public class Room
{
    public RoomType Type;
    // NOTE: Storing an entire string that is probably a duplicate for another room is a waste of memory. Now imagine if you had a million rooms...
    public String Description;
    public String ContentDescription;
    public Boolean Visited;

    public int GoldAmount;
    public Item Item;
    public String Monster; // TODO: Replace with Monster class.

    /**
     * Initializes the room given a type and wether or not it is the amethyst room.
     * The room will have a random description and content based on the given type.
     *
     * @param type The type of room.
     * @param isAmethyst True if the room is the amethyst room.
     */
    Room(RoomType type, Boolean isAmethyst)
    {
        Type = type;
        Description = FileManager.ReadRandomLine("com/cmdr_johnalex/Data/RoomDescription.txt");
        Visited = false;

        /*
        Mmm, yes. I'd like one string in each room that is stored in memory 24/7 that may be a
        duplicate of another string in another room please. Oh what's that? You want to store a
        million rooms? Sure, let's waste a million strings in memory. That's a great idea. I'm
        sure the garbage collector will love that. Oh? What's this? Whenever you try to get a
        description, it reads an entire file, chooses a random line, stores it, closes and then
        repeats for the next room? Oh, that's a great idea. I'm sure that won't slow down the
        game at all. I'm sure the player will love waiting for the game to load every room.

        (I'm a little unhappy with the lack of optimization. I should have planned this part out better.)

        TODO: Optimize this.
        */

        switch (Type)
        {
        case Empty:
            ContentDescription = "There is nothing here.";
            break;
        case Gold:
            ContentDescription = "There is some gold here.";
            GoldAmount = Rand.Range(1, 32);
            break;
        case Item:
            ContentDescription = "There is an item here.";
            if (isAmethyst)
                Item = new Amethyst();
            else
                Item = ItemFactory.CreateRandomItem();
            break;
        case Trap:
            // Traps can be disguised.
            switch (Rand.Range(1, 3))
            {
            case 1:
                ContentDescription = "There is an item here.";
                break;
            case 2:
                ContentDescription = "There is some gold here.";
                break;
            case 3:
                ContentDescription = "There is something odd here.";
                break;
            }
            break;
        case Healing:
            ContentDescription = "There is a healing item here.";
            break;
        case Monster:
            ContentDescription = "There is a monster here.";
            // TODO: Random monster.
            break;
        }
    }

    /**
     * Updates the room's content description.
     *
     * This function is called when the player has interacted with a room,
     * and taken the room contents.
     */
    public void Update()
    {
        switch (Type)
        {
        case Empty:
            break;
        case Gold:
            ContentDescription = "There was once gold here.";
            break;
        case Item:
            ContentDescription = "There was once an item here.";
            break;
        case Trap:
            ContentDescription = "There was once a trap here.";
            break;
        case Healing:
            ContentDescription = "There was once a healing item here.";
            break;
        case Monster:
            ContentDescription = "There was once a " + "*insert monster*" + " here.";
            break;
        }

        Type = RoomType.Empty;
    }
}
