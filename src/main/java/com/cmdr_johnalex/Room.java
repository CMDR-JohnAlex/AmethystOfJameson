package com.cmdr_johnalex;

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

    public void Update()
    {
        switch (Type)
        {
        case Empty:
            break;
        case Gold:
            if (GoldAmount == 0)
            {
                Type = RoomType.Empty;
                ContentDescription = "There was once gold here.";
            }
            break;
        case Item:
            // TODO: Check if item was picked up.
            break;
        case Monster:
            // TODO: Check if monster was defeated.
            break;
        }
    }
}
