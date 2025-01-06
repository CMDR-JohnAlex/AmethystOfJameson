package com.cmdr_johnalex;

import com.cmdr_johnalex.Utils.Pair;
import com.cmdr_johnalex.Utils.Rand;

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
        Rand.SetSeed(Settings.GetSeed());
        CurrentMap = new Room[Settings.GetMapHeight()][Settings.GetMapWidth()];

        for (int i = 0; i < CurrentMap.length; i++)
        {
            for (int j = 0; j < CurrentMap[i].length; j++)
            {
                int random = Rand.Range(0, 99);
                RoomType randomType;

                if (random < 10)
                    randomType = RoomType.Empty;
                else if (random < 20)
                    randomType = RoomType.Gold;
                else if (random < 30)
                    randomType = RoomType.Gold;
                else if (random < 40)
                    randomType = RoomType.Item;
                else if (random < 50)
                    randomType = RoomType.Empty;
                else if (random < 60)
                    randomType = RoomType.Gold;
                else if (random < 70)
                    randomType = RoomType.Empty;
                else if (random < 80)
                    randomType = RoomType.Gold;
                else if (random < 90)
                    randomType = RoomType.Item;
                else
                    randomType = RoomType.Empty;

                CurrentMap[i][j] = new Room(randomType);
                System.out.println("i: " + i + " j: " + j + " Type: " + CurrentMap[i][j].Type.toString() + " Description: " + CurrentMap[i][j].Description);
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
