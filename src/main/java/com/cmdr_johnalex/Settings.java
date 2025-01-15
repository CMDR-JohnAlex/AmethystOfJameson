package com.cmdr_johnalex;

import java.util.Random;

import com.cmdr_johnalex.Utils.Console;
import com.cmdr_johnalex.Utils.Input;

// Static Settings class.
// This class is responsible for loading and saving settings, as well as providing read-only access to settings.
// The class is static so that it can be accessed from anywhere in the program.
public class Settings
{
    private static Boolean test = false;

    // Map
    private static int MapWidth = 7;
    private static int MapHeight = 7;
    private static Boolean HideUnvisitedRooms = true;
    private static int EmptyWeight = 20;
    private static int ItemWeight = 30;
    private static int GoldWeight = 30;
    private static int TrapWeight = 10;
    private static int HealingWeight = 3;

    // Random
    private static long Seed = 3307;

    public static final Boolean GetTest()
    {
        return test;
    }

    public static final int GetMapWidth()
    {
        return MapWidth;
    }

    public static final int GetMapHeight()
    {
        return MapHeight;
    }

    public static final long GetSeed()
    {
        return Seed;
    }

    public static final Boolean GetHideUnvisitedRooms()
    {
        return HideUnvisitedRooms;
    }

    public static final int GetEmptyWeight()
    {
        return EmptyWeight;
    }

    public static final int GetItemWeight()
    {
        return ItemWeight;
    }

    public static final int GetGoldWeight()
    {
        return GoldWeight;
    }

    public static final int GetTrapWeight()
    {
        return TrapWeight;
    }

    public static final int GetHealingWeight()
    {
        return HealingWeight;
    }

    public static void Initialize()
    {
        // TODO: Load settings from file.

        // Let's start by making the seed random, and the user can change it in the settings menu.
        Seed = new Random().nextLong();
    }

    public static void Shutdown()
    {
        // TODO: Save settings to file.
    }

    public static void SettingsMenu()
    {
        Console.Clear();
        System.out.println("Settings:");
        System.out.println("1. Test: " + test);
        System.out.println("2. Map Width: " + MapWidth);
        System.out.println("3. Map Height: " + MapHeight);
        System.out.println("4. Hide Unvisited Rooms: " + HideUnvisitedRooms);
        System.out.println("5. Seed: " + Seed);
        System.out.println("6. Empty Room Weight: " + EmptyWeight);
        System.out.println("7. Item Room Weight: " + ItemWeight);
        System.out.println("8. Gold Room Weight: " + GoldWeight);
        System.out.println("9. Trap Room Weight: " + TrapWeight);
        System.out.println("10. Healing Room Weight: " + HealingWeight);

        System.out.println("Input a number to change a setting, or 0 to return to the main menu.");
        int input = Input.GetInt();

        switch (input)
        {
            case 0:
                State.CurrentState = State.MainMenu;
                break;
            case 1:
                System.out.println("Please input a new value for Test (true/false):");
                test = Input.GetBoolean();
                break;
            case 2:
                System.out.println("Please input a new value for Map Width (int):");
                MapWidth = Input.GetInt();
                break;
            case 3:
                System.out.println("Please input a new value for Map Height (int):");
                MapHeight = Input.GetInt();
                break;
            case 4:
                System.out.println("Please input a new value for Hide Unvisited Rooms (true/false):");
                HideUnvisitedRooms = Input.GetBoolean();
                break;
            case 5:
                System.out.println("Please input a new value for Seed (long):");
                Seed = Input.GetInt();
                break;
            case 6:
                System.out.println("Please input a new value for Empty Room Weight (int):");
                EmptyWeight = Input.GetInt();
                break;
            case 7:
                System.out.println("Please input a new value for Item Room Weight (int):");
                ItemWeight = Input.GetInt();
                break;
            case 8:
                System.out.println("Please input a new value for Gold Room Weight (int):");
                GoldWeight = Input.GetInt();
                break;
            case 9:
                System.out.println("Please input a new value for Trap Room Weight (int):");
                TrapWeight = Input.GetInt();
                break;
            case 10:
                System.out.println("Please input a new value for Healing Room Weight (int):");
                HealingWeight = Input.GetInt();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
    }
}
