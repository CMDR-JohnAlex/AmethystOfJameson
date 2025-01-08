package com.cmdr_johnalex;

import com.cmdr_johnalex.Items.Amethyst;
import com.cmdr_johnalex.Items.Item;
import com.cmdr_johnalex.Items.ItemFactory;
import com.cmdr_johnalex.Utils.Rand;

// Rooms have only four possibilities.
enum RoomType
{
    Empty,
    Gold,
    Item,
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
        Description = "This is a room"; // TODO: Load randomly from a file.
        Visited = false;

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
            GoldAmount = 0;
            ContentDescription = "There was once gold here.";
            break;
        case Item:
            ContentDescription = "There was once an item here.";
            break;
        case Monster:
            ContentDescription = "There was once a " + "*insert monster*" + " here.";
            break;
        }

        Type = RoomType.Empty;
    }
}
