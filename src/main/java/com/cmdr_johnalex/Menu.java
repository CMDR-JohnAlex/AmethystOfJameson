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

    public void CharacterCreation()
    {
        Console.Clear();
        System.out.println("Character Creation:");
        System.out.println("Sorry, this is not yet implemented.");
        System.out.println("Press enter to continue...");
        Input.GetEnter();
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
