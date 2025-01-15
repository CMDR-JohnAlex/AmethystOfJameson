package com.cmdr_johnalex;

import com.cmdr_johnalex.Items.Amethyst;
import com.cmdr_johnalex.Items.Item;
import com.cmdr_johnalex.Items.ItemFactory;
import com.cmdr_johnalex.Utils.FileManager;
import com.cmdr_johnalex.Utils.Rand;

// Rooms have only four possibilities.
enum RoomType
{
    Empty,
    Gold,
    Item,
    Trap,
    Healing,
    Monster;

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

// Contains all the data for a single room
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
            ContentDescription = "There is an item here."; // Traps are disguised as items.
        case Healing:
            ContentDescription = "There is a healing item here.";
            break;
        case Monster:
            ContentDescription = "There is a monster here.";
            // TODO: Random monster.
            break;
        }
    }

    // Update the room since the player has interacted with it. Will clear out the room.
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
