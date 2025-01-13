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

                // TODO: Oh god, do something better than THIS. What were you thinking?
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

                CurrentMap[i][j] = new Room(randomType, false);
                System.out.println("i: " + i + " j: " + j + " Type: " + CurrentMap[i][j].Type.toString() + " Description: " + CurrentMap[i][j].Description);
            }
        }

        // Randomly overwrite one room to have the Amethyst.
        int amethystX = Rand.Range(0, CurrentMap.length - 1);
        int amethystY = Rand.Range(0, CurrentMap[amethystX].length - 1);
        CurrentMap[amethystX][amethystY] = new Room(RoomType.Item, true);
    }

    public void DisplayMap(Pair<Integer, Integer> playerLocation)
    {
        System.out.print("X |");
        for (int x = 0; x < Settings.GetMapWidth(); x++)
        {
            System.out.print("    " + (char)(65 + x) + "    |");
        }
        System.out.println();

        System.out.print("- |");
        for (int x = 0; x < Settings.GetMapWidth(); x++)
        {
            System.out.print(" ------- |");
        }
        System.out.println();

        for (int i = 0; i < CurrentMap.length; i++)
        {
            System.out.print(i + " | ");
            for (int j = 0; j < CurrentMap[i].length; j++)
            {
                if (playerLocation.first == j && playerLocation.second == i)
                    System.out.print("\033[0;1m\033[0;4m* YOU *\033[0;0m" + " | ");
                else if (!CurrentMap[i][j].Visited && Settings.GetHideUnvisitedRooms())
                    System.out.print("UNKNOWN" + " | ");
                else
                    System.out.print(CurrentMap[i][j].Type.ToMapString() + " | ");
            }
            System.out.println();
        }

        System.out.print("---");
        for (int x = 0; x < Settings.GetMapWidth(); x++)
        {
            System.out.print("----------");
        }
        System.out.println();
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
