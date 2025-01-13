package com.cmdr_johnalex;

import com.cmdr_johnalex.Utils.Console;
import com.cmdr_johnalex.Utils.Input;

// The Menu class is responsible for displaying the different menus.
public class Menu
{
    public void Initialize()
    {
    }

    public void Shutdown()
    {
    }

    public void MainMenu(Player player)
    {
        Console.Clear();
        System.out.println("===================");
        System.out.println("       ____");
        System.out.println("      /\\__/\\");
        System.out.println("     /_/  \\_\\");
        System.out.println("     \\ \\__/ /");
        System.out.println("      \\/__\\/");
        System.out.println();
        System.out.println("Amethyst of Jameson");
        System.out.println("===================");
        System.out.println("1. New Game");
        System.out.println("2. Settings");
        System.out.println("3. Credits");
        System.out.println("4. Quit");
        System.out.println("===================");
        System.out.println("Please input a number to select an option.");
        int input = Input.GetInt();

        switch (input)
        {
            case 1:
                Introduction();
                CharacterCreation(player);
                State.CurrentState = State.Playing;
                break;
            case 2:
                State.CurrentState = State.Settings;
                break;
            case 3:
                State.CurrentState = State.Credits;
                break;
            case 4:
                State.CurrentState = State.Quit;
                break;
            case 0:
                State.CurrentState = State.Quit;
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
    }

    public void Introduction()
    {
        Console.Clear();
        System.out.println("Introduction:");
        System.out.println("You are a brave adventurer seeking the Amethyst of Jameson.");
        System.out.println("It is said to be the most valuable gem in the world.");
        System.out.println("Many have tried to find it, but none have succeeded.");
        System.out.println("Will you be the first?");

        // TODO: Expand on the introduction text with some more lore, info about the world, the goal of the player, and how to play the game (controls).

        System.out.println("\nPress enter to continue...");
        Input.GetEnter();
    }

    public void CharacterCreation(Player player)
    {
        Console.Clear();
        System.out.println("Character Creation:");


        System.out.println("So, what is the name of this worthy adventurer?");
        player.Data.Name = Input.GetString();
    }

    public void Win()
    {
        Console.Clear();
        System.out.println("Congratulations! You have found the Amethyst of Jameson!");
        System.out.println("You are now the richest person in the world!");

        // TODO: Expand on the win text and add some stats about the player like room visit count, gold collected, items, etc.
        // Perhaps the player and map class, or just the game class should have a "stat collector" function that will return a struct that will be passed to this function?

        System.out.println("\nPress enter to continue...");
        Input.GetEnter();
        State.CurrentState = State.MainMenu;
    }

    public void Settings()
    {
        Settings.SettingsMenu();
    }

    public void Credits()
    {
        Console.Clear();
        System.out.println("Credits:");
        System.out.println("Sorry, this is not yet implemented.");
        System.out.println("Press enter to continue...");
        Input.GetEnter();
        State.CurrentState = State.MainMenu;
    }
}
