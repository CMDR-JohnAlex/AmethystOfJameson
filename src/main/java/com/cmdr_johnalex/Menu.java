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

    public void MainMenu()
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
                State.CurrentState = State.CharacterCreation;
                break;
            case 2:
                State.CurrentState = State.Settings;
                Settings();
                break;
            case 3:
                State.CurrentState = State.Credits;
                Credits();
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

        System.out.println("\nPress enter to continue...");
        Input.GetEnter();
    }

    public void CharacterCreation(Player player)
    {
        Console.Clear();
        System.out.println("Character Creation:");


        System.out.println("So, what is the name of this worthy adventurer?");
        player.Data.Name = Input.GetString();
        State.CurrentState = State.Playing;
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
