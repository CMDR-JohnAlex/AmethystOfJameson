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
    public String RoomDescription;
    // TODO: Add more data about a room. Room contents.

    Room(RoomType type)
    {
        Type = type;
        RoomDescription = "This is a room"; // TODO: Load randomly from a file.
    }
}
