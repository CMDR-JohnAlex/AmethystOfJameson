package com.cmdr_johnalex;

import com.cmdr_johnalex.Items.Item;

// Rooms have only four possibilities.
enum RoomType
{
    Empty,
    Gold,
    Item,
    Monster;

    // TODO: Map display.
    public String ToMapString()
    {
        switch (this)
        {
        default:
            return "";
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

    public int GoldAmount;
    public Item Item;
    public String Monster; // TODO: Replace with Monster class.

    Room(RoomType type)
    {
        Type = type;
        Description = "This is a room"; // TODO: Load randomly from a file.

        switch (Type)
        {
        case Empty:
            ContentDescription = "There is nothing here.";
            break;
        case Gold:
            ContentDescription = "There is some gold here.";
            // TODO: Random gold amount.
            GoldAmount = 7;
            break;
        case Item:
            ContentDescription = "There is an item here.";
            // TODO: Random item.
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
