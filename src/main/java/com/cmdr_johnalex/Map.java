package com.cmdr_johnalex;

import com.cmdr_johnalex.Utils.Pair;
import com.cmdr_johnalex.Utils.Rand;

/**
 * The Map class manages the game map, including its room generation and states.
 */
public class Map
{
    private Room[][] CurrentMap;

    /**
     * Initializes the map.
     */
    public void Initialize()
    {
    }

    /**
     * Shuts down the map.
     */
    public void Shutdown()
    {
    }

    /**
     * Generates a new map based on the current settings.
     */
    public void GenerateMap()
    {
        Rand.SetSeed(Settings.GetSeed());
        CurrentMap = new Room[Settings.GetMapHeight()][Settings.GetMapWidth()];

        // Loop through each cell in the map the generate its room.
        for (int i = 0; i < CurrentMap.length; i++)
        {
            for (int j = 0; j < CurrentMap[i].length; j++)
            {
                int emptyWeight = Settings.GetEmptyWeight();
                int itemWeight = Settings.GetItemWeight();
                int goldWeight = Settings.GetGoldWeight();
                int trapWeight = Settings.GetTrapWeight();
                int healingWeight = Settings.GetHealingWeight();
                int totalWeight = emptyWeight + itemWeight + goldWeight + trapWeight + healingWeight;

                int random = Rand.Range(0, totalWeight - 1);
                RoomType randomType;

                // Randomly select room type based on weights
                int weightIndex = 0;

                if (random < (weightIndex += goldWeight))
                {
                    randomType = RoomType.Gold;
                }
                else if (random < (weightIndex += itemWeight))
                {
                    randomType = RoomType.Item;
                }
                else if (random < (weightIndex += trapWeight))
                {
                    randomType = RoomType.Trap;
                }
                else if (random < (weightIndex += healingWeight))
                {
                randomType = RoomType.Healing;
                }
                else
                {
                    randomType = RoomType.Empty;
                }

                CurrentMap[i][j] = new Room(randomType, false);
                System.out.println("i: " + i + " j: " + j + " Type: " + CurrentMap[i][j].Type.toString() + " Description: " + CurrentMap[i][j].Description);
            }
        }

        // Randomly overwrite one room to have the Amethyst.
        int amethystX = Rand.Range(0, CurrentMap.length - 1);
        int amethystY = Rand.Range(0, CurrentMap[amethystX].length - 1);
        CurrentMap[amethystX][amethystY] = new Room(RoomType.Item, true);
    }

    /**
     * Displays the map to the console.
     *
     * @param playerLocation The player's current location.
     */
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

    /**
     * Gets the room at the specified location. Takes in an x and y coordinate.
     *
     * @param x The x-coordinate of the room.
     * @param y The y-coordinate of the room.
     * @return The room at the specified location.
     */
    public Room GetRoom(int x, int y)
    {
        return CurrentMap[y][x];
    }

    /**
     * Gets the room at the specified location. Takes in a Pair object for coordinates.
     *
     * @param location The location of the room.
     * @return The room at the specified location.
     */
    public Room GetRoom(Pair<Integer, Integer> location)
    {
        return GetRoom(location.first, location.second);
    }

    /**
     * Gets the amount of rooms visited.
     *
     * @return The amount of rooms visited.
     */
    public int GetVisitedRoomCount()
    {
        int count = 0;

        // Loops over each room in the map and counts the number of visited rooms.
        for (int i = 0; i < CurrentMap.length; i++)
        {
            for (Room item : CurrentMap[i])
            {
                if (item.Visited)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
