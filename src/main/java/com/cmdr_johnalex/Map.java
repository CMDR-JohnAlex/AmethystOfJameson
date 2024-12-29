package com.cmdr_johnalex;

import com.cmdr_johnalex.Utils.Pair;

public class Map
{
    private Room[][] CurrentMap;

    public void Initialize()
    {
    }

    public void Shutdown()
    {
    }

    public void GenerateMap()
    {
        CurrentMap = new Room[Settings.GetMapHeight()][Settings.GetMapWidth()];

        for (int i = 0; i < CurrentMap.length; i++)
        {
            for (int j = 0; j < CurrentMap[i].length; j++)
            {
                // TODO: Randomize room type + contents.
                CurrentMap[i][j] = new Room(RoomType.Empty);
                System.out.println("i: " + i + " j: " + j + " Type: " + CurrentMap[i][j].Type.toString() + " Description: " + CurrentMap[i][j].RoomDescription);
            }
        }

        // TODO: Randomly overwrite one room to have the Amethyst.
    }

    // TODO: Display map.
    public void DisplayMap()
    {
    }

    public Room GetRoom(int x, int y)
    {
        return CurrentMap[y][x];
    }

    public Room GetRoom(Pair<Integer, Integer> location)
    {
        return GetRoom(location.first, location.second);
    }
}
