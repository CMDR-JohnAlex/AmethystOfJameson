package com.cmdr_johnalex;

import com.cmdr_johnalex.Utils.Console;
import com.cmdr_johnalex.Utils.Input;

/**
 * The Menu class is responsible for the displaying and interaction of the game's menus.
 */
public class Menu
{
    /**
     * Initializes the menu.
     */
    public void Initialize()
    {
    }

    /**
     * Shuts down the menu.
     */
    public void Shutdown()
    {
    }

    /**
     * Displays the main menu and handles user input.
     *
     * @param player The player object. Used to pass the player's name to the game.
     */
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

    /**
     * Displays the introduction to the game.
     */
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

    /**
     * Handles the character creation process.
     *
     * @param player The player object. Used to set the player's name.
     */
    public void CharacterCreation(Player player)
    {
        Console.Clear();
        System.out.println("Character Creation:");

        System.out.println("So, what is the name of this worthy adventurer?");
        player.Data.Name = Input.GetString();
    }

    /**
     * Displays the win screen.
     *
     * @param game The game object. Used to get the player's stats.
     */
    public void Win(Game game)
    {
        Console.Clear();
        System.out.println("Congratulations " + game.GetPlayer().Data.Name + "! You have found the Amethyst of Jameson!");
        System.out.println("You are now the richest person in the world!");

        System.out.println("\nYou have completed the game in " + game.GetTurns() + " turns.");
        System.out.println("You have collected " + game.GetPlayer().Data.Gold + " gold.");
        System.out.println("You have visited " + game.GetMap().GetVisitedRoomCount() + " rooms.");
        System.out.println("You have found " + game.GetPlayer().Data.Inventory.size() + " items.");

        System.out.println("\nThank you for playing!");

        System.out.println("\nPress enter to continue...");
        Input.GetEnter();
        State.CurrentState = State.MainMenu;
    }

    /**
     * Displays the lose screen.
     *
     * @param game The game object. Used to get the player's stats.
     */
    public void Lose(Game game)
    {
        Console.Clear();
        System.out.println("You have died.");
        System.out.println("You were a brave adventurer, but you were not good enough.");

        System.out.println("\nYou died after " + game.GetTurns() + " turns.");
        System.out.println("You collected " + game.GetPlayer().Data.Gold + " gold.");
        System.out.println("You visited " + game.GetMap().GetVisitedRoomCount() + " rooms.");
        System.out.println("You found " + game.GetPlayer().Data.Inventory.size() + " items.");

        System.out.println("\nBetter luck next time. Thank you for playing!");

        System.out.println("\nPress enter to continue...");
        Input.GetEnter();
        State.CurrentState = State.MainMenu;
    }

    /**
     * Displays the settings menu.
     */
    public void Settings()
    {
        Settings.SettingsMenu();
    }

    /**
     * Displays the credits.
     */
    public void Credits()
    {
        Console.Clear();
        System.out.println("Credits:");

        System.out.println();
        System.out.println("          Amethyst of Jameson");
        System.out.println();

        System.out.println("Developed by:             CMDR-JohnAlex");
        System.out.println("Executive Producer:       CMDR-JohnAlex");
        System.out.println("Technical Director:       CMDR-JohnAlex");
        System.out.println("Lead Programmer:          CMDR-JohnAlex");
        System.out.println("Gameplay Programmer:      CMDR-JohnAlex");
        System.out.println("UI/UX Programmer:         CMDR-JohnAlex");
        System.out.println("Build Engineer:           CMDR-JohnAlex");
        System.out.println("Technical Writer:         CMDR-JohnAlex");
        System.out.println("Release Manager:          CMDR-JohnAlex");
        System.out.println("Coffee Supplier:          CMDR-JohnAlex");
        System.out.println("Quality Assurance Tester: seagulldotexe");
        System.out.println("Moral Support:            seagulldotexe");

        System.out.println("\nPress enter to continue...");
        Input.GetEnter();
        State.CurrentState = State.MainMenu;
    }
}
